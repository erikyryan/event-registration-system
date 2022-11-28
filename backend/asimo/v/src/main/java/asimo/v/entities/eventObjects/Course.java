package asimo.v.entities.eventObjects;

import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.Educate;

public class Course extends Event implements Educate {
	
	@Override
	public EventsEnum getEventType() {
		return EventsEnum.CURSO;
	}
}
