package thiagomorais.challenge.com.hackatonChallenge.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Usuario;
import thiagomorais.challenge.com.hackatonChallenge.repositories.UsuarioRepository;
import thiagomorais.challenge.com.hackatonChallenge.security.JwtUserFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario usuario = userRepo.findByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return JwtUserFactory.create(usuario);
	}

}
