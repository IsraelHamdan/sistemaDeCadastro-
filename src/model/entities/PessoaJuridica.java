package model.entities;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
     String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        setId(id);
        setNome(nome);
        this.cnpj = cnpj;
    }

    public PessoaJuridica() {

    }

    public String getCnpj() {
        return cnpj = cnpj;
    }

    public void setCnpj(String cnpj) {
        this.setCnpj(cnpj);
    }

    @Override
    public String exibir() {
        return "PessoaJuridica{" +
                "id=" + getId()
                + ", nome=" + getNome()
                + ", CNPJ =" + cnpj + ",";
    }
}
