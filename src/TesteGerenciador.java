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

        Funcionario enzo =
            new Funcionario(
                "Enzo",
                "109876543213",
                "Apresentador de tele novela",
                3000,
                "TI",
                "CLT"
            );

        gerenciador.cadastrarFuncionario(joao);
        gerenciador.cadastrarFuncionario(eleno);
        gerenciador.cadastrarFuncionario(enzo);
        
        Funcionario resultado = gerenciador.buscarPorCpf("10987654321");
        if (resultado != null) {
            System.out.println("Encontrado!");
            System.out.println(resultado.getNome());
        } else {
            System.out.println("Não encontrado.");
        }

        
        gerenciador.desativarFuncionario("10987654321");
        gerenciador.desativarFuncionario("109876543213");

        System.out.print(gerenciador.filtrarAtivos());
    }


    
}
