package es.caib.emiservbackoffice.ws.cedent;

/**
 *
 * @author gdeignacio
 */
public class WrongApiStatusException extends Exception {
    
    private String body;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WrongApiStatusException(String status, String body, String message, Throwable cause) {
        super(message, cause);
        this.setBody(body);
        this.setStatus(status);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
}
