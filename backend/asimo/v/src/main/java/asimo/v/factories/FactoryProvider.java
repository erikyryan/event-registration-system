package asimo.v.factories;

import asimo.v.entities.enums.EventType;
import asimo.v.factories.interfaces.BaseFactory;

public class FactoryProvider {
	

	public BaseFactory getFactory(EventType type) {
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
		case SPORT:{
//			return new TheaterFactory();
		}
		default:
			throw new RuntimeException("Tipo de Evento Invalido");	
		}
	}
	
	public FactoryProvider() {
	}
}
