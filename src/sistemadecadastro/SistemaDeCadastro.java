package sistemadecadastro;
import java.io.IOException;
import java.util.ArrayList;


import model.manegers.*;
import model.entities.*;


public class SistemaDeCadastro {
    private static String nameFile;
    public static void main(String[] args) {
        PessoaFisicaRepo pfRpo1 = new PessoaFisicaRepo();

        PessoaFisica p1 = new PessoaFisica(1, "Fulano", "048.542.455-82", 20);
        PessoaFisica p2 = new PessoaFisica(2, "Beltrano", "186.856.458-58", 22);

        pfRpo1.inserir(p1);
        pfRpo1.inserir(p2);

        nameFile = "pessoas_fisicas_data.dat";

        try {
            pfRpo1.persistir(nameFile);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFile);
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados no arquivo: " + nameFile);
            e.printStackTrace();
        }

        PessoaFisicaRepo pfRepo2 = new PessoaFisicaRepo();
        try {
            pfRepo2.recuperar(nameFile);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados do arquivo: "
                    + nameFile);
            e.printStackTrace();
        }

        ArrayList<PessoaFisica> pessoasRecuperada = pfRepo2.obterTodos();
        for(PessoaFisica pessoa : pessoasRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CPF:" + pessoa.getCpf() + "\n"
                    + "Idade:" + pessoa.getIdade() + "\n"
            );

        }

        PessoaJuridicaRepo pjRepo1 = new PessoaJuridicaRepo();
        PessoaJuridicaRepo pjRepo2 = new PessoaJuridicaRepo();

        PessoaJuridica pj1 = new PessoaJuridica(1, "Xpto ltda", "12.345.678/0001-90\n");
        PessoaJuridica pj2 = new PessoaJuridica(2, "ships and sea", "98.765.432/0001-21\n");

        pjRepo1.inserir(pj1);
        System.out.println(pjRepo1.obter(1));
        pjRepo2.inserir(pj2);

        nameFile = "pessoas_juridicas_data.dat";

        try {
            pfRpo1.persistir(nameFile);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFile);
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados no arquivo: " + nameFile);
            e.printStackTrace();
        }

        try {
            pfRepo2.recuperar(nameFile);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados do arquivo: "
                    + nameFile);
            e.printStackTrace();
        }

        ArrayList<PessoaJuridica> pjRecuperada = pjRepo2.obterTodos();
        for(PessoaJuridica pessoa : pjRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CNPJ:" + pessoa.getCnpj() + "\n"
            );

        }

    }



}