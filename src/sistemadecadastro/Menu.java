package sistemadecadastro;

import model.manegers.PessoaFisicaRepo;


import java.io.IOException;
import java.util.Scanner;


public class Menu {
    static Scanner sc = new Scanner(System.in);
    static String type;

    public static void Create() throws IOException {
        System.out.println("F - Cadastrar pessoa física | J - Cadastrar11 pessoa jurídica");
        type = sc.nextLine();
        if (type.equalsIgnoreCase("F")) {
            CadastroPessoaFisica.createPf();
        } else if (type.equalsIgnoreCase("J")) {
            System.out.println();
        }


    }
    public static void Alterar() throws IOException {
        System.out.println("F - Alterar pessoa física | J - Alterar pessoa jurídica");
        type = sc.nextLine();
        if (type.equalsIgnoreCase("F")) {
            PessoaFisicaRepo.alterar();
        } else if (type.equals("J")) {
            System.out.println("Chamar pessoa jurídica.");
        }
    }
    public static void Excluir() {
        System.out.println("F - Excluir pessoa física | J - Excluir pessoa jurídica");
        type = sc.nextLine();
        if (!type.equalsIgnoreCase("F")) {
            System.out.println("Digite o id da pessoa que você quer excluir.");
            int pessoaId = sc.nextInt();
            PessoaFisicaRepo.excluir(pessoaId);
            System.out.println("Pessoa excluida com sucesso");
        } else if(!type.equalsIgnoreCase("J")) {
            System.out.println("Digite o id da pessoa que você quer excluir.");
            int pessoaId = sc.nextInt();
            System.out.println("Pessoa excluida com sucesso");
        }
    }
    public static void buscarPeloId() {
        System.out.println("F - Buscar pessoa física | J - Buscar pessoa jurídica");
        type = sc.nextLine();
        if (!type.equalsIgnoreCase("F")) {
            System.out.println("Digite o id da pessoa que você quer excluir.");
            int pessoaId = sc.nextInt();
            PessoaFisicaRepo.obter(pessoaId);

        } else if(!type.equalsIgnoreCase("J")) {
            System.out.println("Digite o id da pessoa que você quer excluir.");
            int pessoaId = sc.nextInt();

        }
    }
}

