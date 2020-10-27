package encuesta.cocacola.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "encuesta")
public class Encuesta {
	@Id
	public String id;
	
	public Encuesta() {}
	public Encuesta(String id, String email, String tipoCocacola) {
		super();
		this.id = id;
		this.email = email;
		this.tipoCocacola = tipoCocacola;
	}

	@Indexed(unique = true)
	public String email;
	
	public String tipoCocacola;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoCocacola() {
		return tipoCocacola;
	}

	public void setTipoCocacola(String tipoCocacola) {
		this.tipoCocacola = tipoCocacola;
	}
}