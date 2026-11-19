
package escalonador;

import java.util.Comparator;
import java.util.List;

import modelo.Processo;

public class Escalonador {

    public void ordenarProcessos(List<Processo> processos) {

        processos.sort(
            Comparator
                .comparingInt(Processo::getPrioridade)
                .thenComparingInt(Processo::getTempoRestante)
                .thenComparingInt(Processo::getTempoChegada)
                .thenComparingInt(Processo::getId)
        );
    }

    public Processo selecionarProcesso(List<Processo> processos) {

        if (processos.isEmpty()) {
            return null;
        }

        ordenarProcessos(processos);

        return processos.remove(0);
    }
}

