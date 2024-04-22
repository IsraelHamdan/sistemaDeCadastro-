package sistemadecadastro;

import model.entities.PessoaFisica;
import model.manegers.PessoaFisicaRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeCadastro {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Menu();
    }
    public static void Menu () throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================== \n");
        System.out.println("""
                1 - Incluir pessoa
                2 - Alterar pessoa\s
                3 - Excluir pessoa\s
                4 - Buscar pelo id\s
                5 - Exibir todos\s
                6 - Persistir dados\s
                7 - Recuperar dados\s
                0 - finalizar programa\s
                """
        );
        String option = sc.next();
        switch (option) {
            case "1":
                Menu.Create();
                break;
            case "2":
                Menu.Alterar();
                break;
        }
    }
}