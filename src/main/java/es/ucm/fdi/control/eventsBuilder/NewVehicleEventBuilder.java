package es.ucm.fdi.control.eventsBuilder;

import java.util.ArrayList;

import es.ucm.fdi.ini.IniSection;
import es.ucm.fdi.model.events.Event;
import es.ucm.fdi.model.events.NewVehicleEvent;

public class NewVehicleEventBuilder implements EventBuilder {
	
	public Event parse(IniSection sec) {
		// if("new_vehicle".equals(sec.getTag()) return null;
		if(!sec.getTag().equals("new_vehicle") || sec.getValue("type") != null) return null;
		try{
			int t = parseInt (sec,"time", 0);
			int mS = parseInt (sec, "max_speed", 1);
		
			String id = sec.getValue("id");
			if(isValidId(id)){
				ArrayList <String> idList = parseIdList (sec, "itinerary");
				return new NewVehicleEvent(t, id, mS, idList);
			}
		}catch (IllegalArgumentException i){
			throw new IllegalArgumentException("There has been a problem creating NewVehicleEvent", i);
		}
		return null;
	}

	
}
