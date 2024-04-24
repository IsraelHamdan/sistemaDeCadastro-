package sistemadecadastro;

import com.sun.source.tree.NewArrayTree;
import model.entities.PessoaJuridica;
import model.manegers.PessoaFisicaRepo;
import model.manegers.PessoaJuridicaRepo;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Scanner;

import static sistemadecadastro.CadastroPessoaFisica.pfRpo1;

public class FileManager {
    private Scanner sc = new Scanner(System.in);

     private PessoaJuridicaRepo pjRepo =  new PessoaJuridicaRepo();
     private PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
     
    private static String option;
    private static String messageOption = "Você deseja %s um arquivo de Pessoa física ou pessoa jurídica";

    public  void CreateFile() throws IOException {
        System.out.printf(messageOption, "criar");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("F")) {
            String nameFile = "pessoas-fisicas.bin";
            try {
                pfRpo1.persistir(nameFile);
                System.out.println("Dados inseridos com sucesso no arquivo: " + nameFile);
            } catch (IOException e) {
                System.out.println("Erro ao persistir os dados no arquivo: " + nameFile);
                e.printStackTrace();
            }
        } else if (option.equalsIgnoreCase("J")) {
            String nameFilePj = "pessoas-juridicas.bin";
            try {
                pjRepo.persistir(nameFilePj);
                System.out.println("Dados inseridos com sucesso no arquivo: " + nameFilePj);
            } catch (IOException e) {
                System.out.println("Erro ao persistir os dados no arquivo: " + nameFilePj);
                e.printStackTrace();
            }
        }
    }

    public void recoverFile() {
        System.out.printf(messageOption, "abrir");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("F")) {
            String nameFile = "pessoas-fisicas.bin";
            try {
                pjRepo.recuperar(nameFile);
                System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao recuperar os dados do arquivo: "
                        + nameFile);
                e.printStackTrace();
            }
        } else if (option.equalsIgnoreCase("J")) {
            String nameFilePj = "pessoas-juridicas.bin";
            try {
                pjRepo.recuperar(nameFilePj);
                System.out.println("Dados obtidos com sucesso do arquivo:" + nameFilePj);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao recuperar os dados do arquivo: "
                        + nameFilePj);
                e.printStackTrace();
            }
        }
    }
}
