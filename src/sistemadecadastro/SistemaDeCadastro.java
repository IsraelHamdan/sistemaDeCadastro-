package sistemadecadastro;

public class SistemaDeCadastro {
    private static String nameFile;
    public static void main(String[] args) {
        // Cadastrando uma PessoaFisica
        CadastroPessoaFisica cadastroPf = new CadastroPessoaFisica();
        cadastroPf.createPf();
        cadastroPf.createfilePf();
        cadastroPf.recoverFilePf();
        cadastroPf.showPf();

        // Cadastrando uma PessoaJuridica
        CadastroPessoaJuridica cadastroPj = new CadastroPessoaJuridica();
        cadastroPj.createPj();
        cadastroPj.createFilePj();
        cadastroPj.recoverFilePj();
        cadastroPj.showPj();
    }



}