package sistemadecadastro;

import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;
import model.manegers.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.ArrayList;

public class CadastroPessoaJuridica extends PessoaJuridicaRepo {
    PessoaJuridicaRepo pjRepo1 = new PessoaJuridicaRepo();
    PessoaJuridicaRepo pjRepo2 = new PessoaJuridicaRepo();

    protected void createPj() {
        PessoaJuridica pj1 = new PessoaJuridica(1, "XPTO", "12.345.678/0001-00");
        PessoaJuridica pj2 = new PessoaJuridica(2, "Lpto", "13.355.668/0702-01");

        pjRepo1.inserir(pj1);
        pjRepo1.inserir(pj2);
    }

    String nameFilePj = "pessoas_juridicas_data.dat";
    protected void createFilePj() {

        try {
            pjRepo1.persistir(nameFilePj);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFilePj);
        } catch (
                IOException e) {
            System.out.println("Erro ao persistir os dados no arquivo: " + nameFilePj);
            e.printStackTrace();
        }

    }

    protected void recoverFilePj() {
        try {
            pjRepo2.recuperar(nameFilePj);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFilePj);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados do arquivo: "
                    + nameFilePj);
            e.printStackTrace();
        }
    }

    public void showPj () {
        ArrayList<PessoaJuridica> pessoasRecuperada = pjRepo2.obterTodos();
        for(PessoaJuridica pessoa : pessoasRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CNPJ:" + pessoa.getCnpj() + "\n"
            );

        }
    }

}
