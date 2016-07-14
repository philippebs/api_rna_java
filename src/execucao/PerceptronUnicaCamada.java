package execucao;

import java.math.BigDecimal;
import java.util.Arrays;

import nucleo.EstruturaRede;
import nucleo.Rede;
import nucleo.TipoTransferencia;
import nucleo.Treinamento;

public class PerceptronUnicaCamada {
	
	public PerceptronUnicaCamada() {
		
	}
	
	public static void main(String[] args) {
		// TODO A rede perceptron com 2 neuronios ou mais na camada de saida apresenta uma
		// falha, pois a api não considera os sinais em conjunto mas sim como sendo cada sinal independente.
		//Rede rede = new Rede(EstruturaRede.PERCPTRON_UNICA_CAMADA);
		
		Treinamento t = new Treinamento(BigDecimal.ONE, TipoTransferencia.DEGRAU_MAIOR_ZERO, EstruturaRede.PERCPTRON_UNICA_CAMADA);
		
		t.quantidadeNeuronioCamadaEntrada(2);
		t.quantidadeCamadasOcultas(1);
		t.quantidadeNeuronioCamadaOculta(2);
		t.quantidadeNeuronioCamadaSaida(1);
		
		// Treinamento para redes com camadas ocultas ainda não foi implementado.
		//t.quantidadeCamadasOcultas(1);
//		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ONE, BigDecimal.ONE), Arrays.asList(BigDecimal.ONE, BigDecimal.ZERO));//einstein
//		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE), Arrays.asList(BigDecimal.ONE, BigDecimal.ONE));// Marie Curie
//		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ONE, BigDecimal.ZERO), Arrays.asList(BigDecimal.ZERO, BigDecimal.ZERO));//Machado de Assis
//		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ZERO, BigDecimal.ZERO), Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE));//Raquel de Queiroz
		
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ONE, BigDecimal.ONE), BigDecimal.ZERO);
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE), BigDecimal.ONE);
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ZERO, BigDecimal.ZERO), BigDecimal.ZERO);
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ONE, BigDecimal.ZERO), BigDecimal.ONE);
		
//		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE); // kepler
//		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO); // beethoven
//		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE); // einstein
//		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO); // bach
		
//		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO); // bach
//		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE); // einstein
//		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO); // beethoven
//		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE); // kepler
//		
		
		System.out.println("Treinada: " + t.treinar(10000));
		
	}
}
