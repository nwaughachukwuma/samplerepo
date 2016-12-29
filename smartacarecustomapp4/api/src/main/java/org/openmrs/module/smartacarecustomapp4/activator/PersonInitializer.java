package org.openmrs.module.smartacarecustomapp4.activator;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Person;
import org.openmrs.PersonName;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomApp;

public class PersonInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(PersonInitializer.class);
	
	@Override
	public void started() {
		// TODO Auto-generated method stub
		
		PersonService ps = Context.getPersonService();
		
		//Create Person for the providers.
		try {
			// Person Doctor: jakes Smith is Ini Lawal.
			Person jakeSmith = ps.getPersonByUuid(SmartaCareCustomApp.DOCTOR_PERSON_UUID);
			PersonName jakeSmithName = ps.parsePersonName("Ini, Lawal");
			if (jakeSmith == null){
				jakeSmith = new Person();
				jakeSmith.setUuid(SmartaCareCustomApp.DOCTOR_PERSON_UUID);
				jakeSmith.addName(jakeSmithName);
				jakeSmith.setBirthdate(new Date(500000000000L));
				jakeSmith.setGender("Male");
			}
			ps.savePerson(jakeSmith);
			
			// Person Nurse: jane Smith is Chioma Lawan.
			Person janeSmith = ps.getPersonByUuid(SmartaCareCustomApp.NURSE_PERSON_UUID);
			PersonName janeSmithName = ps.parsePersonName("Chioma, Lawan");
			if (janeSmith == null){
				janeSmith = new Person();
				janeSmith.setUuid(SmartaCareCustomApp.NURSE_PERSON_UUID);
				janeSmith.addName(janeSmithName);
				janeSmith.setBirthdate(new Date(500000000000L));
				janeSmith.setGender("Female");
			}
			ps.savePerson(janeSmith);
			
			// Person Doctor: john Smith is Musa Obi.
			Person johnSmith = ps.getPersonByUuid(SmartaCareCustomApp.CLERK_PERSON_UUID);
			PersonName johnSmithName = ps.parsePersonName("Musa, Obi");
			if (johnSmith == null){
				johnSmith = new Person();
				johnSmith.setUuid(SmartaCareCustomApp.CLERK_PERSON_UUID);
				johnSmith.addName(johnSmithName);
				johnSmith.setBirthdate(new Date(500000000000L));
				johnSmith.setGender("Male");
			}
			ps.savePerson(johnSmith);
		
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Cannot create person name due to: " + e);
		}
		
	}

	@Override
	public void stopped() {
		// TODO Auto-generated method stub
		
	}

}
