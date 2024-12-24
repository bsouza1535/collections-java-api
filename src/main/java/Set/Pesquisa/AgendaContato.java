package main.java.Set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {
    Set<Contato> contatosSet;

    public AgendaContato() {
        this.contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int telefone) {
        contatosSet.add(new Contato(nome, telefone));
    }

    public void exibirContatos() {
        System.out.println(this.contatosSet);
    }

    public void pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatosSet) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        System.out.println(contatosPorNome);
    }

    public Set<Contato> atualizarNumeroContato(String nome, int novoNumero) {
        Set<Contato> contatosAtualizados = new HashSet<>();

        for (Contato c : contatosSet) {
            if (c.getNome().equals(nome)) {
                c.setNumeroDeTelefone(novoNumero);
                break;
            }
        }
        return contatosAtualizados;
    }


    public static void main(String[] args) {
        AgendaContato agenda = new AgendaContato();
        agenda.adicionarContato("Joao", 1);
        agenda.adicionarContato("Maria", 2);
        agenda.adicionarContato("Joao Alfredo", 3);
        agenda.adicionarContato("Maria", 100);
        agenda.exibirContatos();
        agenda.pesquisarPorNome("Joao");
        agenda.atualizarNumeroContato("Maria", 10);
        agenda.exibirContatos();
    }
}
