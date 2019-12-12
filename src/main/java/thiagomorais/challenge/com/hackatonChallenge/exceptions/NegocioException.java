package thiagomorais.challenge.com.hackatonChallenge.exceptions;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NegocioException  extends RuntimeException {

	/**
	 *@author Thiago 
	 */
	
	private Optional<List<ObjectError>> bindingErrors;
	
	private static final long serialVersionUID = 1L;

	public NegocioException(BindingResult result) {
		super(result.getAllErrors().get(0).getDefaultMessage());
		this.bindingErrors = Optional.of(result.getAllErrors());
	}

	public NegocioException(List<ObjectError> objectErrorList) {
		super(objectErrorList.get(0).getDefaultMessage());
		this.bindingErrors = Optional.of(objectErrorList);
	}

	public Optional<List<ObjectError>> getBindingErrors() {
		return bindingErrors;
	}

	public void setBindingErrors(Optional<List<ObjectError>> bindingErrors) {
		this.bindingErrors = bindingErrors;
	}
	
	

}
