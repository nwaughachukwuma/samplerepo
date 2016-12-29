/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.smartacarecustomapp4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleActivator;
import org.openmrs.module.ModuleException;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.appframework.service.AppFrameworkService;
import org.openmrs.module.emrapi.utils.MetadataUtil;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;
import org.openmrs.module.metadatadeploy.bundle.MetadataBundle;
import org.openmrs.module.smartacarecustomapp4.activator.EncounterTypesInitializer;
import org.openmrs.module.smartacarecustomapp4.activator.HtmlFormsInitializer;
import org.openmrs.module.smartacarecustomapp4.activator.Initializer;
import org.openmrs.module.smartacarecustomapp4.activator.LocationInitializer;
import org.openmrs.module.smartacarecustomapp4.activator.PersonInitializer;
import org.openmrs.module.smartacarecustomapp4.activator.PersonTypeInitializer;
import org.openmrs.module.smartacarecustomapp4.activator.ProviderInitializer;

/**
 * This class contains the logic that is run every time this module is either started or stopped.
 */
public class SmartaCareCustomAppActivator extends BaseModuleActivator {
	
	protected Log log = LogFactory.getLog(getClass());
	public final static String ACTIVATOR_MODULE_NAME = "Smartacare App Module";
		
	
	// adopted from lfhcforms module
	public List<Initializer> getInitializers() {
		List<Initializer> l = new ArrayList<Initializer>();
		l.add(new LocationInitializer()); //2
		l.add(new EncounterTypesInitializer()); //1	
		l.add(new PersonTypeInitializer()); //4
		l.add(new HtmlFormsInitializer()); //3				
		l.add(new PersonInitializer());  // 4*
		l.add(new ProviderInitializer()); //5
		return l;
	}
	
	/**
	 * @see ModuleActivator#willRefreshContext()
	 * @see BaseModuleActivator#willRefreshContext()
	 */
	public void willRefreshContext() {
		log.info("Refreshing SmartaCare Custom App Module");
	}
	
	/**
	 * @see ModuleActivator#contextRefreshed()
	 * @see BaseModuleActivator#contextRefreshed()
	 */
	public void contextRefreshed() {
		log.info("SmartaCare Custom App Module refreshed");
	}
	
	/**
	 * @see ModuleActivator#willStart()
	 * @see BaseModuleActivator#willStart()
	 */
	public void willStart() {
		log.info("Starting SmartaCare Custom App Module");
	}
	
	/**
	 * @see ModuleActivator#started()
	 * @see BaseModuleActivator#started()
	 */
	public void started() {
		log.info("SmartaCare Custom App Module started.\nSetting custom admin configuration for SmartaCare Custom App");
		
		try{
			// Disabling the default Patient Registration app (page).
			AppFrameworkService service = Context.getService(AppFrameworkService.class);
			service.disableApp("referenceapplication.registrationapp.registerPatient");
			
			
			try{				
				//===========================================
				// Enable this apps for the Uyo-TH instance.=
				//===========================================
				service.enableApp("referenceapplication.vitals");
				service.enableExtension("referenceapplication.defaultEncounterTemplate");
				service.enableExtension("referenceapplication.realTime.vitals");
				service.enableExtension("referenceapplication.realTime.simpleVisitNote");
				service.enableExtension("referenceapplication.realTime.simpleAdmission");
				service.enableExtension("referenceapplication.realTime.simpleDischarge");
				service.enableExtension("referenceapplication.realTime.simpleTransfer");
				
				//===========================================
				// remove the lines of code above          =
				//===========================================
				
				// enabling RecentVisits widget on clinician facing dashboard, if not enabled
				service.enableApp("coreapps.visits");
				// Enabling the activeVisitStatus fragment, if not enabled
				service.enableExtension("org.openmrs.module.coreapps.patientHeader.secondLineFragments.activeVisitStatus");
				// EnDisabling the Coreapps Start Visit link extension (in the Overall Actions panel), if not enabled
				service.enableExtension("org.openmrs.module.coreapps.createVisit");
				service.enableApp("coreapps.activeVisits");
			}catch(Exception e){
				log.error("Apps and extensions already enabled. More error message reads: ", e);
			}
			
		}catch(Exception e){
			Module mod = ModuleFactory.getModuleById(SmartaCareCustomApp.MODULE_ID);
            ModuleFactory.stopModule(mod);
            throw new RuntimeException("failed to setup the required modules", e);
		}
		
		// preferred approach, using Metadata Deploy module
        deployMetadataPackages(Context.getService(MetadataDeployService.class));

        // deprecated approach, using Metadata Sharing module        
        installMetadataPackages();
        
		// iterate over activators
		for (Initializer initializer : getInitializers()) {
			initializer.started();
		}
	}
		
	// ##copied from referencemetadata module
	public void deployMetadataPackages(MetadataDeployService service) {
        MetadataBundle rolesAndPrivileges = Context.getRegisteredComponent("referenceApplicationRolesAndPrivileges", MetadataBundle.class);
        service.installBundles(Arrays.asList(rolesAndPrivileges));
    }
	
	// ##copied from referencemetadata module
	public void installMetadataPackages() {
        try {
            MetadataUtil.setupStandardMetadata(getClass().getClassLoader());
        }
        catch (Exception e) {
            throw new ModuleException("Failed to load MDS packages", e);
        }
    }
	
	/**
	 * @see ModuleActivator#willStop()
	 * @see BaseModuleActivator#willStop()
	 */
	public void willStop() {
		log.info("Stopping SmartaCare Custom App Module");
	}
	
	/**
	 * @see ModuleActivator#stopped()
	 * @see BaseModuleActivator#stopped()
	 */
	public void stopped() {
		log.info("SmartaCare Custom App Module stopped.\nUnsetting custom admin configuration for SmartaCare Custom App");
		AppFrameworkService service = Context.getService(AppFrameworkService.class);
		service.enableApp("referenceapplication.registrationapp.registerPatient");
		
		for (int i = getInitializers().size() - 1; i >= 0; i--) {
			getInitializers().get(i).stopped();
		}
	}
		
}
