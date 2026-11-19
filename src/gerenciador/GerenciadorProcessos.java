
package gerenciador;

import java.util.ArrayList;
import java.util.List;

import modelo.Processo;

public class GerenciadorProcessos {

    private List<Processo> filaExterna;
    private List<Processo> filaProntos;
    private List<Processo> processosConcluidos;

    private int limiteAdmissao;
    private int totalAdmitidos;

    public GerenciadorProcessos(int limiteAdmissao) {
        this.limiteAdmissao = limiteAdmissao;

        filaExterna = new ArrayList<>();
        filaProntos = new ArrayList<>();
        processosConcluidos = new ArrayList<>();

        totalAdmitidos = 0;
    }

    public void adicionarProcesso(Processo processo) {
        filaExterna.add(processo);
    }

    public void admitirProcessos(int tempoAtual) {

        while (!filaExterna.isEmpty()
                && totalAdmitidos < limiteAdmissao) {

            Processo processo = filaExterna.get(0);

            if (processo.getTempoChegada() > tempoAtual) {
                break;
            }

            filaExterna.remove(0);
            filaProntos.add(processo);

            totalAdmitidos++;
        }
    }

    public void liberarVaga() {
        if (totalAdmitidos > 0) {
            totalAdmitidos--;
        }
    }

    public void concluirProcesso(Processo processo) {
        processosConcluidos.add(processo);
        liberarVaga();
    }

    public List<Processo> getFilaExterna() {
        return filaExterna;
    }

    public List<Processo> getFilaProntos() {
        return filaProntos;
    }

    public List<Processo> getProcessosConcluidos() {
        return processosConcluidos;
    }

    public int getTotalAdmitidos() {
        return totalAdmitidos;
    }

    public int getTotalNaFilaExterna() {
        return filaExterna.size();
    }

    public int getTotalProntos() {
        return filaProntos.size();
    }

    public int getTotalConcluidos() {
        return processosConcluidos.size();
    }
}
