package nucleo;

import java.util.List;
import java.util.Map;

public class Rede {

	private Map<Integer, Map<TipoNeuronio, List<Neuronio>>> redeNeuronios;
	private Map<Integer, Map<TipoNeuronio, Transferencia>> mapTransferencia;
	private EstruturaRede estruturaRede;
	
	
	public Rede(EstruturaRede estruturaRede) {
		this.estruturaRede = estruturaRede;
		
	}
	
	/**
	 * Monta a rede de acordo com os parametros passados.
	 * @return
	 */
	public Boolean montaRede(){
		
		this.criarCamadaEntrada();
		this.criarCamadaOculta();
		this.criarCamadaSaida();
		
		return false;
	}
	
	private Boolean criarCamadaEntrada(){
		
		return false;
	}
	
	private Boolean criarCamadaOculta(){
		return false;
	}
	
	private Boolean criarCamadaSaida(){
		return false;
	}
}
