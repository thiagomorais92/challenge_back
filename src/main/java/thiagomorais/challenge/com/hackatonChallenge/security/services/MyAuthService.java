package thiagomorais.challenge.com.hackatonChallenge.security.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import thiagomorais.challenge.com.hackatonChallenge.security.dto.JwtAuthDto;
import thiagomorais.challenge.com.hackatonChallenge.security.dto.TokenDto;


public interface MyAuthService {

	TokenDto realizarLogin(JwtAuthDto jwtDto, BindingResult binding);

	TokenDto atualizarToken(HttpServletRequest request);

}
