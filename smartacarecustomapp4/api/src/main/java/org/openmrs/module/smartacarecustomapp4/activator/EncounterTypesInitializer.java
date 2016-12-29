package org.openmrs.module.smartacarecustomapp4.activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.EncounterType;
import org.openmrs.api.EncounterService;
import org.openmrs.api.context.Context;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomAppActivator;

/**
 * Sets up the Encounter Types required by the HFE forms.
 */
public class EncounterTypesInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(EncounterTypesInitializer.class);

	/**
	 * @see Initializer#started()
	 */
	@Override
	public synchronized void started() {
		log.info("Setting new Encounter Types for " + SmartaCareCustomAppActivator.ACTIVATOR_MODULE_NAME);
		
		EncounterService es = Context.getEncounterService();
		
		{
			String name = "AKI";
			String desc = "For Acute sudden onset of Kidney Injury (AKI) form";
			String uuid = "1628af73-88a6-4609-a4fc-9775f3b7e3df";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
		
		{
			String name = "Anthropometry";
			String desc = "This is the encounter type for anthropometry form";
			String uuid = "01fc1f28-6ae5-4402-846a-40c0302eb1fd";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
		
		{
			String name = "General Nephrology";
			String desc = "This is the encounter type for General nephrology form";
			String uuid = "0960f76d-5461-4463-9f95-fec29e6c2b8f";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
		
		{
			String name = "Haemodialysis Patients";
			String desc = "This is an encounter type for haemodialysis patients' form";
			String uuid = "ef40fc4a-da33-49d5-bd0c-1a2a0921e81b";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
		
		{
			String name = "Laboratory Test";
			String desc = "This is an encounter type for lab. test form";
			String uuid = "d79d5b6c-7b69-4232-86b0-957ab959731f";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
		
		{
			String name = "Medication List";
			String desc = "This is the encounter type for Medication list form";
			String uuid = "a3ae72a9-db2f-41ef-b25f-e57419713725";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
		
		{
			String name = "Transplant Patients";
			String desc = "This encounter type is Transplant Patients form";
			String uuid = "1cd09dc0-8604-41bc-89e0-1dc503c0e50d";
			EncounterType encounterType = es.getEncounterTypeByUuid(uuid);
			if(encounterType == null) {
				encounterType = new EncounterType(name, desc);
				encounterType.setUuid(uuid);
				es.saveEncounterType(encounterType);
			}
		}
	}

	/**
	 * @see Initializer#stopped()
	 */
	@Override
	public void stopped() {
		//TODO: Perhaps disable the encounter types?
	}
}
