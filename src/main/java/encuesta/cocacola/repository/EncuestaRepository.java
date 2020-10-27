package encuesta.cocacola.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import encuesta.cocacola.model.Encuesta;

public interface EncuestaRepository extends MongoRepository<Encuesta, String> {

}
