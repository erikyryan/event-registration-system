package asimo.v.schedule;

import org.springframework.stereotype.Component;

import asimo.v.repositories.FilmRepository;
import asimo.v.services.EventService;

@Component
public class EventOperationSchedule {

	private EventService eventService;
	
	private FilmRepository eventRepository;

	public EventOperationSchedule(EventService eventService, FilmRepository eventRepository) {
		this.eventService = eventService;
		this.eventRepository = eventRepository;
	}

//	@Scheduled(fixedDelay = 6000)
//	public void eventFinalize() {
//		List<FilmLegendado> events = eventService.listToFinalize();
//		for(FilmLegendado event : events) {
//			event.setEventStatus(EventStatus.FINALIZADO);
//			this.eventRepository.save(event);
//		}	
//	}
	
//	@Scheduled(fixedDelay = 6000)
//	public void eventInitialize() {
//		List<FilmLegendado> events = eventService.listToInitializer();
//		for(FilmLegendado event : events) {
//			event.setEventStatus(EventStatus.EM_ANDAMENTO);
//			this.eventRepository.save(event);
//		}
//	}
}