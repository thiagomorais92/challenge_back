package thiagomorais.challenge.com.hackatonChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import thiagomorais.challenge.com.hackatonChallenge.entidades.Usuario;


@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
