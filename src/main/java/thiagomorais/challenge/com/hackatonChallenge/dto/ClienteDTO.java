package thiagomorais.challenge.com.hackatonChallenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ClienteDTO {

	private Long id;
	
	private String nome;
	private String cpf;
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	@JsonInclude(Include.NON_NULL)
	private String complemento;
	@JsonInclude(Include.NON_NULL)
	private String emailPrincipal;
	@JsonInclude(Include.NON_NULL)
	private String emailOpc1;
	@JsonInclude(Include.NON_NULL)
	private String emailOpc2;
	@JsonInclude(Include.NON_NULL)
	private String telefoneCelular;
	@JsonInclude(Include.NON_NULL)
	private String telefoneComercial;
	@JsonInclude(Include.NON_NULL)
	private String telefoneResidencial;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEmailPrincipal() {
		return emailPrincipal;
	}
	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}
	public String getEmailOpc1() {
		return emailOpc1;
	}
	public void setEmailOpc1(String emailOpc1) {
		this.emailOpc1 = emailOpc1;
	}
	public String getEmailOpc2() {
		return emailOpc2;
	}
	public void setEmailOpc2(String emailOpc2) {
		this.emailOpc2 = emailOpc2;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	
	
}
