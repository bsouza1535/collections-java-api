package main.java.List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTarefa {

    List<Tarefa> tarefaList = new ArrayList<>();

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefaParaRemover = new ArrayList<>();

        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefaParaRemover.add(tarefa);
            }
        }
        tarefaList.removeAll(tarefaParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTarefa listaTarefa = new ListaTarefa();
        boolean continua = true;

        while (continua){
            System.out.println("""
                    Digite qual operação deseja efetuar:
                    1 - Adicionar tarefa à lista;
                    2 - Remover tarefa da lista;
                    3 - Obter número de elementos da lista;
                    4 - Obter descrições existentes na lista.
                    """);

            int  opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite a tarefa a ser adicionada: ");
                    String descricao = scanner.next();
                    listaTarefa.adicionarTarefa(descricao);
                    break;
                case 2:
                    System.out.println("Digite a tarefa a ser removido: ");
                    String descricaoRemovida = scanner.next();
                    listaTarefa.removerTarefa(descricaoRemovida);
                    break;
                case 3:
                    System.out.println("O total de itens em sua lista é: " + listaTarefa.obterNumeroTotalTarefas());
                    break;
                case 4:
                    System.out.println("Segue as atividades da lista: ");
                    listaTarefa.obterDescricoesTarefas();
                    break;
                default:
                    System.out.println("O valor é inválido, estamos finalizando sua sessão...");
                    continua = false;
                    break;

            }
        }
        scanner.close();
    }
}