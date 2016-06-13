package nucleo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Neuronio implements Soma{
	
	private BigDecimal bias;
	private BigDecimal pesoBias;
	private List<BigDecimal> entrada;
	private List<BigDecimal> peso;
	private TipoNeuronio tipoNeuronio;
	private Integer camada;
	
	public Neuronio(TipoNeuronio tipo) {
		this.tipoNeuronio = tipo;
		bias = BigDecimal.ONE;
		pesoBias = BigDecimal.ZERO;
		entrada = new ArrayList<BigDecimal>();
		peso = new ArrayList<BigDecimal>();
	}
	
	@Override
	public BigDecimal somar() {
		BigDecimal y = pesoBias.multiply(this.bias);
		
		for(int i = 0; i < entrada.size(); i++){
			y = y.add(peso.get(i).multiply(entrada.get(i)));
		}
		
		return y;
	}
	
	public void setCamada(Integer camada) {
		this.camada = camada;
	}
	
	public void setPesoBias(BigDecimal pesoBias) {
		this.pesoBias = pesoBias;
	}
	
	public void listaEntradas(List<BigDecimal> entradas){
		try {
			//Boolean adicionaPeso = (entradas.size() == this.peso.size());// || this.peso.size() > entrada.size());
			if(entradas != null && entradas.size() > 0){
				for(BigDecimal ent : entradas){
					this.entrada.add(ent);
					if(!(this.tipoNeuronio == TipoNeuronio.ENTRADA)){
						this.peso.add(BigDecimal.ZERO);
					}
				}
			}else{
				throw new Exception("Sem entrdas!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listaEntradas(List<BigDecimal> entradas, int pos){
		try {
			//Boolean adicionaPeso = (entradas.size() == this.peso.size());// || this.peso.size() > entrada.size());
			if(entradas != null && entradas.size() > 0){
				for(BigDecimal ent : entradas){
					this.entrada.add(ent);
					if(!(this.tipoNeuronio == TipoNeuronio.ENTRADA) && pos == 0){
						this.peso.add(BigDecimal.ZERO);
						if(this.peso.size() > this.entrada.size()){
							this.peso.remove(this.peso.size());
						}
					}
					if(this.entrada.size() > peso.size()){
						this.entrada.clear();
						this.entrada.add(ent);
					}
				}
			}else{
				throw new Exception("Sem entrdas!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void novaEntrada(BigDecimal entrada){
		this.entrada.add(entrada);
		this.peso.add(BigDecimal.ZERO);
	}
	
	public void novaEntradaCamdaEntrada(BigDecimal entrada){
		this.entrada.clear();
		this.entrada.add(entrada);
//		this.peso.add(BigDecimal.ZERO);
	}
	
	public void atualizaPeso(BigDecimal peso, Integer posicao){
		this.peso.get(posicao);
		this.peso.set(posicao, peso);
	}
	
	public BigDecimal entradaPosicao(Integer posicao) {
		return entrada.get(posicao);
	}
	
	public BigDecimal pesoPosicao(Integer posicao) {
		return peso.get(posicao);
	}
	
	public List<BigDecimal> getEntrada() {
		return entrada;
	}
	
	public List<BigDecimal> getPeso() {
		return peso;
	}
	
	public BigDecimal getPesoBias() {
		return pesoBias;
	}
	
	public TipoNeuronio getTipoNeuronio() {
		return tipoNeuronio;
	}
	
	public Integer getCamada() {
		return camada;
	}

	@Override
	public String toString() {
		String retorno = "Neuronio: " + super.toString() + " [pesoBias = " + pesoBias;
		for(int i = 0; i < peso.size(); i++){
			BigDecimal p = peso.get(i);
			retorno += ", peso" + (i+1) + " = "+ p.toString();
		}
		
		return retorno;
	}
	
	
}
