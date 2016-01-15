package execucao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import nucleo.EstruturaRede;
import nucleo.TipoTransferencia;
import nucleo.Treinamento;

public class Executar {
	
	private List<BigDecimal> entrada = new ArrayList<BigDecimal>();
	private List<BigDecimal> saida = new ArrayList<BigDecimal>();
	
	public static void main(String[] args) {
		Executar executar = new Executar();
		Treinamento treinamento = new Treinamento(BigDecimal.ONE, TipoTransferencia.DEGRAU_MAIOR_IGUAL_ZERO, EstruturaRede.PERCPTRON_UNICA_CAMADA);
		
		executar.setEntrada(BigDecimal.ZERO);
		executar.setEntrada(BigDecimal.ZERO);
		executar.setSaida(BigDecimal.ZERO);
		executar.transerir(treinamento);
	}
	
	public void setEntrada(BigDecimal valor){
		this.entrada.add(valor);
	}
	
	public void setSaida(BigDecimal valor){
		this.saida.add(valor);
	}
	
	public void transerir(Treinamento t){
//		t.conjuntoEntradaSaida(this.entrada, this.saida);
		this.entrada.clear();
		this.saida.clear();
	}
}
