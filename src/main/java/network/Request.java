package network;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Request implements Serializable {
    private CommandType commandType;
    private Object data;

}
