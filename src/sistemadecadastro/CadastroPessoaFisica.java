package sistemadecadastro;

import model.entities.PessoaFisica;
import model.manegers.PessoaFisicaRepo;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroPessoaFisica extends PessoaFisicaRepo {
    static PessoaFisicaRepo pfRpo1 = new PessoaFisicaRepo();
    static PessoaFisicaRepo pfRepo2 = new PessoaFisicaRepo();
    static String nameFile = "pessoa-fisica-dat";
    static Scanner sc = new Scanner(System.in);

    protected static void createPf() throws IOException {
        System.out.println("Informe o nome da pessoa física:");
        String nome = sc.nextLine();

        System.out.println("Informe o CPF da pessoa física:");
        String cpf = sc.nextLine();

        System.out.println("Informe a idade da pessoa física:");
        int idade = sc.nextInt();

        System.out.println("Informe o id dessa pessoa!");
        int id = sc.nextInt();

        PessoaFisica novaPessoa = new PessoaFisica(id, nome, cpf, idade);
        pfRpo1.inserir(novaPessoa);


        System.out.println("Pessoa física cadastrada com sucesso!");
        SistemaDeCadastro.Menu();
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
        List<PessoaFisica> pessoasRecuperada = pfRepo2.obterTodos();
        for (PessoaFisica pessoa : pessoasRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CPF:" + pessoa.getCpf() + "\n"
                    + "Idade:" + pessoa.getIdade() + "\n");

        }
    }
}
