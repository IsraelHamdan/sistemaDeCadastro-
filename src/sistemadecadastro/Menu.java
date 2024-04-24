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



    public void Create() throws IOException {
        System.out.println("Você deseja cadastrar uma pessoa física ou juridica");
        selected = sc.next();
        if (selected.equalsIgnoreCase("F")) {
            cadastroPf.createPf();
            cadastroPf.showPf();
        } else if (selected.equalsIgnoreCase("J")) {
            cadastroPj.createPj();
            cadastroPj.showPj();
        }
    }

    public  void Alterar() throws IOException {
        System.out.println("Você deseja alterar uma pessoa física ou juridica");
        selected = sc.nextLine();
        if (selected.equalsIgnoreCase("F")) {
            pfRepo.alterar();
        } else if (selected.equals("J")) {
            pjRepo.alterar();
        }
    }

    public void Excluir() throws IOException {
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

    public void buscarPeloId() throws IOException {
        System.out.println("Você deseja buscar uma pessoa física ou juridica");
        selected = sc.nextLine();
        if (!selected.equalsIgnoreCase("F")) {
            System.out.println("Qual id da pessoa que você deseja buscar? ");
            pessoaId = sc.nextInt();
            pfRepo.obter(pessoaId);

        } else if(!selected.equalsIgnoreCase("J")) {
            System.out.println("Qual id da pessoa que você deseja buscar? ");
            int pessoaId = sc.nextInt();
            pjRepo.obter(pessoaId);
        }
    }

    public void ExibirPessoas(){
        System.out.println("Você deseja exibir as pessoas físicas ou juridicas");
        selected = sc.nextLine();
        if(selected.equalsIgnoreCase("F")) {
            pfRepo.exibirpessoas();
        } else if (selected.equalsIgnoreCase("J")) {
            pjRepo.exibirPessoasJuridicas();
        }
    }

    public void Persisir () throws IOException {
        fileManager.CreateFile();
    }
    public  void Recuperar() throws IOException {
        fileManager.recoverFile();
    }
}

