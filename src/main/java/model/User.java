package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private static final String EMAIL = "oanastasia058@gmail.com";
    private static final String PASSWORD = ".5aKAVDh!KCXQnD";
    private String email;
    private String password;

    public User() {
        this.email = EMAIL;
        this.password = PASSWORD;
    }
}
