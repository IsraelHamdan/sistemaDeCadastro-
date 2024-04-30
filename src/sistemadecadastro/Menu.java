package sistemadecadastro;

import model.manegers.PessoaFisicaRepo;

import model.manegers.PessoaJuridicaRepo;


import java.io.IOException;
import java.util.Scanner;


public class Menu {
    static Scanner sc = new Scanner(System.in);
    static String selected;
    static int pessoaId;



    
    FileManager fileManager = new FileManager();
    CadastroPessoaFisica cadastroPf =  new CadastroPessoaFisica();
    CadastroPessoaJuridica cadastroPj =  new CadastroPessoaJuridica();
    PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
    PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();



    public void Create()  {
        System.out.println("Você deseja cadastrar uma pessoa física ou juridica");
        selected = sc.next();
        if (selected.equalsIgnoreCase("F")) {
            cadastroPf.createPf();
        } else if (selected.equalsIgnoreCase("J")) {
            cadastroPj.createPj();

        }
    }

    public  void Alterar(){
        System.out.println("F - Alterar pessoa física | J - Alterar pessoa juridica |");
        selected = sc.next();
        if (selected.equalsIgnoreCase("F")) {
            pfRepo.alterar();
            pfRepo.exibirPessoas();
        } else if (selected.equalsIgnoreCase("J")) {
            pjRepo.alterar();
            pjRepo.exibirPessoasJuridicas();
        }
    }

    public void Excluir()  {
        System.out.println("Você deseja excluir uma pessoa física ou juridica");
        selected = sc.nextLine();
        if (!selected.equalsIgnoreCase("F")) {
            System.out.println("Qual id da pessoa que você deseja excluir? ");
            pessoaId = sc.nextInt();
            pfRepo.excluir(pessoaId);
            System.out.println("Pessoa excluida com sucesso");
        } else if(!selected.equalsIgnoreCase("J")) {
            System.out.println("Qual id da pessoa que você deseja excluir? ");
            pessoaId = sc.nextInt();
            pjRepo.excluir(pessoaId);
            System.out.println("Pessoa excluida com sucesso");
        }
    }

    public void buscarPeloId() {
        System.out.println("Você deseja buscar uma pessoa física ou juridica");
        selected = sc.nextLine();
        if(selected.equalsIgnoreCase("F")) {
            System.out.println("Insira o ID da pessoa qu você deseja buscar");
            pessoaId = sc.nextInt();
            pfRepo.obter(pessoaId);
        } else if (selected.equalsIgnoreCase("J")) {
            System.out.println("Insira o ID da pessoa qu você deseja buscar");
            pessoaId = sc.nextInt();
            pjRepo.obter(pessoaId);
        }
    }

    public void exibirPessoas(){
        System.out.println("Você deseja exibir as pessoas físicas ou juridicas");
        selected = sc.nextLine();
        if(selected.equalsIgnoreCase("F")) {
            pfRepo.exibirPessoas();
        } else if (selected.equalsIgnoreCase("J")) {
            pjRepo.exibirPessoasJuridicas();
        }
    }

    public void persistir () {
        fileManager.CreateFile();
    }
    public  void recuperar() {
        fileManager.recoverFile();
    }
}

