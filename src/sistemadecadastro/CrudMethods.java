package sistemadecadastro;

import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;

import java.util.Scanner;

public class CrudMethods {
    private CadastroPessoaFisica cadastroPf = new CadastroPessoaFisica();
    private CadastroPessoaJuridica cadastroPj = new CadastroPessoaJuridica();
    private final Scanner sc = new Scanner(System.in);

    public void Crud(String option) {
        int idPessoa = sc.nextInt();
        String selection = sc.next();
        switch(option) {
            case "1":
                System.out.println("F - Cadastrar pessoa física | J - Cadastrar pessoa jurídica");
                if (selection.equalsIgnoreCase("F")) {
                    cadastroPf.createPf();
                } else if (selection.equalsIgnoreCase("J")) {
                    cadastroPj.createPj();
                } else {
                    System.out.println("Opção invalida!!");
                }
                break;
            case "2":
                if (selection != null) {
                    switch (selection) {
                        case "F":
                            if (!cadastroPf.obterTodos().isEmpty()) {
                                cadastroPf.showPf();
                                System.out.println("Insira o id da pessoa que deseja alterar");
                                PessoaFisica pessoaAlterada = null;
                                for (PessoaFisica pessoaFisica : cadastroPf.obterTodos()) {
                                    if (pessoaFisica.getId() == idPessoa) {
                                        pessoaAlterada = pessoaFisica;
                                        break;
                                    }
                                };
                                if (pessoaAlterada != null) {
                                    cadastroPf.alterar(pessoaAlterada);
                                }
                            }
                            break;
                        case "J":
                            if (!cadastroPj.obterTodos().isEmpty()) {
                                cadastroPj.showPj();
                                System.out.println("Insira o id da pessoa que deseja alterar");
                                PessoaJuridica pessoaAlterada = null;
                                for (PessoaJuridica pessoaJuridica : cadastroPj.obterTodos()) {
                                    if (pessoaJuridica.getId() == idPessoa) {
                                        pessoaAlterada = pessoaJuridica;
                                        break;
                                    }
                                };
                                if (pessoaAlterada != null) {
                                    cadastroPj.alterar(pessoaAlterada);
                                }
                            }
                            break;


                    }
                }


        }
    }

}
