package model.entities;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private static int id;
    private static String nome;
    
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Pessoa() {
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        Pessoa.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Pessoa.nome = nome;
    }

    
    public String exibir() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
