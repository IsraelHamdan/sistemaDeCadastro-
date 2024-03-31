package model.manegers;

import model.entities.PessoaFisica;
import java.util.*;
import java.io.*;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        this.pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        this.pessoasFisicas.add(pessoaFisica);

    }

    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            PessoaFisica pessoaFisicaAtual = pessoasFisicas.get(i);
            if (pessoaFisicaAtual.getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
            }
        }
    }

    public PessoaFisica obter(int id) {
        for (int p = 0; p < pessoasFisicas.size(); p++) {
            PessoaFisica pessoaFisica = pessoasFisicas.get(p);
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }

        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return new ArrayList<>(pessoasFisicas) ;
    }

    public void excluir(int id) {
        Iterator<PessoaFisica> iterator = pessoasFisicas.iterator();
        while (iterator.hasNext()) {
            PessoaFisica pessoa = iterator.next();
            if (pessoa.getId() == id) {
                iterator.remove();
                return;
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
