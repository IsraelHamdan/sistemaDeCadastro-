package sistemadecadastro;

import model.entities.PessoaFisica;
import model.manegers.PessoaFisicaRepo;

import java.io.IOException;
import java.util.ArrayList;

public class CadastroPessoaFisica extends PessoaFisicaRepo {
    PessoaFisicaRepo pfRpo1 = new PessoaFisicaRepo();
    PessoaFisicaRepo pfRepo2 = new PessoaFisicaRepo();
    static String nameFile = "pessoas_fisicas_data.dat";

    protected void createPf() {
        PessoaFisica p1 = new PessoaFisica(1, "Fulano", "048.542.455-82", 20);
        PessoaFisica p2 = new PessoaFisica(2, "Beltrano", "186.856.458-58", 22);

        pfRpo1.inserir(p1);
        pfRpo1.inserir(p2);
    }

    protected void createfilePf() {
        try {
            pfRpo1.persistir(nameFile);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFile);
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados no arquivo: " + nameFile);
            e.printStackTrace();
        }

    }

    protected void recoverFilePf() {
        try {
            pfRepo2.recuperar(nameFile);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados do arquivo: "
                    + nameFile);
            e.printStackTrace();
        }

    }

    protected void showPf() {
        ArrayList<PessoaFisica> pessoasRecuperada = pfRepo2.obterTodos();
        for (PessoaFisica pessoa : pessoasRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CPF:" + pessoa.getCpf() + "\n"
                    + "Idade:" + pessoa.getIdade() + "\n");

        }
    }
}
