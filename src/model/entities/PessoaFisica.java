package model.entities;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {

    private static String cpf;
    private static int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        setId(id);
        setNome(nome);
        PessoaFisica.cpf = cpf;
        PessoaFisica.idade = idade;
    }

    public PessoaFisica() {
    }



    public static String getCpf() {
        return cpf;
    }

    public static void setCpf(String cpf) {
        PessoaFisica.cpf = cpf;
    }

    public static int getIdade() {
        return idade;
    }

    public static void setIdade(int idade) {
        PessoaFisica.idade = idade;
    }


    public  String exibir() {
        return "PessoaFisica{"
                + "id=" + getId()
                + ", nome=" + getNome()
                + ", cpf=" + cpf + ","
                + " idade=" + idade + '}';

    }

}
