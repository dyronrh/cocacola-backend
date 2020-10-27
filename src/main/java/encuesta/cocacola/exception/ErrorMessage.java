package encuesta.cocacola.exception;

import java.util.Date;



public class ErrorMessage {
  private int status;
  private Date timestamp;
  private String message;
  private String description;

  public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
    this.status = statusCode;
    this.timestamp = timestamp;
    this.message = message;
    this.description = description;
  }

  public int getStatusCode() {
    return status;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }
}