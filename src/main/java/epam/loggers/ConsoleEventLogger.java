package epam.loggers;

import epam.Event;

public class ConsoleEventLogger implements IEventLogger {

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
