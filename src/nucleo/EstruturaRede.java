package nucleo;

public enum EstruturaRede {
	
	PERCPTRON_UNICA_CAMADA(0), PERCEPTRON_MULTI_CAMADAS(1);
	
	private Integer codigo;
	
	private EstruturaRede(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
}
