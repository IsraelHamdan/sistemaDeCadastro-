package sistemadecadastro;

import model.entities.PessoaJuridica;
import model.manegers.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroPessoaJuridica extends PessoaJuridicaRepo {

    private final PessoaJuridicaRepo pjRepo;
    private final MenuOptions menuOptions;
    private final Scanner sc ;

    public CadastroPessoaJuridica () {
        pjRepo = new PessoaJuridicaRepo();
        menuOptions = new MenuOptions();
        sc = new Scanner(System.in);
    }

    protected void createPj()  {
        System.out.println("Informe o nome da pessoa juridica:");
        String nome = sc.nextLine();

        System.out.println("Informe o CNPJ da pessoa juridica:");
        String cnpj = sc.nextLine();

        System.out.println("Informe a id da pessoa juridica:");
        int id = sc.nextInt();

        PessoaJuridica novaPessoa = new PessoaJuridica(id, nome, cnpj);
        pjRepo.inserir(novaPessoa);

        System.out.println("Pessoa física cadastrada com sucesso!");
        menuOptions.Menu();
    }



    protected  void showPj() {
        ArrayList<PessoaJuridica> pessoasRecuperada = pjRepo.obterTodos();
        for (PessoaJuridica pessoa : pessoasRecuperada) {
            System.out.println("Id:" + pessoa.getId() + "\n"
                    + "Nome:" + pessoa.getNome() + "\n"
                    + "CNPJ:" + pessoa.getCnpj() + "\n");

        }
    }

}
