package model.manegers;

import model.entities.Pessoa;
import model.entities.PessoaFisica;
import sistemadecadastro.SistemaDeCadastro;

import java.util.*;
import java.io.*;

public class PessoaFisicaRepo {
    static Scanner sc = new Scanner(System.in);

    private static List<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }
    public static void exibirpessoas() {
        pessoasFisicas.forEach(System.out::println);
    }

    public static void alterar() throws IOException {
        PessoaFisica pessoaFisica = new PessoaFisica();
        if (!obterTodos().isEmpty()) {
            exibirpessoas();
            System.out.println("Insira o id da pessoa que deseja alterar");
            int idPessoa = sc.nextInt();
            PessoaFisica pessoa = obter(idPessoa);
            exibirPessoa(pessoa);

            if (pessoa != null) {
                System.out.println("Qual o atributo que você quer modificar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Idade");
                System.out.println("3 - Cpf");

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
                        int novaIdade = sc.nextInt();
                        pessoa.setIdade(novaIdade);
                        break;
                    case 3:
                        System.out.println("Insira o novo CPF");
                        String novoCPF = sc.nextLine();
                        pessoa.setCpf(novoCPF);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                for (int i = 0; i < pessoasFisicas.size(); i++) {
                    PessoaFisica pessoaFisicaAtual = pessoasFisicas.get(i);
                    if (pessoaFisicaAtual.getId() == Pessoa.getId()) {
                        pessoasFisicas.set(i, pessoa);
                    }
                }

                // Exibir os dados atualizados da pessoa
                exibirPessoa(pessoa);
                SistemaDeCadastro.Menu();
            } else {
                System.out.println("Pessoa não encontrada");
            }
        } else {
            System.out.println("Não há pessoas cadastradas");
        }
    }

    public static void exibirPessoa(PessoaFisica pessoa) {
        System.out.println("Pessoa física modificada");
        System.out.println(pessoa.getId());
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
        System.out.println(pessoa.getCpf());
    }


    public static PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (Pessoa.getId() == id) {
                exibirPessoa(pessoaFisica);
                return pessoaFisica;
            }

        }
        return null;
    }

    public static List<PessoaFisica> obterTodos() {
        return pessoasFisicas ;
    }

    public static void excluir(int id ) {
        PessoaFisica pessoa = obter(id);
        for(int p = 0; p < pessoasFisicas.size(); p++) {
            if (pessoa.getId() == pessoasFisicas.get(p).getId()) {
                pessoasFisicas.remove(p);
            }
        }
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) inputStream.readObject();
        }
    }

}
