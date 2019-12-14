package thiagomorais.challenge.com.hackatonChallenge.enums;

public enum TipoCategoriaContatoEnum {

	RESIDENCIAL("Residencial"),COMERCIAL("Comercial"),CELULAR("Celular");
	
	private String descricaoCategoria;
	
	private TipoCategoriaContatoEnum(String nomeCategoria) {
		this.descricaoCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
}
