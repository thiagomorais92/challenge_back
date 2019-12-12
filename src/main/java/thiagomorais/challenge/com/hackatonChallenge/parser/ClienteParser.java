package thiagomorais.challenge.com.hackatonChallenge.parser;

import org.springframework.stereotype.Component;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;

@Component
public class ClienteParser {

	public ClienteDTO toDto(Cliente cliente) {
		ClienteDTO clienteDto = new ClienteDTO();
		clienteDto.setContatos(cliente.getContatos());
		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setEndereco(cliente.getEndereco());
		clienteDto.setId(cliente.getId());
		clienteDto.setNome(cliente.getNome());

		return clienteDto;
	}

	
	
}
