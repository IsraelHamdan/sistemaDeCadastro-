package model.manegers;

import model.entities.PessoaJuridica;
import java.util.*;
import java.io.*;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        this.pessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int p = 0; p < pessoasJuridicas.size(); p++) {
            PessoaJuridica pessoaJuridicaAual = pessoasJuridicas.get(p);
            if (pessoaJuridicaAual.getId() == pessoaJuridica.getId()) {
                pessoasJuridicas.set(p, pessoaJuridica);
            }
        }
    }

    public PessoaJuridica obter(int id) {
        for (int p = 0; p < pessoasJuridicas.size(); p++) {
            PessoaJuridica pessoaJuridica = pessoasJuridicas.get(p);
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    public void excluir(int id) {
        Iterator<PessoaJuridica> iterator = pessoasJuridicas.iterator();
        while (iterator.hasNext()) {
            PessoaJuridica pessoa = iterator.next();
            if (pessoa.getId() == id) {
                iterator.remove();
                return;
            }
        }

    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return new ArrayList<> (pessoasJuridicas);
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
