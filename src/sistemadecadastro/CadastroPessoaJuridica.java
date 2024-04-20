package sistemadecadastro;

import model.entities.PessoaJuridica;
import model.manegers.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPessoaJuridica extends PessoaJuridicaRepo {
    PessoaJuridicaRepo pjRepo1 = new PessoaJuridicaRepo();
    PessoaJuridicaRepo pjRepo2 = new PessoaJuridicaRepo();
    Scanner sc = new Scanner(System.in);
    protected void createPj() {
        System.out.println("Informe o nome da pessoa física:");
        String nome = sc.nextLine();

        System.out.println("Informe o CNPJ da pessoa física:");
        String cnpj = sc.nextLine();

        System.out.println("Informe a id da pessoa juridica:");
        int id = sc.nextInt();

        PessoaJuridica novaPessoa = new PessoaJuridica(id, nome, cnpj);
        pjRepo1.inserir(novaPessoa);

        System.out.println("Pessoa física cadastrada com sucesso!");
    }

    String nameFilePj = "pessoas_juridicas_data.dat";

    protected void createFilePj() {

        try {
            pjRepo1.persistir(nameFilePj);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFilePj);
        } catch (IOException e) {
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

    protected void showPj() {
        ArrayList<PessoaJuridica> pessoasRecuperada = pjRepo2.obterTodos();
        for (PessoaJuridica pessoa : pessoasRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CNPJ:" + pessoa.getCnpj() + "\n");

        }
    }

}
