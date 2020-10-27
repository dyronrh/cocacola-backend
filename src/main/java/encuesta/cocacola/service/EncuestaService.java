package encuesta.cocacola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import encuesta.cocacola.model.Encuesta;

@Service
public interface EncuestaService {
  
	List<Encuesta> list();
	Encuesta addEncuesta(Encuesta encuesta);
	void removeEncuesta(String id);
	Encuesta updateEncuesta(Encuesta encuesta);
	Optional<Encuesta> findByIdEncuesta(String id);
}
