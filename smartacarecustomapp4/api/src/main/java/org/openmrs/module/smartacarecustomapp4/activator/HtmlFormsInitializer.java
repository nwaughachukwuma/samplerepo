package org.openmrs.module.smartacarecustomapp4.activator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.FormService;
import org.openmrs.api.context.Context;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.formentryapp.FormEntryAppService;
import org.openmrs.module.formentryapp.FormManager;
import org.openmrs.module.formentryapp.page.controller.forms.ExtensionForm;
import org.openmrs.module.htmlformentry.HtmlForm;
import org.openmrs.module.htmlformentry.HtmlFormEntryService;
import org.openmrs.module.htmlformentryui.HtmlFormUtil;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomApp;
import org.openmrs.module.smartacarecustomapp4.utils.ExtensionFormUtil;
import org.openmrs.ui.framework.resource.ResourceFactory;

/**
 * Sets up the HFE forms
 * 1) Scans the webapp/resources/htmlforms folder
 * 2) Attempts to create an HFE form from each of the files
 * 3) Adds the forms as in Configure Metadata \ Manage Forms
 */
public class HtmlFormsInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(HtmlFormsInitializer.class);

	protected static final String providerName = "smartacarecustomapp4";
	protected static final String formsPath = "htmlforms/";
	
	/**
	 * @see Initializer#started()
	 */
	@Override
	public synchronized void started() {
		log.info("Setting HFE forms for " + "SmartaCare Custom App module");
		
		// trying the exact steps used in ref-app
		try{
			setupHtmlForms();
		}catch(Exception e){
			Module mod = ModuleFactory.getModuleById(SmartaCareCustomApp.MODULE_ID);
            ModuleFactory.stopModule(mod);
            throw new RuntimeException("failed to setup the required modules", e);
		}
		
	}
	
	private void setupHtmlForms() throws Exception {
        try {
             ResourceFactory resourceFactory = ResourceFactory.getInstance();
             FormService formService = Context.getFormService();
             HtmlFormEntryService htmlFormEntryService = Context.getService(HtmlFormEntryService.class);
             
          // Save form + add its meta data
     		final FormManager formManager = Context.getRegisteredComponent("formManager", FormManager.class);
     		final FormEntryAppService hfeAppService = Context.getRegisteredComponent("formEntryAppService", FormEntryAppService.class);

 			 List<String> htmlforms = Arrays.asList("smartacarecustomapp4:htmlforms/AKI.xml",
			    "smartacarecustomapp4:htmlforms/Anthropometry.xml", "smartacarecustomapp4:htmlforms/GeneralNephrology.xml",
			    "smartacarecustomapp4:htmlforms/HaemodialysisPatients.xml", "smartacarecustomapp4:htmlforms/LaboratoryTest.xml",
			    "smartacarecustomapp4:htmlforms/MedicationList.xml", "smartacarecustomapp4:htmlforms/TransplantPatients.xml");
 			 
 			 HtmlForm form = null;
             for (String htmlform : htmlforms) {
            	 //HtmlFormUtil.getHtmlFormFromUiResource(resourceFactory, formService, htmlFormEntryService, htmlform);
            	 try{
            		 form = HtmlFormUtil.getHtmlFormFromUiResource(resourceFactory, formService, htmlFormEntryService, htmlform);
            	 }catch (IOException e) {
     				log.error("Could not generate HTML form from the following resource file: " + htmlform, e);
    				continue;
    			} catch (IllegalArgumentException e) {
    				log.error("Error while parsing the form's XML: " + htmlform, e);
    				continue;
    			}
            	 // form = **above**
              // Adds meta data
     			ExtensionForm extensionForm = null;
     			try {
     				extensionForm = ExtensionFormUtil.getExtensionFormFromUiResourceAndForm(resourceFactory, providerName, htmlform, hfeAppService, formManager, form.getForm());
     			} catch (Exception e) {
     				log.error("The form was created but its extension point could not be created in Manage Forms \\ Configure Metadata: " + htmlform, e);
     				continue;
     			}
             }
        }
        catch (Exception e) {
             // this is a hack to get component test to pass until we find the proper way to mock this
             if (ResourceFactory.getInstance().getResourceProviders() == null) {
                 log.error("Unable to load HTML forms--this error is expected when running component tests");
             }
             else {
                 throw e;
             }
        }
     }

	/**
	 * @see Initializer#stopped()
	 */
	@Override
	public void stopped() {
		//TODO: Perhaps disable the forms?
	}
	
}
