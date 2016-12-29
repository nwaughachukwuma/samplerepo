package org.openmrs.module.smartacarecustomapp4.activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Provider;
import org.openmrs.api.PersonService;
import org.openmrs.api.ProviderService;
import org.openmrs.api.context.Context;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomApp;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomAppActivator;

public class ProviderInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(ProviderInitializer.class);
	/**
	 * @see Initializer#started()
	 */
	@Override
	public void started() {
		// TODO Auto-generated method stub
		log.info("Setting new Providers for " + SmartaCareCustomAppActivator.ACTIVATOR_MODULE_NAME);
		
		ProviderService ps = Context.getProviderService();		
		PersonService perS = Context.getPersonService();
				
		//Setting new providers
		try {			
			//new Provider doctor is Person Ini Lawal
			Provider doctor = ps.getProviderByUuid(SmartaCareCustomApp.DOCTOR_PROVIDER_UUID);
			if(doctor == null){
				doctor = new Provider();
				doctor.setUuid(SmartaCareCustomApp.DOCTOR_PROVIDER_UUID);
				doctor.setName("Ini Lawal");
				doctor.setIdentifier("doctor");
				doctor.setDescription("This is any doctor in the facility");				 
				doctor.setPerson(perS.getPersonByUuid(SmartaCareCustomApp.DOCTOR_PERSON_UUID));
			}
			ps.saveProvider(doctor);
			
			//new Provider nurse is Person Chioma Lawan
			Provider nurse = ps.getProviderByUuid(SmartaCareCustomApp.NURSE_PROVIDER_UUID);
			if(nurse == null){
				nurse = new Provider();
				nurse.setUuid(SmartaCareCustomApp.NURSE_PROVIDER_UUID);
				nurse.setName("Chioma Lawan");
				nurse.setIdentifier("nurse");
				nurse.setDescription("This is any nurse in the facility");				 
				nurse.setPerson(perS.getPersonByUuid(SmartaCareCustomApp.NURSE_PERSON_UUID));
			}
			ps.saveProvider(nurse);
			
			//new Provider clerk is Person Musa Obi
			Provider clerk = ps.getProviderByUuid(SmartaCareCustomApp.CLERK_PROVIDER_UUID);
			if(clerk == null){
				clerk = new Provider();
				clerk.setUuid(SmartaCareCustomApp.CLERK_PROVIDER_UUID);
				clerk.setName("Musa Obi");
				clerk.setIdentifier("clerk");
				clerk.setDescription("This is any clerk in the facility");
				clerk.setPerson(perS.getPersonByUuid(SmartaCareCustomApp.CLERK_PERSON_UUID));
			}
			ps.saveProvider(clerk);
			
		} catch (Exception ex) {
			// TODO: handle exception
			log.error("Cannot set provider due to: "+ ex);
		}
		
	}

	@Override
	public void stopped() {
		// TODO Auto-generated method stub
		
	}

}
