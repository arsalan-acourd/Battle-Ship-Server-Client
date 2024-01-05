package dto;

import java.io.Serializable;

public class TurnResponseDTO extends BaseRequest{
    public TurnResponseDTO(String type) {
        super("TURN");
    }
}
