package dto;

import entity.UserIdentifier;

public class SignUpResponseDTO extends BaseRequest {
    public SignUpResponseDTO(String userId) {
        super("SIGN_UP", new UserIdentifier(userId));
    }
}
