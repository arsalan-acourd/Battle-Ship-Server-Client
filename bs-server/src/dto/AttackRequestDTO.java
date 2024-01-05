package dto;

import entity.Position;

public class AttackRequestDTO extends BaseRequest {
    public AttackRequestDTO(Position position) {
        super("ATTACK", position);
    }
}
