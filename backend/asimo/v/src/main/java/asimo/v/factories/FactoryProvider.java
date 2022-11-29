package asimo.v.factories;

import org.springframework.stereotype.Component;

import asimo.v.entities.enums.EventType;
import asimo.v.entities.generics.Event;
import asimo.v.factories.interfaces.BaseFactory;

@Component
public class FactoryProvider {
	
	public FactoryProvider() {
	}
	
	public BaseFactory<Event> getFactory(EventType type) {
		switch (type) {
		case EDUCATE:{
			return new EducateFactory();
		}
		case VIDEO:{
			return new VideoFactory();
		}
		case PRESENTATION:{
			return new PresentationFactory();
		}
		default:
			throw new RuntimeException("Tipo de Evento Invalido");	
		}
	}
}
