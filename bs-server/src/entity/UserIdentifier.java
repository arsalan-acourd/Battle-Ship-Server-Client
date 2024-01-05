package entity;

import java.io.Serializable;

public class UserIdentifier implements Serializable {
    public String userId;

    public UserIdentifier(String userId) {
        this.userId = userId;
    }
}
