package model.entities;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    static String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        setId(id);
        setNome(nome);
        PessoaJuridica.cnpj = cnpj;
    }

    public PessoaJuridica() {

    }

    public static String getCnpj() {
        return cnpj = cnpj;
    }

    public static void setCnpj(String cnpj) {
        PessoaJuridica.setCnpj(cnpj);
    }

    @Override
    public String exibir() {
        return "PessoaJuridica{" +
                "id=" + getId()
                + ", nome=" + getNome()
                + ", CNPJ =" + cnpj + ",";
    }
}
