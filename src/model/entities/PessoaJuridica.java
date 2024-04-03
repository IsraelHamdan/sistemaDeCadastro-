/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.io.Serializable;


public class PessoaJuridica extends Pessoa implements Serializable  {
    String cnpj; 
    public PessoaJuridica(int id, String nome,String cnpj) {
        setId(id);
        setNome(nome);
        this.cnpj = cnpj;
    }

    public PessoaJuridica() {

    }

    public String getCnpj() {
        return this.cnpj = cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String exibir() {
        return "PessoaJuridica{" + 
                "id=" + getId() 
                + ", nome=" + getNome() 
                + ", CNPJ =" + cnpj + ","
                ;
       
    }
    
    
    
    
}
