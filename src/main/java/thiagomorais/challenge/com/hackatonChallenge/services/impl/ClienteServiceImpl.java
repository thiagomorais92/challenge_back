package thiagomorais.challenge.com.hackatonChallenge.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;
import thiagomorais.challenge.com.hackatonChallenge.parser.ClienteParser;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ClienteRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.ContatoRepository;
import thiagomorais.challenge.com.hackatonChallenge.repositories.EnderecoRepository;
import thiagomorais.challenge.com.hackatonChallenge.serives.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteParser clienteParser; 
	
	@Autowired 
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Override
	public List<ClienteDTO> obterTodos() {
		List<ClienteDTO> dtoList = new ArrayList<ClienteDTO>(0);
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		clientes.forEach((cliente)->{
			dtoList.add(clienteParser.toDto(cliente));
		});
		
		return dtoList;
	}

	@Override
	@Transactional
	public void deletar(Long idCliente) {
		Optional<Cliente> cli = clienteRepository.findById(idCliente);
		if(cli.isPresent()) {
			List<Contato> contatos = contatoRepository.findByCliente(cli.get());
			contatoRepository.deleteAll(contatos);
			enderecoRepository.delete(enderecoRepository.findByCliente(cli.get()));
			clienteRepository.delete(cli.get());
		}
		
	}

}
