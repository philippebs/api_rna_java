package nucleo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rede {

	private Map<Integer, Map<TipoNeuronio, List<Neuronio>>> redeNeuronios;
	private Map<Integer, Map<TipoNeuronio, Transferencia>> mapTransferencia;
	private EstruturaRede estruturaRede;
	private List<Integer> neuroniosPorCamadasOcultas;
	private Integer quantidadeNeuronioCamadaEntrada;
	private Integer quantidadeCamadasOcultas;
	private Integer quantidadeNeuronioCamadaSaida;
	private Treinamento treinamento;
	
	public Rede(EstruturaRede estruturaRede, Treinamento treinamento) {
		this.estruturaRede = estruturaRede;
		this.treinamento = treinamento;
	}
	
	/**
	 * Monta a rede de acordo com os parametros passados.
	 * @return
	 */
	public Boolean montaRede() throws Exception{
		// Limpa a rede neural
		redeNeuronios.clear();
		
		if(!this.criarCamadaEntrada()){
			throw new Exception("Nao foi possivel criar a camada de entrada");
		}
		
		// Caso a estrutura da rede neural nao suporte camadas ocultas
		if(this.estruturaRede != EstruturaRede.PERCPTRON_UNICA_CAMADA){
			if(!this.criarCamadaOculta()){
				throw new Exception("Nao foi possivel criar a camada oculta");
			}
		}
		
		if(!this.criarCamadaSaida()){
			throw new Exception("Nao foi possivel criar a camada de saida");
		}
		
		return true;
	}
	
	public void setCamadaOculta(Integer quantidadeCamadas, Integer ...quantidadeNeuronios) throws Exception{
		if(quantidadeNeuronios.length != quantidadeCamadas){
			String tratamento = "A quantidade de camdas nao corresponde a quantidade de neuronios em cada camada";
			if(quantidadeNeuronios.length < quantidadeCamadas){
				tratamento = "Falta preencher " + (quantidadeNeuronios.length - quantidadeCamadas) + " camada(s) oculta(s)";
			}else{
				tratamento = "Quantidade de neuronio para preencher a(s) camada(s) oculta(s) fora dos limites";
			}
			throw new Exception(tratamento);
		}
		
		this.quantidadeCamadasOcultas = quantidadeCamadas;
		this.neuroniosPorCamadasOcultas = Arrays.asList(quantidadeNeuronios);
	}
	
	private Boolean criarCamadaEntrada(){
		if(quantidadeNeuronioCamadaEntrada > 0){
			List<Neuronio> camadaEntrada = new ArrayList<Neuronio>();
			Map<TipoNeuronio, List<Neuronio>> neuroniosEntrada = new HashMap<TipoNeuronio, List<Neuronio>>();
			
			for(int i = 0; i < quantidadeNeuronioCamadaEntrada; i++){
				Neuronio neuronio = new Neuronio(TipoNeuronio.ENTRADA);
				camadaEntrada.add(neuronio);
			}
			neuroniosEntrada.put(TipoNeuronio.ENTRADA, camadaEntrada);
			redeNeuronios.put(0, neuroniosEntrada);
			System.out.println("Camada de entrada montada com sucesso!");
			
			return true;
		}else{
			System.out.println("Quantidade de neuronios na camada de entrada tem que ser maior que ZERO!");
		}
		
		return false;
	}
	
	private Boolean criarCamadaOculta(){
		for (Integer quantidade : neuroniosPorCamadasOcultas) {
			System.out.println(quantidade);
		}
		
		return false;
	}
	
	private Boolean criarCamadaSaida(){
//		for (List<BigDecimal> entradas : entradasSaidas.keySet()) {
//			List<BigDecimal> saidas = entradasSaidas.get(entradas);
//			if(saidas.size() != quantidadeNeuronioCamadaSaida){
//				System.out.println("A quantidade de neuronios diferente da quantidade de saidas desejadas!");
//				return false;
//			}
//		}
		
		if(this.quantidadeNeuronioCamadaSaida > 0){
			List<Neuronio> camadaSaida = new ArrayList<Neuronio>();
			Map<TipoNeuronio, List<Neuronio>> neuroniosSaida = new HashMap<TipoNeuronio, List<Neuronio>>();
			if(quantidadeNeuronioCamadaSaida > 0){
				for(int i = 0; i < quantidadeNeuronioCamadaSaida; i++){
					Neuronio neuronio = new Neuronio(TipoNeuronio.SAIDA);
					camadaSaida.add(neuronio);
				}
				neuroniosSaida.put(TipoNeuronio.ENTRADA, camadaSaida);
				
				Integer ultimaPosicao = 0;
				for (Integer valor : redeNeuronios.keySet()){
					if(ultimaPosicao < valor){
						ultimaPosicao = valor;
					}
				}
				
				redeNeuronios.put(ultimaPosicao, neuroniosSaida);
				System.out.println("Camada de saída montada com sucesso!");
				return true;
			}
			
			return false;
		}else{
			System.out.println("Quantidade de neuronios na camada de saida tem que ser maior que ZERO!");
		}
		
		return false;
	}

	public Integer getQuantidadeNeuronioCamadaEntrada() {
		return quantidadeNeuronioCamadaEntrada;
	}

	public void setQuantidadeNeuronioCamadaEntrada(Integer quantidadeNeuronioCamadaEntrada) {
		this.quantidadeNeuronioCamadaEntrada = quantidadeNeuronioCamadaEntrada;
	}

	public Integer getQuantidadeNeuronioCamadaSaida() {
		return quantidadeNeuronioCamadaSaida;
	}

	public void setQuantidadeNeuronioCamadaSaida(Integer quantidadeNeuronioCamadaSaida) {
		this.quantidadeNeuronioCamadaSaida = quantidadeNeuronioCamadaSaida;
	}
	
	
}
