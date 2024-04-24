package model.manegers;

import model.entities.Pessoa;
import model.entities.PessoaFisica;
import sistemadecadastro.Main;

import java.util.*;
import java.io.*;

public class PessoaFisicaRepo {
    PessoaFisica pessoaFisica = new PessoaFisica();
    static Scanner sc = new Scanner(System.in);

    private static ArrayList<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }
    public  void exibirpessoas() {
        for(int p = 0; p < pessoasFisicas.size(); p++) {
            System.out.println(pessoasFisicas);
        }
    }

    public void alterar() throws IOException {

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
                    if (pessoaFisica.getId() == pessoaFisicaAtual.getId()) {
                        pessoasFisicas.set(i, pessoa);
                    }
                }

                // Exibir os dados atualizados da pessoa
                exibirPessoa(pessoa);
                Main.Menu();
            }
        } else {
            System.out.println("Não há pessoas cadastradas");
        }
    }

    public  void exibirPessoa(PessoaFisica pessoa) {
        System.out.println("======" +
            "nome" + pessoa.getNome()
            + "idade" + pessoa.getIdade()
            + "cpf" + pessoa.getCpf()
        );
    }


    public  PessoaFisica obter(int id) {
        for (int p = 0; p < pessoasFisicas.size(); p++) {
            PessoaFisica pesssoaFisicaEncontrada = pessoasFisicas.get(p);
            if (pessoaFisica.getId() ==  pesssoaFisicaEncontrada.getId()) {
                exibirPessoa(pessoaFisica);
                return pessoaFisica;
            }

        }
        return null;
    }

    public  ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas ;
    }

    public  void excluir(int id ) {
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
