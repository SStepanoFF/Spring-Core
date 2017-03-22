package epam;

import java.util.Map;
import java.util.Optional;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.loggers.IEventLogger;

public class App {

    private static ConfigurableApplicationContext context;
    Map<Event.EventType, IEventLogger> loggers;
    private Client client;
    private IEventLogger defaultLogger;

    public App(Client client, IEventLogger eventLogger, Map<Event.EventType, IEventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beanEpam.xml");
        App app = (App) context.getBean("app");

        app.logEvent(Event.EventType.INFO, "Event for user 1");
        app.logEvent(Event.EventType.LOG, "Event for user 2");
        app.logEvent(Event.EventType.ERROR, "Event for user 3");
        app.logEvent(Event.EventType.LOG, "Event for user 4");
        context.close();
    }

    // private void logEvent(String message) {
    // Event event = (Event) context.getBean("event");
    // String msg = message.replaceAll(String.valueOf(client.getId()), client.getName());
    // event.setMsg(client.getGreeting() + msg);
    // defaultLogger.logEvent(event);
    // }

    private void logEvent(Event.EventType eventType, String message) {
        IEventLogger logger = Optional.ofNullable(loggers.get(eventType)).orElse(defaultLogger);
        Event event = (Event) context.getBean("event");
        String msg = message.replaceAll(String.valueOf(client.getId()), client.getName());
        event.setMsg(client.getGreeting() + msg);
        logger.logEvent(event);
    }
}
