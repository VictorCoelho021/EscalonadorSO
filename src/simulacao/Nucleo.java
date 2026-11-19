
package simulacao;

import modelo.Processo;

public class Nucleo {

    private int id;
    private Processo processoAtual;

    private int tempoQuantum;
    private int quantumRestante;

    private int tempoOcupado;

    public Nucleo(int id, int tempoQuantum) {
        this.id = id;
        this.tempoQuantum = tempoQuantum;
        this.quantumRestante = tempoQuantum;
        this.tempoOcupado = 0;
    }

    public boolean estaLivre() {
        return processoAtual == null;
    }

    public void atribuirProcesso(Processo processo, int tempoAtual) {
        processoAtual = processo;
        quantumRestante = tempoQuantum;

        if (processoAtual != null) {
            processoAtual.registrarInicio(tempoAtual);
        }
    }

    public Processo executar(int tempoAtual) {

        if (processoAtual == null) {
            return null;
        }

        processoAtual.executar();

        quantumRestante--;
        tempoOcupado++;

        if (processoAtual.terminou()) {
            Processo concluido = processoAtual;
            concluido.registrarConclusao(tempoAtual + 1);

            processoAtual = null;
            quantumRestante = tempoQuantum;

            return concluido;
        }

        if (quantumRestante == 0) {
            quantumRestante = tempoQuantum;

            Processo interrompido = processoAtual;
            processoAtual = null;

            return interrompido;
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public Processo getProcessoAtual() {
        return processoAtual;
    }

    public int getQuantumRestante() {
        return quantumRestante;
    }

    public int getTempoOcupado() {
        return tempoOcupado;
    }

    public int getTempoQuantum() {
        return tempoQuantum;
    }
}
