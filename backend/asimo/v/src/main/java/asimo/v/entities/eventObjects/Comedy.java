package asimo.v.entities.eventObjects;

import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Presentation;

public class Comedy extends Event implements Presentation {

	
	public Comedy() {
	}
	
	@Override
	public EventsEnum getEventType() {
		return EventsEnum.COMEDIA;
	}
}
