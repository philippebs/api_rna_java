package nucleo;

import java.math.BigDecimal;

public class Transferencia {
	
	private TipoTransferencia tipo;
	
	/**
	 * Recebe um tipo de tranferência
	 * @param tipo {@link TipoTransferencia}
	 */
	public Transferencia(TipoTransferencia tipo) {
		this.tipo = tipo;
	}
	
	public void setTipo(TipoTransferencia tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Faz a transferência do valor vindo da soma dos neuronios da camada que foi calculada.
	 * @param valor
	 * @return {@link BigDecimal}
	 */
	public BigDecimal tranferir(BigDecimal valor){
		
		BigDecimal retorno = BigDecimal.ZERO;
		
		if(tipo == TipoTransferencia.DEGRAU_MAIOR_IGUAL_ZERO){
			retorno = degrauMaiorIgualZero(valor);
		}else if (tipo == TipoTransferencia.DEGRAU_MAIOR_ZERO) {
			retorno = degrauMaiorZero(valor);
		}else if(tipo == TipoTransferencia.SIGMOIDE){
			
		}else if(tipo == TipoTransferencia.TANGENTE_HIPERBOLICA){
			
		}
		
		return retorno;
		
	}
	
	private BigDecimal degrauMaiorIgualZero(BigDecimal valor){
		if(valor.compareTo(BigDecimal.ZERO) >= 0){
			return BigDecimal.ONE;
		}else{
			return BigDecimal.ZERO;
		}
	}
	
	private BigDecimal degrauMaiorZero(BigDecimal valor){
		if(valor.compareTo(BigDecimal.ZERO) > 0){
			return BigDecimal.ONE;
		}else{
			return BigDecimal.ZERO;
		}
	}
	
}
