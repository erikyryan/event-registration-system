package asimo.v.entities.enums;

public enum EventType {
	VIDEO,
	PRESENTATION,
	EDUCATE;
	
	private EventType() {
	}
	
	public EventType getType(String type) {
		return EventType.valueOf(type);
	}
	
}
