package server.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Message implements Serializable {
    private String email;
    private String subject;

    public Message(String email, String subject) {
        this.email = email;
        this.subject = subject;
    }
}
