package dto;


public class GameResultRequestDTO extends BaseRequest {
    public GameResultRequestDTO(Boolean  win) {
        super("GAME_RESULT", win);
    }
}
