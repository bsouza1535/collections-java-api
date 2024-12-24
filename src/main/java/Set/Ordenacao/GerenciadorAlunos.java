package main.java.Set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media) {
        alunosSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        for (Aluno aluno : alunosSet) {
            if (aluno.getMatricula() == matricula) {
                alunosSet.remove(aluno);
                break;
            }
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorAlunoPorNota());
        alunosPorNota.addAll(alunosSet);
        return alunosPorNota;
    }

    public void exibirAlunos() {
        System.out.println(alunosSet);
    }

    public static void main(String[] args) {

        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Bruno", 1, 8.5);
        gerenciadorAlunos.adicionarAluno("Zespede", 2, 7.5);
        gerenciadorAlunos.adicionarAluno("Armando", 3, 6.5);
        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        gerenciadorAlunos.removerAluno(2);
        gerenciadorAlunos.exibirAlunos();

    }
}
