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

import java.io.Serializable;
import org.openmrs.BaseOpenmrsObject;
import org.openmrs.BaseOpenmrsMetadata;

/**
 * It is a model class. It should extend either {@link BaseOpenmrsObject} or {@link BaseOpenmrsMetadata}.
 */
public class SmartaCareCustomApp extends BaseOpenmrsObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	// custom provided by reference application module.
	public static final String MODULE_ID = "smartacarecustomapp4";
	
	public static final String HOME_PAGE_EXTENSION_POINT_ID = "org.openmrs.smartacarecustomapp4.homepageLink";

	public static final String PROCESS_HL7_TASK_NAME = "Process HL7 Task";
	
	public static final long PROCESS_HL7_TASK_INTERVAL = 5L;
	
	public static final String FATHER_NAME_UUID = "51c5e4f4-7e13-11e5-8bcf-feff819cdc9f";	
	public static final String MOTHER_NAME_UUID = "8d871d18-c2cc-11de-8d13-0010c6dffd0f";
	
	// location uuid
	public static final String MAIN_LOCATION_UUID = "aff27d58-a15c-49a6-9beb-d30dcfc0c66e";
	public static final String UCTH_LOCATION_UUID = "bff17e58-b26c-49b5-9ada-e30ecfc0c55d";
	public static final String UUTH_LOCATION_UUID = "cff36a58-c15d-49c6-9beb-a20adfa0d77e";
	
	// provider uuid 
	public static final String DOCTOR_PROVIDER_UUID = "9e7267d9-a92a-4ecb-87f9-ea190191606e";
	public static final String NURSE_PROVIDER_UUID = "3b024b8b-c20a-47cf-baf7-ddf9926ecfb8";
	public static final String CLERK_PROVIDER_UUID = "3e849f95-8ee0-4c7f-a870-e7f79993ea46";
	
	// person uuid
	public static final String DOCTOR_PERSON_UUID = "031a68b2-18cf-4d40-b8c3-9d0886173316"; // Ini Lawan
	public static final String NURSE_PERSON_UUID = "48a93163-6637-47ce-abf6-cf0d20d92857"; // Chioma Lawal
	public static final String CLERK_PERSON_UUID = "ce269917-daf4-4a3e-8fad-b7e323755ec7"; //Musa Obi
	
	private Integer id;
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
}