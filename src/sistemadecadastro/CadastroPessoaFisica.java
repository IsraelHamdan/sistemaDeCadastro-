package sistemadecadastro;

import model.entities.PessoaFisica;
import model.manegers.PessoaFisicaRepo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CadastroPessoaFisica extends PessoaFisicaRepo {
    private static PessoaFisicaRepo pfRpo1 ;
    private static PessoaFisicaRepo pfRepo2 ;
    private PessoaFisica pessoaFisica;
    private MenuOptions menuOptions;

    private static Scanner sc ;

    public CadastroPessoaFisica () {
        pfRpo1 = new PessoaFisicaRepo();
        pfRepo2 = new PessoaFisicaRepo();
        pessoaFisica = new PessoaFisica();
        menuOptions = new MenuOptions();
        sc = new Scanner(System.in);
    }

    public void createPf()  {
        System.out.println("Informe o nome da pessoa física:");
        String nome = sc.nextLine();
        sc.nextLine();

        System.out.println("Informe o CPF da pessoa física:");
        String cpf = sc.nextLine();

        System.out.println("Informe a idade da pessoa física:");
        int idade = sc.nextInt();

        System.out.println("Informe o id dessa pessoa!");
        int id = sc.nextInt();

        PessoaFisica novaPessoa = new PessoaFisica(id, nome, cpf, idade);
        pfRpo1.inserir(novaPessoa);
        String pessoa = pfRpo1.exibirPessoa(novaPessoa);

        System.out.println("Pessoa física cadastrada com sucesso!" + pessoa );
        menuOptions.Menu();
    }

}
