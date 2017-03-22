package epam.loggers;

import java.util.List;

import epam.Event;

public class CombinedEventLogger implements IEventLogger {

    List<IEventLogger> logers;

    public CombinedEventLogger(List<IEventLogger> logers) {
        this.logers = logers;
    }

    @Override
    public void logEvent(Event event) {
        logers.forEach(logger -> logger.logEvent(event));
    }
}
