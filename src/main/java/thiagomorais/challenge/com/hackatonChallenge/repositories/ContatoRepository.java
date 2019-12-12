package thiagomorais.challenge.com.hackatonChallenge.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	List<Contato> findByCliente(Cliente cliente);

}
