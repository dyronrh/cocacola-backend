package encuesta.cocacola.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import encuesta.cocacola.exception.EncuestaException;
import encuesta.cocacola.exception.ResourceNotFoundException;
import encuesta.cocacola.model.Encuesta;
import encuesta.cocacola.service.EncuestaService;

@RestController
public class EncuestaController {
	
	@Autowired
	private EncuestaService encuestaService;
	
	private static final String INTERNAL_ERROR="Error interno del sistema";
	

	
	@GetMapping(path = "/list")
	@CrossOrigin (origins = "${cross}")
	public ResponseEntity<List<Encuesta>>  listChatByUserOrigen(){
		List<Encuesta> result = new ArrayList<>();
		try {
			
			result = encuestaService.list();
			if (result.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(path = "/add")
	@CrossOrigin (origins = "${cross}")
	public ResponseEntity<Encuesta> add(@RequestBody Encuesta body) throws EncuestaException{
		Encuesta encuesta =new Encuesta();
		try {
			encuesta = encuestaService.addEncuesta(body);
			
		} catch (Exception e) {
    		EncuestaException er = new EncuestaException();
    		er.setDetalle(INTERNAL_ERROR);
    		er.setMensajeError(e.getMessage());
    		throw er;
		}
		return new ResponseEntity<>(encuesta,HttpStatus.OK);
	}
	
	
    @PutMapping(path = "/{id}")
    @CrossOrigin (origins = "${cross}")
    public ResponseEntity<Encuesta> update(@PathVariable String id, @RequestBody Encuesta updatedEncuesta) throws ResourceNotFoundException,EncuestaException{
    	Optional<Encuesta> encuesta =Optional.empty();
    	Encuesta encuestaResult =new Encuesta();
    	try {
    		encuesta = encuestaService.findByIdEncuesta(id);
			if(encuesta.isPresent()) {
				encuestaResult.setEmail(updatedEncuesta.getEmail());
				encuestaResult.setTipoCocacola(updatedEncuesta.getTipoCocacola());
				encuestaResult =encuestaService.addEncuesta(updatedEncuesta);
				
			}else {
				
				ResourceNotFoundException ex = new ResourceNotFoundException();
				ex.setDetail("No encontrado el id = " + id);
				throw ex;
			}
		}
    	catch (Exception e) {
    		throw e;
		}
    	return new ResponseEntity<>(encuestaResult,HttpStatus.OK);
    
    }
    @DeleteMapping(path = "/{id}")
   // @Transactional //added
    @CrossOrigin (origins = "${cross}")
    public ResponseEntity<HttpStatus> deleteEncuesta(@PathVariable String id) throws ResourceNotFoundException, Exception {
    	Optional<Encuesta> encuesta =Optional.empty();
    	try {
    		encuesta = encuestaService.findByIdEncuesta(id);
			if(encuesta.isPresent()) {
				encuestaService.removeEncuesta(id);
				
			}else {
				
				ResourceNotFoundException ex = new ResourceNotFoundException();
				ex.setDetail("No encontrado el id = " + id);
				throw ex;
			}
		}
    	catch (ResourceNotFoundException e) {
    		e.setDetail("No encontrado el id = " + id);
			throw e;
		}
    	catch (Exception e) {
    		throw e;
		}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
