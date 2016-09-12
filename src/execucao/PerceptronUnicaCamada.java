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
		
		Treinamento t = new Treinamento(new BigDecimal("0.1"), TipoTransferencia.DEGRAU_MAIOR_IGUAL_ZERO_SAIDA_NEGATIVA, EstruturaRede.PERCPTRON_UNICA_CAMADA);
		
		t.quantidadeNeuronioCamadaEntrada(2);
		t.quantidadeNeuronioCamadaSaida(2);
		
		//Treinamento para redes com camadas ocultas ainda não foi implementado.
		//t.quantidadeCamadasOcultas(1);
		//t.quantidadeNeuronioCamadaOculta(2);
		
		// autor = 0, cientista = 1
		// homem = 0, mulher = 1

		// Einstein 			1, 1 = 1 - 0 (Cientista, Homem)
		// Marie Curie			0, 1 = 1 - 1 (Cientista, Mulher)
		// Stan Lee				1, 0 = 0 - 0 (Autor, Homem)
		// Clarice Lispector	0, 0 = 0 - 1 (Autor, Mulher)
		
		// --------------------------------------------------------
		// autor = -1, cientista = 1
		// homem = -1, mulher    = 1

		// Einstein 			1 ,  1 =  1 (-1) (Cientista, Homem)
		// Marie Curie			-1,  1 =  1   1  (Cientista, Mulher)
		// Stan Lee				1 , -1 = -1 (-1) (Autor, Homem)
		// Clarice Lispector	-1, -1 = -1   1  (Autor, Mulher)
		
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ONE, BigDecimal.ONE), Arrays.asList(BigDecimal.ONE, new BigDecimal("-1")));//einstein
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ZERO, BigDecimal.ONE), Arrays.asList(BigDecimal.ONE, BigDecimal.ONE));// Marie Curie
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ONE, BigDecimal.ZERO), Arrays.asList(new BigDecimal("-1"), new BigDecimal("-1")));// Stan Lee
		t.conjuntoEntradaSaida(Arrays.asList(BigDecimal.ZERO, BigDecimal.ZERO), Arrays.asList(new BigDecimal("-1"), BigDecimal.ONE));//Clarice Lispector
		
		
		System.out.println("Treinada: " + t.treinar(10000));
		
	}
}
