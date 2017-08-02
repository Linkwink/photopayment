package ua.com.pb.photopay.infrastructure.exceptions;

/**
 * Created by dn110592kvo on 20.07.2017.
 */
public class JsonException {
    private int code;
    private String message;

    public JsonException() {
    }

    public JsonException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
