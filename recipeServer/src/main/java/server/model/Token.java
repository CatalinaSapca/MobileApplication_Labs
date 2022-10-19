package server.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Token implements Serializable {
    String string;

    public Token(String string) {
        this.string = string;
    }
}
