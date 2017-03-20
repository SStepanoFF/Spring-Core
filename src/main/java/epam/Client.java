package epam;

import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Integer id;

    private String name;

    private String greeting;

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
