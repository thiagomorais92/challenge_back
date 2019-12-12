
package thiagomorais.challenge.com.hackatonChallenge.security.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thiagomorais.challenge.com.hackatonChallenge.security.dto.JwtAuthDto;
import thiagomorais.challenge.com.hackatonChallenge.security.dto.TokenDto;
import thiagomorais.challenge.com.hackatonChallenge.security.services.MyAuthService;
import thiagomorais.challenge.com.hackatonChallenge.utils.Response;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private MyAuthService myAuthService;
	
	@PostMapping
	public ResponseEntity<Response<TokenDto>> loginUsingJwt(@Valid @RequestBody JwtAuthDto jwtDto, BindingResult binding){
		log.info("Iniciando o login  com os dados {}",jwtDto);
		Response<TokenDto> response = new Response<TokenDto>();
		
		TokenDto tokenDto = myAuthService.realizarLogin(jwtDto,binding);
		
		response.setData(tokenDto);
		
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/refresh")
	public ResponseEntity<Response<TokenDto>> refreshToken(HttpServletRequest request){
		log.info("ATUALIZANDO o token ");
		Response<TokenDto> response = new Response<TokenDto>();
		
		TokenDto tokenDto = myAuthService.atualizarToken(request);
		
		response.setData(tokenDto);
		
		return ResponseEntity.ok(response);
	}
	
}
