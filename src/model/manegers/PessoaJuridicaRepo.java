package model.manegers;

import model.entities.Pessoa;

import model.entities.PessoaJuridica;
import sistemadecadastro.Main;

import java.util.*;
import java.io.*;

public class PessoaJuridicaRepo {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        this.pessoasJuridicas.add(pessoaJuridica);
    }

    public static void exibirPessoaJuridica(PessoaJuridica pessoa) {
        System.out.println("Pessoa física modificada");
        System.out.println(Pessoa.getId());
        System.out.println(Pessoa.getNome());
        System.out.println(PessoaJuridica.getCnpj());

    }
    public static void exibirPessoasJuridicas() {
        for(int p = 0; p < pessoasJuridicas.size(); p++) {
            System.out.println(pessoasJuridicas);
        }
    }

    public static void alterar() throws IOException {
        PessoaJuridica pessoaJ = new PessoaJuridica();
        if (!obterTodos().isEmpty()) {
            exibirPessoaJuridica(pessoaJ);
            System.out.println("Insira o id da pessoa que deseja alterar");
            int idPessoa = sc.nextInt();
            PessoaJuridica pessoa = obter(idPessoa);
            exibirPessoaJuridica(pessoa);

            if (pessoa != null) {
                System.out.println("Qual o atributo que você quer modificar?");
                System.out.println("1 - Nome");
                System.out.println("2 - CNPJ");

                int option = sc.nextInt();
                sc.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Insira o novo nome");
                        String novoNome = sc.nextLine();
                        pessoa.setNome(novoNome);
                        break;
                    case 2:
                        System.out.println("Insira a nova idade");
                        String  novoCNPJ = sc.nextLine();
                        pessoaJ.setCnpj(novoCNPJ);
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                for (int pj = 0; pj < pessoasJuridicas.size(); pj++) {
                    PessoaJuridica pessoaJuridicaAtual = pessoasJuridicas.get(pj);
                    if (pessoaJuridicaAtual.getId() == Pessoa.getId()) {
                        pessoasJuridicas.set(pj, pessoa);
                    }
                }

                // Exibir os dados atualizados da pessoa
                exibirPessoaJuridica(pessoa);
                Main.Menu();
            } else {
                System.out.println("Pessoa não encontrada");
            }
        } else {
            System.out.println("Não há pessoas cadastradas");
        }
    }


    public static PessoaJuridica obter(int id) {
        for (int p = 0; p < pessoasJuridicas.size(); p++) {
            PessoaJuridica pessoaJuridica = pessoasJuridicas.get(p);
            if (pessoaJuridica.getId() == id) {
                exibirPessoaJuridica(pessoaJuridica);
                return pessoaJuridica;
            }
        }
        return null;
    }

    public static void excluir(int id ) {
        PessoaJuridica pessoa = obter(id);
        for(int p = 0; p < pessoasJuridicas.size(); p++) {
            if (pessoa.getId() == pessoasJuridicas.get(p).getId()) {
                pessoasJuridicas.remove(p);
            }
        }
    }

    public static ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasJuridicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) inputStream.readObject();
        }
    }
}
