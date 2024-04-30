package sistemadecadastro;

import com.sun.source.tree.NewArrayTree;
import model.entities.PessoaJuridica;
import model.manegers.PessoaFisicaRepo;
import model.manegers.PessoaJuridicaRepo;


import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private Scanner sc;

     private final PessoaJuridicaRepo pjRepo;
     private final PessoaFisicaRepo pfRepo;
     
    private static String option;
    private static String messageOption = "Você deseja %s um arquivo de Pessoa física ou pessoa jurídica";

    public FileManager() {
        pfRepo = new PessoaFisicaRepo();
        pjRepo = new PessoaJuridicaRepo();
        sc = new Scanner(System.in);
    }

    public  void CreateFile()  {
        System.out.printf(messageOption, "criar");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("F")) {
            String nameFile = "pessoas-fisicas.bin";
            pfRepo.persistir(nameFile);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFile);
        } else if (option.equalsIgnoreCase("J")) {
            String nameFilePj = "pessoas-juridicas.bin";
            pjRepo.persistir(nameFilePj);
            System.out.println("Dados inseridos com sucesso no arquivo: " + nameFilePj);
        }
    }

    public void recoverFile() {
        System.out.printf(messageOption, "abrir");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("F")) {
            String nameFile = "pessoas-fisicas.bin";
            pfRepo.recuperar(nameFile);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
        } else if (option.equalsIgnoreCase("J")) {
            String nameFilePj = "pessoas-juridicas.bin";
            pjRepo.recuperar(nameFilePj);
            System.out.println("Dados obtidos com sucesso do arquivo:" + nameFilePj);
        }
    }
}
