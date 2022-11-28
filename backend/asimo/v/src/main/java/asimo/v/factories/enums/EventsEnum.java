package asimo.v.factories.enums;

import asimo.v.entities.enums.EventType;

public enum EventsEnum {
	FILME(EventType.VIDEO),
	CURTA(EventType.VIDEO),
	TEATRO(EventType.PRESENTATION),
	COMEDIA(EventType.PRESENTATION),
	WORKSHOP(EventType.EDUCATE),
	CURSO(EventType.EDUCATE);
	
	public EventType type;

	private EventsEnum(EventType type) {
		this.type = type;
	}

	public EventType getType() {
		return type;
	}
}
