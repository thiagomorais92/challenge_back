package thiagomorais.challenge.com.hackatonChallenge.security.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import thiagomorais.challenge.com.hackatonChallenge.exceptions.NegocioException;
import thiagomorais.challenge.com.hackatonChallenge.security.dto.JwtAuthDto;
import thiagomorais.challenge.com.hackatonChallenge.security.dto.TokenDto;
import thiagomorais.challenge.com.hackatonChallenge.security.services.MyAuthService;
import thiagomorais.challenge.com.hackatonChallenge.security.utils.JwtTokenUtils;


@Service
public class MyAuthServiceImpl implements MyAuthService {

	private static final Logger log = LoggerFactory.getLogger(MyAuthServiceImpl.class);
	
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtils jwtTokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	public TokenDto realizarLogin(JwtAuthDto jwtDto, BindingResult result) {
		
		if(result.hasErrors()) {
			log.error("Falha ao logar com os dados {}",jwtDto);
			throw new NegocioException(result);
		}
		log.info("Gerando token para o usuario: {}",jwtDto.getUsername());
			
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtDto.getUsername(), jwtDto.getSenha()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtDto.getUsername());
		
		return new TokenDto(jwtTokenUtils.obterToken(userDetails));
	}


	@Override
	public TokenDto atualizarToken(HttpServletRequest request) {
		TokenDto dto = new TokenDto();
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));

		Optional<String> tokenSemPrefixo = validarToken(token);
		
		dto.setToken(jwtTokenUtils.refreshToken(tokenSemPrefixo.get()));
		
		return dto;
	}


	private Optional<String> validarToken(Optional<String> token) {
		List<ObjectError> errors = new ArrayList<ObjectError>(0);
		Optional<String> tokenSemPrefixo = null;
		if(token.isPresent() && token.get().startsWith(BEARER_PREFIX)){
			tokenSemPrefixo = Optional.of(token.get().substring(7));
		}
		if(!token.isPresent()) {
			errors.add(new ObjectError("Token", "Token não informado"));
		}else if (!jwtTokenUtils.tokenValido(token.get())){
			errors.add(new ObjectError("Token", "Token Inválido"));
		}
		
		if(!errors.isEmpty()) {
			throw new NegocioException(errors);
		}
		return tokenSemPrefixo;
	}

}
