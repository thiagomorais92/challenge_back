package thiagomorais.challenge.com.hackatonChallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import thiagomorais.challenge.com.hackatonChallenge.utils.Response;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleAnyError(NegocioException ex, WebRequest request) {
        Response<?> resp = new Response<Object>();
        ex.getBindingErrors().get().forEach(erro -> resp.getErrors().add(erro.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
    }
	

	
}
