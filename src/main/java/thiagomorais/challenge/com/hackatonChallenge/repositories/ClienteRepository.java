package thiagomorais.challenge.com.hackatonChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import thiagomorais.challenge.com.hackatonChallenge.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
