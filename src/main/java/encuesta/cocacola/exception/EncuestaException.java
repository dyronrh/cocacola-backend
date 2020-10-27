package encuesta.cocacola.exception;


public class EncuestaException extends Exception{
	 private static final long serialVersionUID =1L;
	 private String detalle;
	 private String mensajeError;
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}
