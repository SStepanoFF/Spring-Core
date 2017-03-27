package epam.loggers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import epam.Event;

public class CashFileEventLogger extends FileEventLogger {

    private int cashSize;
    private List<Event> cash = new ArrayList<>();

    public CashFileEventLogger(String fileName, Integer cashSize) {
        super(fileName);
        this.cashSize = cashSize;
    }

    @Override
    public void logEvent(Event event) {
        cash.add(event);
        if (cash.size() == cashSize) {
            writeEventsFromCash();
            cash.clear();
        }
    }

    private void writeEventsFromCash() {
        cash.forEach(event -> super.logEvent(event));
    }

    @PreDestroy
    private void destroy() {
        if (!cash.isEmpty()) {
            writeEventsFromCash();
        }
    }
}
