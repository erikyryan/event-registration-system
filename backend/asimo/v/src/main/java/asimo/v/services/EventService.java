package asimo.v.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import asimo.v.entities.Session;
import asimo.v.entities.dto.EventAvailableDTO;
import asimo.v.entities.dto.EventBillingDTO;
import asimo.v.entities.enums.MovieType;
import asimo.v.entities.enums.TheaterType;
import asimo.v.entities.eventObjects.Comedy;
import asimo.v.entities.eventObjects.Course;
import asimo.v.entities.eventObjects.Film;
import asimo.v.entities.eventObjects.ShortFilm;
import asimo.v.entities.eventObjects.Theater;
import asimo.v.entities.eventObjects.Workshop;
import asimo.v.entities.generics.Event;
import asimo.v.factories.enums.EventsEnum;
import asimo.v.repositories.ComedyRepository;
import asimo.v.repositories.CourseRepository;
import asimo.v.repositories.FilmRepository;
import asimo.v.repositories.ShortFilmRepository;
import asimo.v.repositories.TheaterRepository;
import asimo.v.repositories.WorkshopRepository;

@Service
public class EventService {

	private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setLenient().create();
	
	private SessionService sessionService;

    private FilmRepository filmRepository;
    
    private ComedyRepository comedyRepository;
    
    private CourseRepository courseRepository;
    
    private ShortFilmRepository shortFilmRepository;
    
    private TheaterRepository theaterRepository;
    
    private WorkshopRepository workshopRepository;
    
    private ObjectMapper mapper = new ObjectMapper();

    private final String key = "eventType";
    
    public EventService(SessionService sessionService, FilmRepository eventRepository,
			ComedyRepository comedyRepository, CourseRepository courseRepository,
			ShortFilmRepository shortFilmRepository, TheaterRepository theaterRepository,
			WorkshopRepository workshopRepository) {
		this.sessionService = sessionService;
		this.filmRepository = eventRepository;
		this.comedyRepository = comedyRepository;
		this.courseRepository = courseRepository;
		this.shortFilmRepository = shortFilmRepository;
		this.theaterRepository = theaterRepository;
		this.workshopRepository = workshopRepository;
	}

//	public FilmLegendado findByEventIdentifier(String eventIdentifier){
//        Optional<FilmLegendado> event = this.filmRepository.findByFilmIdentifier(eventIdentifier);
//        if (event.isPresent() && event.get().getEventStatus() != EventStatus.FINALIZADO) {
//            return event.get();
//        }
//        throw new RuntimeException("Evento não encontrado");
//    }

    public EventsEnum getEventType(Object eventObject) {
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) eventObject;
			EventsEnum eventType = EventsEnum.valueOf(map.get(key));
			return eventType;
		} catch (Exception e) {
			throw new RuntimeException("Tipo de evento invalido");
		}
    }
  
    public MovieType getFilmType(Object eventObject, String eventKey) {
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) eventObject;
			MovieType eventType = MovieType.valueOf(map.get(eventKey));
			return eventType;
		} catch (Exception e) {
			throw new RuntimeException("Tipo de evento invalido");
		}
    }

    public TheaterType getTheaterType(Object eventObject, String eventKey) {
		try {
			LinkedHashMap<String, String> map = (LinkedHashMap<String, String>) eventObject;
			TheaterType eventType = TheaterType.valueOf(map.get(eventKey));
			return eventType;
		} catch (Exception e) {
			throw new RuntimeException("Tipo de evento invalido");
		}
    }
    
//    public FilmLegendado create(final EventObject eventObject, final User user){
//
//        if(user.isAdmin()){
//            validateCreationEvent(eventObject);
//            FilmLegendado event =  new FilmLegendado(eventObject);
//            filmRepository.save(event);
//            return event;
//        }
//
//        throw new RuntimeException("Não foi possível salvar");
//    }

    public void create(Object eventObject,Event event) throws JsonMappingException, JsonProcessingException {
    	EventsEnum eventType = event.getEventType();
    	
    	String jsonObject = gson.toJson(eventObject);
    	
    	if (eventType.equals(EventsEnum.COMEDIA)) {
    		Comedy createdObject = mapper.readValue(jsonObject, Comedy.class);
    		comedyRepository.save(createdObject);
    		
		}else if (eventType.equals(EventsEnum.CURSO)) {
			Course createdObject = mapper.readValue(jsonObject, Course.class);
    		courseRepository.save(createdObject);
    		
		}else if (eventType.equals(EventsEnum.CURTA)) {
			ShortFilm createdObject = mapper.readValue(jsonObject, ShortFilm.class);
    		shortFilmRepository.save(createdObject);
    		
		}else if (eventType.equals(EventsEnum.FILME)) {
			Film createdObject = mapper.readValue(jsonObject, Film.class);
    		filmRepository.save(createdObject);
    		
		}else if (eventType.equals(EventsEnum.TEATRO)) {
			Theater createdObject = mapper.readValue(jsonObject, Theater.class);
    		theaterRepository.save(createdObject);
    		
		}else if (eventType.equals(EventsEnum.WORKSHOP)) {
			Workshop createdObject = mapper.readValue(jsonObject, Workshop.class);
    		workshopRepository.save(createdObject);
    		
		}else {
			throw new RuntimeException("Erro");
		}
    }
    
