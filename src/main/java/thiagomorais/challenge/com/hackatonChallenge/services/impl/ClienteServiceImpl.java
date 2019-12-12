package thiagomorais.challenge.com.hackatonChallenge.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;
import thiagomorais.challenge.com.hackatonChallenge.parser.ClienteParser;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ClienteRepository;
import thiagomorais.challenge.com.hackatonChallenge.serives.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteParser clienteParser; 
	
	@Override
	public List<ClienteDTO> obterTodos() {
		List<ClienteDTO> dtoList = new ArrayList<ClienteDTO>(0);
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		clientes.forEach((cliente)->{
			dtoList.add(clienteParser.toDto(cliente));
		});
		
		return dtoList;
	}

}
