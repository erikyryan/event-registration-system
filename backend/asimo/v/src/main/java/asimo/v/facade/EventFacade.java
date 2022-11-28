package asimo.v.facade;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import asimo.v.entities.User;
import asimo.v.entities.enums.EventType;
import asimo.v.factories.FactoryProvider;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.services.EventService;

@Component
public class EventFacade{

	private EventService eventService;
	
	private FactoryProvider provider;
	
	private final String eventKey = "eventType";
	
	public EventFacade(@Lazy EventService eventService) {
		this.eventService = eventService;
	}

	public void create(Object eventObject, User user) {
		EventsEnum eventType = eventService.getEventType(eventObject, eventKey);
		provider.getFactory(eventType.getType()).create(eventType);
	}
}
