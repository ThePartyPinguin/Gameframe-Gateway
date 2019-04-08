package gateway.model.dto;

import java.util.Date;

public class UserLoginData {

    private String email;

    private String userName;

    private String password;

    private long userId;

    private String userRole;

    private String token;

    private Date lastLogin;

    public UserLoginData() {
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getToken() {
        return token;
    }

    public Date getLastLogin() {
        return lastLogin;
    }
}
