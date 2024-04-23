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
    static Scanner sc = new Scanner(System.in);

    static PessoaJuridicaRepo pjRepo1 =  new PessoaJuridicaRepo();
    static PessoaJuridicaRepo pjRepo2 = new PessoaJuridicaRepo();

    static PessoaFisicaRepo pfRepo1 = new PessoaFisicaRepo();
    static PessoaFisicaRepo pfRepo2 = new PessoaFisicaRepo();
    private static String option;
    private static String messageOption = "Você deseja %s um arquivo de Pessoa física ou pessoa jurídica";

    public static void CreateFile() throws IOException {
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
                pjRepo1.persistir(nameFilePj);
                System.out.println("Dados inseridos com sucesso no arquivo: " + nameFilePj);
            } catch (IOException e) {
                System.out.println("Erro ao persistir os dados no arquivo: " + nameFilePj);
                e.printStackTrace();
            }
        }
    }

    public static void recoverFile() {
        System.out.printf(messageOption, "abrir");
        option = sc.nextLine();
        if (option.equalsIgnoreCase("F")) {
            String nameFile = "pessoas-fisicas.bin";
            try {
                pfRepo2.recuperar(nameFile);
                System.out.println("Dados obtidos com sucesso do arquivo:" + nameFile);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao recuperar os dados do arquivo: "
                        + nameFile);
                e.printStackTrace();
            }
        } else if (option.equalsIgnoreCase("J")) {
            String nameFilePj = "pessoas-juridicas.bin";
            try {
                pjRepo2.recuperar(nameFilePj);
                System.out.println("Dados obtidos com sucesso do arquivo:" + nameFilePj);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao recuperar os dados do arquivo: "
                        + nameFilePj);
                e.printStackTrace();
            }
        }
    }
}
