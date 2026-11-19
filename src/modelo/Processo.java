
package modelo;

public class Processo {

    private int id;
    private int tempoChegada;
    private int tempoExecucao;
    private int tempoRestante;
    private int prioridade;

    private int tempoInicio = -1;
    private int tempoConclusao = -1;

    public Processo(int id, int tempoChegada, int tempoExecucao, int prioridade) {
        this.id = id;
        this.tempoChegada = tempoChegada;
        this.tempoExecucao = tempoExecucao;
        this.tempoRestante = tempoExecucao;
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getTempoInicio() {
        return tempoInicio;
    }

    public int getTempoConclusao() {
        return tempoConclusao;
    }

    public void executar() {
        if (tempoRestante > 0) {
            tempoRestante--;
        }
    }

    public void registrarInicio(int instante) {
        if (tempoInicio == -1) {
            tempoInicio = instante;
        }
    }

    public void registrarConclusao(int instante) {
        tempoConclusao = instante;
    }

    public int getTempoEspera() {
        if (tempoConclusao == -1) {
            return 0;
        }

        return tempoConclusao - tempoChegada - tempoExecucao;
    }

    public int getTempoRetorno() {
        if (tempoConclusao == -1) {
            return 0;
        }

        return tempoConclusao - tempoChegada;
    }

    public boolean terminou() {
        return tempoRestante == 0;
    }

    @Override
    public String toString() {
        return "P" + id +
                " | Prioridade: " + prioridade +
                " | Restante: " + tempoRestante;
    }
}
