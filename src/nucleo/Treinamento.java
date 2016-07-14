package nucleo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Treinamento {
	
	private BigDecimal taxaAtualizacao;
	private BigDecimal erro;
	private TipoTransferencia tipo;
	private Transferencia transferencia;
//	private Map<List<BigDecimal>, List<BigDecimal>> entradaSaida;
	private Map<List<BigDecimal>, BigDecimal> entradaSaida;
	private Map<List<BigDecimal>, List<BigDecimal>> entradasSaidas;
	private Map<TipoNeuronio, List<Neuronio>> rede;
	//private List<Neuronio> listaNeuronio;
	private EstruturaRede estrutura;
	private Integer quantidadeNeuronioCamadaEntrada;
	private Integer quantidadeNeuronioCamadaOculta;
	private Integer quantidadeCamadasOcultas;
	private Integer quantidadeNeuronioCamadaSaida;
	
//	/**
//	 * Caso funcione o método recebe um map de entrada e um map de saida e adiciona a entrada com a saida desejada
//	 * no Map de entrada e saida;
//	 * @param entrada {@link Map} <{@link Integer}, {@link List}<{@link BigDecimal}>>
//	 * @param saida {@link Map} <{@link Integer}, {@link List}<{@link BigDecimal}>>
//	 */
//	public Treinamento(Map<Integer, List<BigDecimal>> entrada, Map<Integer, List<BigDecimal>> saida) {
//		Set<Integer> valores = entrada.keySet();
//		for(Integer i = 0;valores.iterator().hasNext();i = valores.iterator().next()){
//			if(saida.containsKey(i)){
//				entradaSaida.put(entrada.get(i), saida.get(i));
//			}
//		}
//	}
	
	/**
	 * Construtor do Treinamento: recebe a taxa de atualizacao, o tipo de transferencia da rede e a sua estrutura.
	 * @param taxaAtualizacao {@link BigDecimal}
	 * @param tipo {@link TipoTransferencia}
	 * @param estrutura {@link EstruturaRede}
	 */
	public Treinamento(BigDecimal taxaAtualizacao, TipoTransferencia tipo, EstruturaRede estrutura) {
		this.taxaAtualizacao = taxaAtualizacao;
		this.tipo = tipo;
		this.transferencia = new Transferencia(this.tipo);
		this.estrutura = estrutura;
		this.quantidadeNeuronioCamadaEntrada = -1;
		this.quantidadeNeuronioCamadaOculta = -1;
		this.quantidadeNeuronioCamadaSaida = -1;
		this.quantidadeCamadasOcultas = -1;
		this.entradaSaida = new HashMap<List<BigDecimal>, BigDecimal>();
		this.rede = new HashMap<TipoNeuronio, List<Neuronio>>();
		this.entradasSaidas = new HashMap<List<BigDecimal>, List<BigDecimal>>();
	}
	
//	public void conjuntoEntradaSaida(List<BigDecimal> entrada, List<BigDecimal> saida){
//		this.entradaSaida.put(entrada, saida);
//	}
	
//	public void conjuntoEntradaSaida(){
//		this.entradaSaida.put(entrada, saida);
//	}
	
	public void conjuntoEntradaSaida(List<BigDecimal> entrada, BigDecimal saida){
		this.entradasSaidas.put(entrada, Arrays.asList(saida));
	}
	
	public void conjuntoEntradaSaida(BigDecimal entrada1, BigDecimal entrada2, BigDecimal saida){
		this.entradasSaidas.put(Arrays.asList(entrada1, entrada2), Arrays.asList(saida));
	}
	
	public void conjuntoEntradaSaida(BigDecimal[] entrada, BigDecimal saida){
		ArrayList<BigDecimal> entrad = new ArrayList<BigDecimal>();
		for(BigDecimal big : entrada){
			entrad.add(big);
		}
		this.entradasSaidas.put(entrad, Arrays.asList(saida));
	}
	
	public void conjuntoEntradaSaida(List<BigDecimal> entradas, List<BigDecimal> saidas){
		this.entradasSaidas.put(entradas, saidas);
	}
	
	public void quantidadeNeuronioCamadaEntrada(int quantidade){
		this.quantidadeNeuronioCamadaEntrada = quantidade;
	}
	
	public void quantidadeNeuronioCamadaOculta(int quantidade){
		this.quantidadeNeuronioCamadaOculta = quantidade;
	}
	
	public void quantidadeNeuronioCamadaSaida(int quantidade){
		this.quantidadeNeuronioCamadaSaida = quantidade;
	}
	
	public void quantidadeCamadasOcultas(int quantidade){
		this.quantidadeCamadasOcultas = quantidade;
	}
	
	/**
	 * Monta a Rede Neural de acordo com as camadas que foram passadas nos métodos, caso não 
	 * tenha nenhum parametro a rede não é montada.
	 * @return {@link Boolean}
	 */
	private Boolean montarRede(){
		rede.clear();
		
		if(!criarCamadaEntrada() || !criarCamadaSaida()){
			System.out.println("Falha ao montra a rede!");
			return false;
		}
		
		criarCamadaOculta();
		System.out.println("Rede Montada com sucesso!");
		return true;
	}
	
	private Boolean criarCamadaEntrada() {
		List<Neuronio> camadaEntrada = new ArrayList<Neuronio>();
		if(quantidadeNeuronioCamadaEntrada > 0){
			for(int i = 0; i < quantidadeNeuronioCamadaEntrada; i++){
				Neuronio neuronio = new Neuronio(TipoNeuronio.ENTRADA);
				camadaEntrada.add(neuronio);
			}
			rede.put(TipoNeuronio.ENTRADA, camadaEntrada);
			
			System.out.println("Camada de entrada montada com sucesso!");
			
			return true;
		}
		return false;
	}
	
	private void criarCamadaOculta() {
		List<Neuronio> camadaOculta = new ArrayList<Neuronio>();
		
		if(quantidadeCamadasOcultas == null || quantidadeCamadasOcultas < 0){
			quantidadeCamadasOcultas = 0;
		}
		
		for(int j = 0; j < quantidadeCamadasOcultas; j++){
			if(quantidadeNeuronioCamadaOculta > 0){
				for(int i = 0; i < quantidadeNeuronioCamadaOculta; i++){
					Neuronio neuronio = new Neuronio(TipoNeuronio.OCULTO);
					neuronio.setCamada(j);
					camadaOculta.add(neuronio);
				}
				rede.put(TipoNeuronio.OCULTO, camadaOculta);
			}
		}
		
		if(quantidadeCamadasOcultas > 0){
			System.out.println(quantidadeCamadasOcultas + " camada" + (quantidadeCamadasOcultas > 1 ? "(s)" : "") + " oculta montada com sucesso!");
		}
	}
	
	private Boolean criarCamadaSaida() {
		List<Neuronio> camadaSaida = new ArrayList<Neuronio>();
		
		for (List<BigDecimal> entradas : entradasSaidas.keySet()) {
			List<BigDecimal> saidas = entradasSaidas.get(entradas);
			if(saidas.size() != quantidadeNeuronioCamadaSaida){
				System.out.println("A quantidade de neuronios diferente da quantidade de saidas desejadas!");
				return false;
			}
		}
		
		if(quantidadeNeuronioCamadaSaida > 0){
			for(int i = 0; i < quantidadeNeuronioCamadaSaida; i++){
				Neuronio neuronio = new Neuronio(TipoNeuronio.SAIDA);
				camadaSaida.add(neuronio);
			}
			rede.put(TipoNeuronio.SAIDA, camadaSaida);
			
			System.out.println("Camada de saída montada com sucesso!");
			
			return true;
		}
		
		return false;
	}
	
	// Rafatorar esse trecho de código, ainda não está 100%
	public Boolean treinar(int iteracoes){
		if(this.montarRede()){
			Boolean treinada = false;
			int iter = 0;
//			for(TipoNeuronio tipo : rede.keySet()){
//				List<Neuronio> listaNeuronios = rede.get(tipo);
//				
//			}
			Boolean criarPesos = true;
			while(!treinada && iter < iteracoes){
				treinada = true;
				
				int primeiraPassagem = iter;
				
				for(List<BigDecimal> entradas : entradasSaidas.keySet()){
					
					List<Neuronio> listaNeuroniosEntrada = rede.get(TipoNeuronio.ENTRADA);
					this.setaEntradaNeuronio(entradas, listaNeuroniosEntrada, primeiraPassagem);
					
					if(this.quantidadeCamadasOcultas > 0){
						setaEntradaNaCamadaOculta(listaNeuroniosEntrada, rede.get(TipoNeuronio.OCULTO), primeiraPassagem);
						Integer indice = 0;
						
						// Seta a soma dos neuronios ocultos nas saidas.
						for (Neuronio neuroniooculto : rede.get(TipoNeuronio.OCULTO)) {
							BigDecimal somaOculto = this.transferencia.tranferir(neuroniooculto.somar());
							setaOcultoNaSaida(rede.get(TipoNeuronio.SAIDA), somaOculto, criarPesos);
						}
						
						criarPesos = false;
						
						// Saida da rede
						for(Neuronio nSaida : rede.get(TipoNeuronio.SAIDA)){
							BigDecimal saidaDesejada = entradasSaidas.get(entradas).get(indice);
							
							BigDecimal saidaCalculada = nSaida.somar();
							saidaCalculada = this.transferencia.tranferir(saidaCalculada);
							
							this.erro = saidaDesejada.subtract(saidaCalculada);
							
							if(erro.compareTo(BigDecimal.ZERO) != 0){
								atualizaPeso(nSaida, rede.get(TipoNeuronio.OCULTO));
								treinada = false;
							}
							System.out.println(nSaida);
							nSaida.limparEntradas();
							indice++;
							//BigDecimal saidaDesejada = entradaSaida.get(entradas);
						}
						
						
					}else{
						setaEntradaNaSaida(listaNeuroniosEntrada, rede.get(TipoNeuronio.SAIDA), primeiraPassagem);
						Integer indice = 0;
						for(Neuronio nSaida : rede.get(TipoNeuronio.SAIDA)){
							BigDecimal saidaDesejada = entradasSaidas.get(entradas).get(indice);
							
							BigDecimal saidaCalculada = nSaida.somar();
							saidaCalculada = this.transferencia.tranferir(saidaCalculada);
							
							this.erro = saidaDesejada.subtract(saidaCalculada);
							
							if(erro.compareTo(BigDecimal.ZERO) != 0){
								atualizaPeso(nSaida);
								treinada = false;
							}
							System.out.println(nSaida);
							indice++;
							//BigDecimal saidaDesejada = entradaSaida.get(entradas);
						}
					}
					primeiraPassagem++;
				}// Fim do for de entradas
				System.out.println();
				iter++;
			}// Fim While
			
			System.out.println("iter: " + iter + " iteracoes: " + iteracoes + " Treinada: " + treinada);
			if(iter >= iteracoes && !treinada){
				System.out.println("As iterações foram insuficiente para treinar a rede neural!");
			}
			
			operarRede();
			
			return true;
		}
		
		return false;
	}
	
	private void operarRede(){
		 System.out.println();
		 System.out.println("Iniciando Rede:");
		for(List<BigDecimal> entradas : entradasSaidas.keySet()){
			
			List<Neuronio> listaNeuroniosEntrada = rede.get(TipoNeuronio.ENTRADA);
			this.setaEntradaNeuronio(entradas, listaNeuroniosEntrada, -1);
			
			setaEntradaNaSaida(listaNeuroniosEntrada, rede.get(TipoNeuronio.SAIDA), 1);
			for(Neuronio nSaida : rede.get(TipoNeuronio.SAIDA)){
				//BigDecimal saidaDesejada = entradaSaida.get(entradas);
				
				BigDecimal saidaCalculada = nSaida.somar();
				saidaCalculada = this.transferencia.tranferir(saidaCalculada);
				
				System.out.print(" Saida: " + saidaCalculada);
			}
			System.out.println();
		}
	}
	
	private void atualizaPeso(Neuronio neuronio){
		BigDecimal pesoNovoBias = neuronio.getPesoBias().add(this.taxaAtualizacao.multiply(this.erro).multiply(BigDecimal.ONE));
		
		System.out.print("Neuronio: " + neuronio.getTipoNeuronio().name() + " - Peso bias: " + neuronio.getPesoBias() + " Novo Peso bias: " + pesoNovoBias);
		
		neuronio.setPesoBias(pesoNovoBias);
		for(int i = 0; i < neuronio.getPeso().size(); i++){
			BigDecimal pesoNovo = (neuronio.getPeso()).get(i).add(this.taxaAtualizacao.multiply(this.erro).multiply((neuronio.getEntrada()).get(i)));
			
			System.out.print("; Peso(" + i + "): " + neuronio.getPeso().get(i) + " Novo Peso(" + i + "): " + pesoNovo);
			
			(neuronio.getPeso()).set(i, pesoNovo);
//			neuronio.atualizaPeso(pesoNovo, i);
		}
		System.out.println();
	}
	
	private void atualizaPeso(Neuronio neuronioSaida, List<Neuronio> listaNeuroniosOcultos){
		atualizaPeso(neuronioSaida);
		for (Neuronio neuronioOculto : listaNeuroniosOcultos) {
			atualizaPeso(neuronioOculto);
		}
	}
	
	private void setaEntradaNeuronio(List<BigDecimal> ent, List<Neuronio> listaNeuronios, int pos){
		try {
			if(ent.size() != listaNeuronios.size()){
				throw new Exception("Entradas não correspondem a quantidade de neuronios da camada de Entrada!");
			}else{
				for(int i = 0; i < listaNeuronios.size(); i ++){
					Neuronio neuronio = listaNeuronios.get(i);
					neuronio.novaEntradaCamdaEntrada(ent.get(i));
					if(pos == -1){
						System.out.print(ent.get(i) + " ");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setaEntradaNaSaida(List<Neuronio> listaNeuroniosEntrada, List<Neuronio> listaNeuronioSaida, int pos){
		for(Neuronio nSaida : listaNeuronioSaida){
			for(Neuronio neuronio : listaNeuroniosEntrada){
				nSaida.listaEntradas(neuronio.getEntrada(), pos);
			}
		}
	}
	
	private void setaEntradaNaCamadaOculta(List<Neuronio> listaNeuroniosEntrada, List<Neuronio> listaNeuronioOculto, int pos){
		for(Neuronio nSaida : listaNeuronioOculto){
			for(Neuronio neuronio : listaNeuroniosEntrada){
				nSaida.listaEntradas(neuronio.getEntrada(), pos);
			}
		}
	}
	
	private void setaOcultoNaSaida(List<Neuronio> listaNeuronioSaida, BigDecimal valorNeuronioOculto, Boolean criarPesos){
		for (Neuronio neuronioSaida : listaNeuronioSaida) {
			neuronioSaida.novaEntrada(valorNeuronioOculto, criarPesos);
		}
	}
}
