package thiagomorais.challenge.com.hackatonChallenge;

import org.springframework.data.jpa.repository.JpaRepository;

import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