//    private void validateCreationEvent(EventObject eventObject) {
//        if (filmRepository.findByNameAndFilmStartDateAndLaunchYear(eventObject.getName(),eventObject.getEventStartDate(),eventObject.getLaunchYear()).isPresent()) {
//            throw new InvalidEvent("Evento Inválido");
//        }
//
//        if (filmRepository.findByNameAndFilmStartDate(eventObject.getName(),eventObject.getEventStartDate()).isPresent()) {
//            throw new InvalidEvent("Evento Inválido");
//        }
//    }

	public List<EventBillingDTO> billingGenerate(Date date, String sessionId) {
		List<EventBillingDTO> bilingDTO = new ArrayList<EventBillingDTO>();
		if(date != null && sessionId != null){
			Session session = this.sessionService.findByIdentifierAndDate(date, sessionId);
			Integer amount = this.sessionService.soldAmount(session);
			Long soldAmount = this.sessionService.soldValue(session);
			
			EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
			bilingDTO.add(billing);
			
			return bilingDTO;
		}else if (date != null) {
			List<Session> sessions = this.sessionService.findByDate(date);
			
			for(Session session: sessions) {
				Integer amount = this.sessionService.soldAmount(session);
				Long soldAmount = this.sessionService.soldValue(session);
				
				EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
				
				bilingDTO.add(billing);
			}

			return bilingDTO;
		}else if (sessionId != null) {
			Session session = this.sessionService.findBySessionIdentifier(sessionId);
			Integer amount = this.sessionService.soldAmount(session);
			Long soldAmount = this.sessionService.soldValue(session);
			
			EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
			bilingDTO.add(billing);
			
			return bilingDTO;
		}else{
			List<Session> sessions = this.sessionService.listAllAvailable();
			
			for(Session session: sessions) {
				Integer amount = this.sessionService.soldAmount(session);
				Long soldAmount = this.sessionService.soldValue(session);
				
				EventBillingDTO billing = new EventBillingDTO(session, amount, soldAmount);
				bilingDTO.add(billing);
			}
			return bilingDTO;
		}
	}

	
    public List<EventAvailableDTO> listAllAvailable(){
    	List<EventAvailableDTO> all = new ArrayList<EventAvailableDTO>();
    	all.addAll(comedyToEventDTO());
    	all.addAll(courseToEventDTO());
    	all.addAll(filmToEventDTO());
    	all.addAll(shortToEventDTO());
    	all.addAll(theaterToEventDTO());
    	all.addAll(workshopToEventDTO());
    	
    	return all;
    }

	private List<EventAvailableDTO> workshopToEventDTO() {
		return workshopRepository.findAll().stream()
				.map(c -> new EventAvailableDTO(c)).collect(Collectors.toList());
	}
	
	private List<EventAvailableDTO> theaterToEventDTO() {
		return theaterRepository.findAll().stream()
				.map(c -> new EventAvailableDTO(c)).collect(Collectors.toList());
	}
	
	private List<EventAvailableDTO> shortToEventDTO() {
		return shortFilmRepository.findAll().stream()
				.map(c -> new EventAvailableDTO(c)).collect(Collectors.toList());
	}
	
	private List<EventAvailableDTO> comedyToEventDTO() {
		return comedyRepository.findAll().stream()
				.map(c -> new EventAvailableDTO(c)).collect(Collectors.toList());
	}

	private List<EventAvailableDTO> courseToEventDTO() {
		return courseRepository.findAll().stream()
				.map(c -> new EventAvailableDTO(c)).collect(Collectors.toList());
	}
	
	private List<EventAvailableDTO> filmToEventDTO() {
		return filmRepository.findAll().stream()
				.map(c -> new EventAvailableDTO(c)).collect(Collectors.toList());
	}
//    public List<FilmLegendado> listBySessionAndDate(String sessionId, Date date){
//    	
//    	return null;
//    }
    
//	public List<FilmLegendado> listToFinalize() {
//        List<FilmLegendado> events = filmRepository.findByEventStatus(EventStatus.EM_ANDAMENTO);
//        return events.stream().
//                filter(e -> e.getEventEndDate().before(new Date()))
//                .collect(Collectors.toList());
//	}

//	public List<FilmLegendado> listToInitializer() {
//        List<FilmLegendado> events = filmRepository.findByEventStatus(EventStatus.AGENDADO);
//        return events.stream()
//    			.filter(e -> e.getEventStartDate().before(new Date()))
//    			.collect(Collectors.toList());
//	}
}
