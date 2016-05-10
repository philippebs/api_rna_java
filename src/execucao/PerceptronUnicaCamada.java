package execucao;

import java.math.BigDecimal;

import nucleo.EstruturaRede;
import nucleo.TipoTransferencia;
import nucleo.Treinamento;

public class PerceptronUnicaCamada {
	
	public PerceptronUnicaCamada() {
		
	}
	
	public static void main(String[] args) {
		
		Treinamento t = new Treinamento(BigDecimal.ONE, TipoTransferencia.DEGRAU_MAIOR_ZERO, EstruturaRede.PERCPTRON_UNICA_CAMADA);
		
		t.quantidadeNeuronioCamadaEntrada(2);
		t.quantidadeNeuronioCamadaSaida(1);
		// Treinamento para redes com camadas ocultas ainda não foi implementado.
		//t.quantidadeCamadasOcultas(1); 
		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
		t.conjuntoEntradaSaida(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);
		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE);
		t.conjuntoEntradaSaida(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE);
		
		System.out.println("Montagem da rede: " + t.montarRede());
		
		System.out.println("Treinada: " + t.treinar(100));
		
	}
}
