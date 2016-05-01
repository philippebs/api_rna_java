package nucleo;

public enum TipoTransferencia {
	
	DEGRAU_MAIOR_IGUAL_ZERO(0), DEGRAU_MAIOR_ZERO(1), SIGMOIDE(2), TANGENTE_HIPERBOLICA(3);
	
	
	private Integer codigo;
	
	private TipoTransferencia(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
}
