package nucleo;

public enum TipoNeuronio {
	
	ENTRADA(0), OCULTO(1), SAIDA(2);
	
	private Integer codigo;
	
	private TipoNeuronio(Integer codigo){
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
}
