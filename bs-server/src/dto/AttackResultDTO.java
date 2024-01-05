package dto;


public class AttackResultDTO extends BaseRequest {
    public AttackResultDTO(AttackResult result) {
        super("ATTACK_RESULT", result);
    }
}
