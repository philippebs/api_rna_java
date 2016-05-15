package execucao;

import java.math.BigDecimal;

import nucleo.EstruturaRede;
import nucleo.TipoTransferencia;
import nucleo.Treinamento;

public class PerceptronUnicaCamada {
	
	public PerceptronUnicaCamada() {
		
	}
	
	public static void main(String[] args) {
		// TODO A rede perceptron com 2 neuronios ou mais na camada de saida apresenta uma
		// falha, pois a api não considera os sinais em conjunto mas sim como sendo cada sinal independente.
		
		Treinamento t = new Treinamento(BigDecimal.ONE, TipoTransferencia.DEGRAU_MAIOR_ZERO, EstruturaRede.PERCPTRON_UNICA_CAMADA);
		
		t.quantidadeNeuronioCamadaEntrada(2);
		t.quantidadeNeuronioCamadaSaida(1);
		// Treinamento para redes com camadas ocultas ainda não foi implementado.
		//t.quantidadeCamadasOcultas(1); 
		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE); // kepler
		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO); // beethoven
		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE); // einstein
		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO); // bach
		
//		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO); // bach
//		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE); // einstein
//		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO); // beethoven
//		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE); // kepler
//		
		
		
		System.out.println("Montagem da rede: " + t.montarRede());
		
		System.out.println("Treinada: " + t.treinar(100));
		
	}
}
