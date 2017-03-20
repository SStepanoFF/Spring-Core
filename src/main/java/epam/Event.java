package epam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import lombok.Setter;

public class Event {

    @Setter
    private int id;
    @Setter
    private String msg;

    private LocalDateTime date;
    private DateTimeFormatter dtFormatter;

    public Event(LocalDateTime dateTime, DateTimeFormatter dtFormatter) {
        this.id = new Random().nextInt(10);
        this.date = dateTime;
        this.dtFormatter = dtFormatter;
    }

    public String toString() {
        return "Id = " + id + ":  Date is: " + date.format(dtFormatter) + ": Message is: " + msg;
    }

}
