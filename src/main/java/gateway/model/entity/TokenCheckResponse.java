package gateway.model.entity;

public class TokenCheckResponse {

    private boolean validToken;

    private String responseMessage;
    private int responseCode;

    public TokenCheckResponse(boolean validToken, String responseMessage, int responseCode) {
        this.validToken = validToken;
        this.responseMessage = responseMessage;
        this.responseCode = responseCode;
    }

    public boolean isValidToken() {
        return validToken;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
