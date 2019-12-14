package thiagomorais.challenge.com.hackatonChallenge.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import thiagomorais.challenge.com.hackatonChallenge.enums.TipoCategoriaContatoEnum;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String textoContato;
	
	@Enumerated(EnumType.STRING)
	private TipoContatoEnum tipoContato;
	
	@Enumerated(EnumType.STRING)
	private TipoCategoriaContatoEnum tipocategoriaContatoEnum;
	
	@ManyToOne
	@JoinColumn(name="client_id",nullable = false)
	@JsonIgnore
	private Cliente cliente;
	
	public Contato() {}
	
	public Contato(TipoContatoEnum tipoContato, String descricao,Cliente cli) {
		this.tipoContato = tipoContato;
		this.textoContato = descricao;
		this.cliente = cli;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTextoContato() {
		return textoContato;
	}
	public void setTextoContato(String textoContato) {
		this.textoContato = textoContato;
	}
	public TipoContatoEnum getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TipoContatoEnum tipoContato) {
		this.tipoContato = tipoContato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoCategoriaContatoEnum getTipocategoriaContatoEnum() {
		return tipocategoriaContatoEnum;
	}

	public void setTipocategoriaContatoEnum(TipoCategoriaContatoEnum tipocategoriaContatoEnum) {
		this.tipocategoriaContatoEnum = tipocategoriaContatoEnum;
	}
	
}
