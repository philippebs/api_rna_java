package nucleo;

public enum TipoTransferencia {
	
	DEGRAU_MAIOR_IGUAL_ZERO(0), DEGRAU_MAIOR_ZERO(1), DEGRAU_MAIOR_ZERO_SAIDA_NEGATIVA(2), SIGMOIDE(3), TANGENTE_HIPERBOLICA(4);
	
	
	private Integer codigo;
	
	private TipoTransferencia(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
}
