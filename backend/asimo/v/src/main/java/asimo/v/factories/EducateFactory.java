package asimo.v.factories;

import asimo.v.entities.eventObjects.Course;
import asimo.v.entities.eventObjects.Workshop;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.BaseFactory;

public class EducateFactory implements BaseFactory<Event>{

	@Override
	public Event create(EventsEnum param) {
		switch (param) {
		case WORKSHOP:{
			return new Workshop();
		}
		case CURSO:{
			return new Course();
		}
		default:
			throw new RuntimeException("Evento invalido");
		}
	}
}
