package thiagomorais.challenge.com.hackatonChallenge.serives;

import java.util.List;

import thiagomorais.challenge.com.hackatonChallenge.dto.ClienteDTO;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;

public interface ClienteService {

	List<ClienteDTO> obterTodos();

	void deletar(Long idCliente);

	Cliente salvarCliente(ClienteDTO dto);

	Cliente atualizarCLiente(ClienteDTO dto);

}
