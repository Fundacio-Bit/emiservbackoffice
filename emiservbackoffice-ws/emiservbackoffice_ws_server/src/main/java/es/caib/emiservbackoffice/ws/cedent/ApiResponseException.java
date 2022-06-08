package es.caib.emiservbackoffice.ws.cedent;

/**
 *
 * @author gdeignacio
 */
public class ApiResponseException extends Exception {
    
    private String code;
    private String type;
    private String body;

    public ApiResponseException(String code, String type, String body, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
        this.setType(type);
        this.setBody(body);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
