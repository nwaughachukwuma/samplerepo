package org.openmrs.module.smartacarecustomapp4.activator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Location;
import org.openmrs.LocationTag;
import org.openmrs.api.LocationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomApp;
import org.openmrs.module.smartacarecustomapp4.SmartaCareCustomAppActivator;

public class LocationInitializer implements Initializer {

	protected static final Log log = LogFactory.getLog(LocationInitializer.class);
	/**
	 * @see Initializer#started()
	 */
	@Override
	public void started() {
		// TODO Auto-generated method stub
		log.info("Setting new Location Attributes Types for " + SmartaCareCustomAppActivator.ACTIVATOR_MODULE_NAME);
		
		LocationService ls = Context.getLocationService();
		
		List<Location> locs = new ArrayList<Location>();
		locs.add(ls.getLocationByUuid(SmartaCareCustomApp.MAIN_LOCATION_UUID));
		locs.add(ls.getLocationByUuid(SmartaCareCustomApp.UCTH_LOCATION_UUID));
		locs.add(ls.getLocationByUuid(SmartaCareCustomApp.UUTH_LOCATION_UUID));
		
		try{
			// get all location Tags
			HashSet<LocationTag> locationTags = new HashSet<LocationTag>(ls.getAllLocationTags());
			List<Location> locations = ls.getAllLocations();
			
			// retire other locations with login location tag.
			for (LocationTag lcTag : locationTags) {
				if (lcTag.toString().equalsIgnoreCase("Login Location")){
					for (Location lc : locations) {
						try{
							if (lc.hasTag(lcTag.toString())){
								if (!locs.contains(lc)){
									lc.removeTag(lcTag);
									//ls.retireLocation(lc, "Not needed in this custom instance");
									ls.saveLocation(lc);
								}
							}					
						}catch(Exception ex){
							log.error("Cannot perform any this action on the location");
						}
					}
				}
			}
			
		}catch(Exception ex){
			log.error("Locations do not exist");
		}	
		
		try{
		// Setting custom locations.
		//{
			Location mainLocation = ls.getLocationByUuid(SmartaCareCustomApp.MAIN_LOCATION_UUID);
			if (mainLocation == null) {
				mainLocation = new Location();
				mainLocation.setUuid(SmartaCareCustomApp.MAIN_LOCATION_UUID);
				// mainLocation.setTags(new HashSet<LocationTag>(ls.getAllLocationTags()));
			}
			log.info("mainLocation already exists");
			if(mainLocation.isRetired())
				ls.unretireLocation(mainLocation);
			mainLocation.setName("UTH, Dialysis Unit");
			mainLocation.setDescription("University Teaching Hospital, Dialysis Unit");
			mainLocation.setCountry("Nigeria");			
			ls.saveLocation(mainLocation);
			
		//}
		
		//{
			Location ucthLocation = ls.getLocationByUuid(SmartaCareCustomApp.UCTH_LOCATION_UUID);
			if (ucthLocation == null) {
				ucthLocation = new Location();
				ucthLocation.setUuid(SmartaCareCustomApp.UCTH_LOCATION_UUID);
				ucthLocation.setTags(new HashSet<LocationTag>(ls.getAllLocationTags()));
			}
			log.info("UCTHLocation already exists");
			if(ucthLocation.isRetired())
				ls.unretireLocation(ucthLocation);
			if(!ucthLocation.hasTag("Login Location"))
				resolveTags(ucthLocation, ls); //add Login Location tag if it doesn't exist
			ucthLocation.setName("UCTH, Calabar");
			ucthLocation.setDescription("University of Calabar Teaching Hospital, Dialysis Unit");
			ucthLocation.setParentLocation(mainLocation);//ls.getLocationByUuid(SmartaCareCustomApp.MAIN_LOCATION_UUID));
			ucthLocation.setStateProvince("Cross Rivers");
			ucthLocation.setCountry("Nigeria");
			ls.saveLocation(ucthLocation);
			
		//}
		
		//{
			Location uuthLocation = ls.getLocationByUuid(SmartaCareCustomApp.UUTH_LOCATION_UUID);
			if (uuthLocation == null) {
				uuthLocation = new Location();
				uuthLocation.setUuid(SmartaCareCustomApp.UUTH_LOCATION_UUID);
				uuthLocation.setTags(new HashSet<LocationTag>(ls.getAllLocationTags()));
			}
			log.info("UUTHLocation already exists");
			if(uuthLocation.isRetired())
				ls.unretireLocation(uuthLocation);
			if(!uuthLocation.hasTag("Login Location"))
				resolveTags(uuthLocation, ls); //add Login Location tag if it doesn't exist
			uuthLocation.setName("UUTH, Uyo");
			uuthLocation.setDescription("University of Uyo Teaching Hospital, Dialysis Unit");
			uuthLocation.setParentLocation(mainLocation);//ls.getLocationByUuid(SmartaCareCustomApp.MAIN_LOCATION_UUID));
			uuthLocation.setStateProvince("Akwa Ibom");
			uuthLocation.setCountry("Nigeria");
			ls.saveLocation(uuthLocation);
			
		}catch(Exception ex){
			log.error("Cannot generate new locations for SmartacareCustomApp. Error msg is "+ ex);
		}
			
		//}
		
//		{
//			String name = "Color";
//			String desc = "Attribute type that records the color of the location";
//			String uuid = LFHCFormsConstants.COLOR_LOCATION_ATTRIBUTE_TYPE_UUID;
//			String dataType = FreeTextDatatype.class.getName();
//			Location locationAttrType = ls.getLocationAttributeTypeByUuid(uuid);
//			if(locationAttrType == null) {
//				locationAttrType = new LocationAttributeType();
//				locationAttrType.setName(name);
//				locationAttrType.setDescription(desc);
//				locationAttrType.setUuid(uuid);
//				locationAttrType.setDatatypeClassname(dataType);
//				ls.saveLocationAttributeType(locationAttrType);
//			}else {
//				log.info("UUID of Location Attribute Type \"" + name + "\" already exists. Not saving the Location Attribute Type");
//			}
//		}		
		
	}
	
	// add missing tags a result of deleting all other location tags with Login Location.
	// This solution is needed when upgrading the module or re-adding it to the module
	// dir.
	public void resolveTags(Location loc, LocationService ls){
		HashSet<LocationTag> locTags = new HashSet<LocationTag>(ls.getAllLocationTags());
		for (LocationTag lt: locTags){
			if(!loc.hasTag(lt.toString())){
				loc.addTag(lt);
			}
		}
	}

	@Override
	public void stopped() {
		// TODO Auto-generated method stub
		
	}
	
}
