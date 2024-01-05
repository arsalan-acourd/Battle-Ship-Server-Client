package dto;

import entity.UserIdentifier;

public class LoginRequestDTO extends BaseRequest {
    public LoginRequestDTO(String userId) {
        super("LOGIN", new UserIdentifier(userId));
    }
}
