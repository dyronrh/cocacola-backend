package encuestacocacola;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import encuesta.cocacola.model.Encuesta;
import encuesta.cocacola.repository.EncuestaRepository;
import encuesta.cocacola.service.EncuestaService;

@SpringBootTest
class EncuestaServiceUnitTest {

    @Autowired
    private EncuestaService encuestaService;
    
    @MockBean
    private EncuestaRepository encuestaRepository;
    
    private static final int TOTAL_ENCUESTAS = 6;
    private static final List<String> PERMITIDOS_TIPOS = new ArrayList<>( 
            List.of("Light", "Sin azúcar", "normal","no tomo")); 
  
    
    @BeforeEach
    public void init() {

    	encuestaRepository.deleteAll();

    	encuestaRepository.save(new Encuesta("1","correo1@gmail.com", "no tomo"));
    	encuestaRepository.save(new Encuesta("2","correo2@gmail.com", "no tomo"));
    	encuestaRepository.save(new Encuesta("3","correo3@gmail.com", "no tomo"));
    	encuestaRepository.save(new Encuesta("4","correo4@gmail.com", "no tomo"));
    	encuestaRepository.save(new Encuesta("5","correo5@gmail.com", "no tomo"));
    	encuestaRepository.save(new Encuesta("6","correo6@gmail.com", "no tomo"));
    }




    @Test
    public void verificarEmailEncuesta() {
        Encuesta encuesta = encuestaRepository.save(new Encuesta("7","correo7@gmail.com", "Original"));
        assertThat(encuesta.getEmail()).isNotNull();
    }
    
    @Test
    public void tipoPermitidoEncuesta() {
        Encuesta encuesta = encuestaRepository.save(new Encuesta("8","correo8@gmail.com", "No Permitido"));
        assertThat(encuesta.getTipoCocacola()).isIn(PERMITIDOS_TIPOS);
    }
}
