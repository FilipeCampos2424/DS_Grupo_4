public class TesteGerenciador {

    public static void main(String[] args) {

        GerenciadorFuncionarios gerenciador =
            new GerenciadorFuncionarios();

        Funcionario joao =
            new Funcionario(
                "João",
                "12345678901",
                "Programador",
                3000,
                "TI",
                "CLT"
            );

        gerenciador.cadastrar(joao);

        Funcionario resultado =
            gerenciador.buscarPorCpf("12345678901");

        if (resultado != null) {
            System.out.println("Encontrado!");
            System.out.println(resultado.getNome());
        } else {
            System.out.println("Não encontrado.");
        }

    }

}
