package sistemadecadastro;

import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;
import model.manegers.PessoaFisicaRepo;
import model.manegers.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.Scanner;

public class CrudMethods {
    private CadastroPessoaFisica cadastroPf = new CadastroPessoaFisica();
    private CadastroPessoaJuridica cadastroPj = new CadastroPessoaJuridica();
    private PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
    private PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();
    private final Scanner sc = new Scanner(System.in);

    public void Crud (String option) throws IOException, ClassNotFoundException {
        int idPessoa;
        String selection;
        String type;
        switch (option) {
            case "1":
                System.out.println("F - Cadastrar pessoa física | J - Cadastrar pessoa jurídica");
                selection = sc.next();
                if (selection.equalsIgnoreCase("F")){
                    cadastroPf.createPf();
                    pfRepo.exibirpessoas();
                } else if (selection.equalsIgnoreCase("J")) {
                    cadastroPj.createPj();
                    pjRepo.persistir("pessoas-juridicas.dat");
                } else {
                    System.out.println("Opção invalida");
                }
                break;
            case "2":
                System.out.println("F - Alterar pessoa física | J - Alterar pessoa jurídica");
                type = sc.next();
                if (type.equalsIgnoreCase("F")) {
                    pfRepo.recuperar("pessoas-fisicas.dat");
                    if (!cadastroPf.obterTodos().isEmpty()) {
                        cadastroPf.showPf();
                        System.out.println("Insira o id da pessoa que deseja alterar");
                        idPessoa = sc.nextInt();
                        PessoaFisica pessoaAlterada = pfRepo.obter(idPessoa);
                        if (pessoaAlterada != null) {
                            cadastroPf.alterar(pessoaAlterada);
                        } else {
                            System.out.println("Pessoa não encontrada");
                        }
                    }
                } else if (type.equalsIgnoreCase("J")) {
                    pjRepo.recuperar("pessoas-juridicas-dat");
                    if(!cadastroPj.obterTodos().isEmpty()) {
                        cadastroPj.showPj();
                        System.out.println("Insira o id da pessoa que deseja alterar");
                        idPessoa = sc.nextInt();
                        PessoaJuridica pessoaAlterada = pjRepo.obter(idPessoa);
                        if(pessoaAlterada != null) {
                            cadastroPj.alterar(pessoaAlterada);
                            pjRepo.persistir("pessoas-juridicas.dat");
                        } else {
                            System.out.println("Pessoa não encontrada");
                        }
                    } else {
                        System.out.println("Não há pessoas Juridicas cadastradas");
                    }
                }
                break;

        }
    }

}
