package model.entities;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private  int id;
    private  String nome;
    
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Pessoa() {
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String exibir() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
}
