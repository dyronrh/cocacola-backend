package encuesta.cocacola.exception;

public class ResourceNotFoundException extends Exception {

	  private static final long serialVersionUID = 1L;

	  private String detail;
	  
	  public ResourceNotFoundException(){}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
