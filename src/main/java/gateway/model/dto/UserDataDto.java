package gateway.model.dto;

public class UserDataDto {

    private long userId;
    private String userName;
    private String token;

    public UserDataDto(long userId, String userName, String token) {
        this.userId = userId;
        this.userName = userName;
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }
}
