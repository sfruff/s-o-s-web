package ge.tsu.sosweb.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class User {
    private int id;
    private String name;
    private String password;
}

