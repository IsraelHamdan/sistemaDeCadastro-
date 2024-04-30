package sistemadecadastro;

import java.util.Scanner;

public class MenuOptions {
    public MenuOptions() {
    }

    public void Menu ()  {
        Menu menuOptions = new Menu();
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
        String option = sc.nextLine();
        switch (option) {
            case "1":
                menuOptions.Create();
                break;
            case "2":
                menuOptions.Alterar();
                break;
            case "3":
                menuOptions.Excluir();
                break;
            case "4":
                menuOptions.buscarPeloId();
                break;
            case "5":
                menuOptions.exibirPessoas();
                break;
            case "6":
                menuOptions.persistir();
                break;
            case "7":
                menuOptions.recuperar();
                break;
        }
    }
}
