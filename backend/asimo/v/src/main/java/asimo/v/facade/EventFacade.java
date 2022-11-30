package asimo.v.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import asimo.v.entities.generics.Event;
import asimo.v.factories.FactoryProvider;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.factories.interfaces.BaseFactory;
import asimo.v.services.EventService;

@Component
public class EventFacade{
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private FactoryProvider provider;

	public void create(Object eventObject) throws JsonMappingException, JsonProcessingException {
		EventsEnum eventType = eventService.getEventType(eventObject);
		BaseFactory<Event> factory = provider.getFactory(eventType.getType());
		Event event = factory.create(eventType);
		eventService.create(eventObject, event);
	}
}
