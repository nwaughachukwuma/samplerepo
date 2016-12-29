package org.openmrs.module.smartacarecustomapp4.activator;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.PersonAttributeType;
import org.openmrs.api.context.Context;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomAppActivator;

/**
 * Creation of new person attribute types that are used with the registration app.
 * @author Dimitri Renault
 */
public class PersonTypeInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(PersonTypeInitializer.class);

	/**
	 * @see Initializer#started()
	 */
	@Override
	public synchronized void started() {
		log.info("Setting 'person attribute type' configuration for " + SmartaCareCustomAppActivator.ACTIVATOR_MODULE_NAME);
		
		{
			String uuid = "d6eab6e1-9521-41de-ae2a-1eac465d3e53";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Next of Kin");
				type.setDescription("The person's next of kin");
				type.setFormat("java.lang.String");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "3fdff8cb-39ac-429c-a763-644c4da32fab";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Next of Kin's Phone Number");
				type.setDescription("Person's next of kin's phone number");
				type.setFormat("java.lang.String");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "a0c41413-ea71-4bad-a608-cb2ef8b4033f";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Referral Source");
				type.setDescription("Place where the person was referred from");
				type.setFormat("java.lang.String");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "09e0259d-2b59-48ab-b1b3-d9ccdfa9bd07";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Anthropometry");
				type.setDescription("Person's anthropometric measurements");
				type.setFormat("org.openmrs.Concept");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "bb1bd82c-efd1-45d8-9ea9-317a141aad5b";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Region");
				type.setDescription("Region of the country where the person is from");
				type.setFormat("java.lang.String");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "284f6658-ada2-47d3-8003-86a16cd0de31";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Ethnicity");
				type.setDescription("Person's ethnic group");
				type.setFormat("java.lang.String");
			}
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "72426047-d073-4734-a970-15d08e389c87";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Language");
				type.setDescription("Person's primary language");
				type.setFormat("java.lang.String");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "82d20932-e092-4833-8a0c-5ba585ceb0e3";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Occupation");
				type.setDescription("Person's occupation");
				type.setFormat("java.lang.String");
			}			
			Context.getPersonService().savePersonAttributeType(type);
		}
		
		{
			String uuid = "136f15b8-7f57-4a46-8679-f431091c34f7";
			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
			if(type == null) {
				type = new PersonAttributeType();
				type.setUuid(uuid);
				type.setName("Average Monthly Income");
				type.setDescription("Person's average monthly income");
				type.setFormat("java.lang.Float");				
			}
			Context.getPersonService().savePersonAttributeType(type);
						
		}	
		


//		{
//			String uuid = LFHCFormsConstants.FATHER_OCCUPATION_UUID;
//			PersonAttributeType type = Context.getPersonService().getPersonAttributeTypeByUuid(uuid);
//			if(type == null) {
//				type = new PersonAttributeType();
//				type.setUuid(uuid);
//			}
//			type.setName("Father's Occupation");
//			type.setDescription("Father's occupation or work employment");
//			type.setFormat("java.lang.String");
//			Context.getPersonService().savePersonAttributeType(type);
//		}
		
	}

	/**
	 * @see Initializer#stopped()
	 */
	@Override
	public void stopped() {
		log.info("Unsetting 'person' configuration for " + SmartaCareCustomAppActivator.ACTIVATOR_MODULE_NAME);
	}
}
