package br.com.santander.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.santander.desafio.app.controller.AgenciaController;
import br.com.santander.desafio.app.entity.Agencia;
import br.com.santander.desafio.app.entity.dto.AgenciaDTO;
import br.com.santander.desafio.app.entity.dto.DistanciaDTO;
import br.com.santander.desafio.app.service.AgenciaService;

@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	

	    @InjectMocks
	    private AgenciaController controller;

	    @Mock
	    private AgenciaService service;

	    @Test
	    void deveCadastrarAgenciaComSucesso() {
	        AgenciaDTO dto = new AgenciaDTO("Agência Central", -23.55, -46.63);
	        Agencia agenciaMock = new Agencia(1L, "Agência Central", -23.55, -46.63);

	        when(service.salvar(dto)).thenReturn(agenciaMock);

	        ResponseEntity<Agencia> response = controller.cadastrar(dto);

	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        assertEquals(agenciaMock, response.getBody());
	    }

	    @Test
	    void deveConsultarDistanciasComSucesso() {
	        double posX = -23.55;
	        double posY = -46.63;

	        List<DistanciaDTO> distanciasMock = List.of(
	            new DistanciaDTO("Agência A", 1.2),
	            new DistanciaDTO("Agência B", 3.4)
	        );

	        when(service.consultarDistancias(posX, posY)).thenReturn(distanciasMock);

	        ResponseEntity<List<DistanciaDTO>> response = controller.consultarDistancias(posX, posY);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals(distanciasMock, response.getBody());
	    }

}
