package thiagomorais.challenge.com.hackatonChallenge.parser;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;
import thiagomorais.challenge.com.hackatonChallenge.entidades.TipoContatoEnum;

@Component
public class ClienteParser {

	public ClienteDTO toDto(Cliente cliente) {
		ClienteDTO clienteDto = new ClienteDTO();
		clienteDto.setId(cliente.getId());
		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setNome(cliente.getNome());
		
		clienteDto.setBairro(cliente.getEndereco().getBairro());
		clienteDto.setCep(cliente.getEndereco().getCep());
		clienteDto.setCidade(cliente.getEndereco().getCidade());
		clienteDto.setComplemento(cliente.getEndereco().getComplemento());
		clienteDto.setUf(cliente.getEndereco().getUf());
		clienteDto.setLogradouro(cliente.getEndereco().getLogradouro());

		
		List<Contato> contatosEmail = cliente.getContatos().stream()
			    .filter(c -> TipoContatoEnum.EMAIL.equals(c.getTipoContato())).collect(Collectors.toList());
		clienteDto.setEmailPrincipal(contatosEmail.get(0).getTextoContato());
		
		List<Contato> contatosTel = cliente.getContatos().stream()
			    .filter(c -> TipoContatoEnum.TELEFONE.equals(c.getTipoContato())).collect(Collectors.toList());
		clienteDto.setTelefoneCelular(contatosTel.get(0).getTextoContato());

		return clienteDto;
	}

	
	
}
