package epam;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import epam.loggers.IEventLogger;

public class App {

    private static ConfigurableApplicationContext context;
    private Client client;
    private IEventLogger eventLogger;

    public App(Client client, IEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beanEpam.xml");
        App app = (App) context.getBean("app");
        IEventLogger iEventLogger = app.eventLogger;

        app.logEvent("Event for user 1");
        app.logEvent("Event for user 2");
        app.logEvent("Event for user 3");
        app.logEvent("Event for user 4");
        context.close();
    }

    private void logEvent(String message) {
        Event event = (Event) context.getBean("event");
        String msg = message.replaceAll(String.valueOf(client.getId()), client.getName());
        event.setMsg(msg);
        eventLogger.logEvent(event);
    }
}
