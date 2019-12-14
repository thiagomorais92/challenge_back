package thiagomorais.challenge.com.hackatonChallenge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.serives.ClienteService;
import thiagomorais.challenge.com.hackatonChallenge.utils.Response;

@RestController
@RequestMapping("/api/cliente")
@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
@CrossOrigin("*")
public class ClienteController {

	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public void deleteCliente(@PathVariable("id") Long id){
		log.info("deletando o cliente, {}.,.,.,.,..,.  {}");
		clienteService.deletar(id);
	} 
	
	
	@GetMapping
	public ResponseEntity<Response<List<ClienteDTO>>> obterClientes(){
		
		Response<List<ClienteDTO>> res = new Response<List<ClienteDTO>>();
		
		res.setData(clienteService.obterTodos());
		
		return ResponseEntity.ok(res);
		
	}
	
	
	
	
}
