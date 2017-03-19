package epam;

import lombok.Getter;

public class Client {

    @Getter
    private int id;

    @Getter
    private String name;

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
