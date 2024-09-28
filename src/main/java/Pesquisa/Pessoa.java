package main.java.Pesquisa;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Comparable<Pessoa> {

    @Override
    public int compareTo(Pessoa o) {
        return Integer.compare(this.idade, o.idade);
    }
//Atributos da classe Pessoa.

    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Lista de pessoas:" +
                "{" + "\n" +
                "nome=" + nome + "," + "\n" +
                "idade=" + idade + "," + "\n" +
                "altura=" + altura + "," + "\n" +
                "}" + "\n";
    }
}

class ordenarPessoasPorAltura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return Double.compare(o1.getAltura(), o2.getAltura());
    }
}
