package main.java.Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    Set<Tarefa> tarefasSet;

    public ListaTarefas() {
        this.tarefasSet = new HashSet<Tarefa>();
    }

    public void adicionarTarefa(String descricao, boolean status) {
        tarefasSet.add(new Tarefa(descricao, status));
    }

    public void removerTarefa(String descricao) {
        for (Tarefa tarefa : tarefasSet) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefasSet.remove(tarefa);
                break;
            }
        }
    }

    public void exibirTarefas() {
        System.out.println(tarefasSet);
    }

    public void contarTarefas(){
        System.out.println(tarefasSet.size());
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidasSet = new HashSet<Tarefa>();

        for (Tarefa tarefa : tarefasSet) {
            if (tarefa.isTarefaConcluida()) {
                tarefasConcluidasSet.add(tarefa);
            }
        }
        return tarefasConcluidasSet;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentesSet = new HashSet<>();

        for (Tarefa tarefa : tarefasSet) {
            if (!tarefa.isTarefaConcluida()) {
                tarefasPendentesSet.add(tarefa);
            }
        }
        return tarefasPendentesSet;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefasSet) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.setTarefaConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefasSet) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.setTarefaConcluida(false);
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefasSet.clear();
    }


    public static void main(String[] args) {
        ListaTarefas t = new ListaTarefas();

        t.adicionarTarefa("descricao1", true);
        t.adicionarTarefa("descricao2", false);
        t.adicionarTarefa("descricao3", false);
        t.adicionarTarefa("descricao4", true);
        t.adicionarTarefa("descricao5", false);
        t.adicionarTarefa("descricao6", true);
        t.exibirTarefas();
        t.contarTarefas();
        System.out.println(t.obterTarefasConcluidas());
        System.out.println(t.obterTarefasPendentes());
        t.exibirTarefas();
        t.marcarTarefaConcluida("descricao2");
        t.marcarTarefaPendente("descricao1");
        t.exibirTarefas();
        t.limparListaTarefas();
        t.exibirTarefas();
    }
}
