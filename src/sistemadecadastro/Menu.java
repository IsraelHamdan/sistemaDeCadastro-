package sistemadecadastro;

import model.manegers.PessoaFisicaRepo;
import model.manegers.PessoaJuridicaRepo;


import java.io.IOException;
import java.util.Scanner;


public class Menu {
    static Scanner sc = new Scanner(System.in);
    static String selected;
    static int pessoaId;

    private final static String menssageOption = "Selecione F para pessoas físicas ou J para pessoas jurídicas";
    private final static String actionSelected = "Insira o id da pessoa que você quer:";

    public static void Create() throws IOException {
        System.out.println(menssageOption);
        selected = sc.next();
        if (selected.equalsIgnoreCase("F")) {
            CadastroPessoaFisica.createPf();
            CadastroPessoaFisica.showPf();
        } else if (selected.equalsIgnoreCase("J")) {
            CadastroPessoaJuridica.createPj();
            CadastroPessoaJuridica.showPj();
        }
    }

    public static void Alterar() throws IOException {
        System.out.println(menssageOption);
        selected = sc.nextLine();
        if (selected.equalsIgnoreCase("F")) {
            PessoaFisicaRepo.alterar();
        } else if (selected.equals("J")) {
            PessoaJuridicaRepo.alterar();
        }
    }

    public static void Excluir() throws IOException {
        System.out.println(menssageOption);
        selected = sc.nextLine();
        if (!selected.equalsIgnoreCase("F")) {
            System.out.println(actionSelected + "excluir");
            pessoaId = sc.nextInt();
            PessoaFisicaRepo.excluir(pessoaId);
            System.out.println("Pessoa excluida com sucesso");
        } else if(!selected.equalsIgnoreCase("J")) {
            System.out.println(actionSelected + "excluir");
            pessoaId = sc.nextInt();
            PessoaJuridicaRepo.excluir(pessoaId);
            System.out.println("Pessoa excluida com sucesso");
        }
    }

    public static void buscarPeloId() throws IOException {
        System.out.println(menssageOption);
        selected = sc.nextLine();
        if (!selected.equalsIgnoreCase("F")) {
            System.out.println(actionSelected + "buscar");
            pessoaId = sc.nextInt();
            PessoaFisicaRepo.obter(pessoaId);

        } else if(!selected.equalsIgnoreCase("J")) {
            System.out.println(actionSelected + "buscar");
            int pessoaId = sc.nextInt();
            PessoaJuridicaRepo.obter(pessoaId);
        }
    }

    public static void ExibirPessoas(){
        System.out.println(menssageOption);
        selected = sc.nextLine();
        if(selected.equalsIgnoreCase("F")) {
            PessoaFisicaRepo.exibirpessoas();
        } else if (selected.equalsIgnoreCase("J")) {
            PessoaJuridicaRepo.exibirPessoasJuridicas();
        }
    }

    public static void Persisir () throws IOException {
        FileManager.CreateFile();
    }
    public static void Recuperar() throws IOException {
        FileManager.recoverFile();
    }
}

