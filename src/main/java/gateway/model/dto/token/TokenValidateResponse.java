package gateway.model.dto.token;

public class TokenValidateResponse{

    private int responseCode;
    private String responseMessage;
    private boolean isValid;
    private long userId;
    private String token;

    public TokenValidateResponse() {
    }

    public TokenValidateResponse(String responseMessage, int responseCode) {
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public boolean isValid() {
        return isValid;
    }

    public long getUserId() {
        return userId;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}