package network;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Response implements Serializable {
    private boolean success;
    private Object data;
    private String message;

}
