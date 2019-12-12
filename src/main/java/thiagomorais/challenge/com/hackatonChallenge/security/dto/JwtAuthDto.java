package thiagomorais.challenge.com.hackatonChallenge.security.dto;

import javax.validation.constraints.NotEmpty;

public class JwtAuthDto {

	
	@NotEmpty(message = "Nome de Usuário não pode ser vazio.")
	private String username;
	
	@NotEmpty(message = "Campo senha não pode ser vazio.")
	private String senha;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
