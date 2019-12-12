package thiagomorais.challenge.com.hackatonChallenge.dto;

import java.util.List;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Contato;
import thiagomorais.challenge.com.hackatonChallenge.entidades.Endereco;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private List<Contato> contatos;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
	
}
