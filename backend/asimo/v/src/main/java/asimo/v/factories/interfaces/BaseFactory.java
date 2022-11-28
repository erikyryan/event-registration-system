package asimo.v.factories.interfaces;

import asimo.v.factories.enums.EventsEnum;

public interface BaseFactory<R> {
	public R create(EventsEnum param);
}
