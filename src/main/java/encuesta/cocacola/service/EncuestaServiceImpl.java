package encuesta.cocacola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import encuesta.cocacola.model.Encuesta;
import encuesta.cocacola.repository.EncuestaRepository;

@Service
public class EncuestaServiceImpl implements EncuestaService{
	
	private EncuestaRepository encuestaRepository;
	
	EncuestaServiceImpl(EncuestaRepository encuestaRepository){
		this.encuestaRepository = encuestaRepository;
	}
	@Override
	public List<Encuesta> list() {
		return encuestaRepository.findAll();
	}

	@Override
	public Encuesta addEncuesta(Encuesta encuesta) {
	    Encuesta result =new Encuesta();
		try {
			result = encuestaRepository.save(encuesta);
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public void removeEncuesta(String id) {
		try {
			if(encuestaRepository.existsById(id)) {
				encuestaRepository.deleteById(id);
			}
		} catch (Exception e) {
			
		}
	}

	@Override
	public Encuesta updateEncuesta(Encuesta encuesta) {
	    Encuesta result =new Encuesta();
		try {
			result = encuestaRepository.save(encuesta);
		} catch (Exception e) {
		}
		return result;
	}
	@Override
	public Optional<Encuesta> findByIdEncuesta(String id) {
	    Optional<Encuesta> result = Optional.empty();
		try {
			result = encuestaRepository.findById(id);
		} catch (Exception e) {
		}
		return result;
	}

}
