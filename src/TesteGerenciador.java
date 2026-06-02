import model.Funcionario;
import service.GerenciadorFuncionarios;
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

        Funcionario eleno =
            new Funcionario(
                "eleno",
                "10987654321",
                "garoto de programa",
                3000,
                "TI",
                "CLT"
            );


        gerenciador.cadastrar(joao);
        gerenciador.cadastrar(eleno);

        
        Funcionario resultado = gerenciador.buscarPorCpf("10987654321");
        boolean existe = gerenciador.cpfExiste("10987654321");
        if (existe) {
            System.out.println("Encontrado!");
            System.out.println(resultado.getNome());
        } else {
            System.out.println("Não encontrado.");
        }
    }

}
