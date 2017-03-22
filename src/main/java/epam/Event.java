package epam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Setter;

public class Event {

    @Setter
    private int id;
    @Setter
    private String msg;

    private LocalDateTime date;
    private DateTimeFormatter dtFormatter;

    public Event(int id, LocalDateTime dateTime, DateTimeFormatter dtFormatter) {
        this.id = id;
        this.date = dateTime;
        this.dtFormatter = dtFormatter;
    }

    public String toString() {
        return "Id = " + id + ":  Date is: " + date.format(dtFormatter) + ": Message is: " + msg;
    }

    public enum EventType {
        INFO,
        ERROR,
        LOG;
    }

}
