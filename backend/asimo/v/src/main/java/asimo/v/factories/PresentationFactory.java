package asimo.v.factories;

import asimo.v.entities.eventObjects.Comedy;
import asimo.v.entities.eventObjects.Theater;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.BaseFactory;

public class PresentationFactory implements BaseFactory<Event> {
	
	@Override
	public Event create(EventsEnum param) {
		switch (param) {
		case TEATRO:{
			return new Theater();
		}
		case COMEDIA:{
			return new Comedy();
		}
		default:
			throw new RuntimeException("Evento invalido");
		}
	}
}
