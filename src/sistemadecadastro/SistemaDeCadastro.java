package sistemadecadastro;

import java.io.IOException;
import model.manegers.PessoaFisicaRepo;
import model.manegers.PessoaJuridicaRepo;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;
import java.util.ArrayList;


public class SistemaDeCadastro {

    public static void main(String[] args) {
        PessoaFisicaRepo pfRpo1 = new PessoaFisicaRepo();

        PessoaFisica p1 = new PessoaFisica(1, "João Alfredo", "048.542.455-82", 20);
        PessoaFisica p2 = new PessoaFisica(2, "Davi Rosa", "186.856.458-58", 22);

        pfRpo1.inserir(p1);
        pfRpo1.inserir(p2);

        String nameFile = "pessoas_fisicas_data.dat";
        try {
            pfRpo1.persistir(nameFile);
            System.out.println("Dados inseri dados com sucesso no arquivo" + nameFile);
        } catch (IOException e) {
            System.out.println("Erro ao persistir os dados no arquivo: " + nameFile);
            e.printStackTrace();
        }

        PessoaFisicaRepo pfRepo2 = new PessoaFisicaRepo();
        try {
            pfRepo2.recuperar(nameFile);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados do arquivo: " 
                + nameFile);
            e.printStackTrace();
        }
        
        ArrayList<PessoaFisica> pessoasRecuperada = pfRepo2.obterTodos();
        for(PessoaFisica pessoa : pessoasRecuperada) {
            System.out.println(""
                    + "Id:" + pessoa.getId() + ","
                    + "Nome:" + pessoa.getNome() + ","
                    + "CPF:" + pessoa.getCpf() + ","
                    + "Idade:" + pessoa.getIdade() + ","
            );
               
        }
    }

}
