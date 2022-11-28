package asimo.v.factories;

import asimo.v.entities.eventObjects.Film;
import asimo.v.entities.eventObjects.ShortFilm;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.BaseFactory;

public class VideoFactory implements BaseFactory<Event> {
	
	@Override
	public Event create(EventsEnum param) {
		switch (param) {
		case FILME:{
			return new Film();
		}
		case CURTA:{
			return new ShortFilm();
		}
		default:
			throw new RuntimeException("Evento invalido");
		}
	}
}
