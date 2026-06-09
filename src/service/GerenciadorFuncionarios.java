package service;
import model.Funcionario;
import java.util.ArrayList;

public class GerenciadorFuncionarios {

    private ArrayList<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    public boolean cadastrarFuncionario(Funcionario funcionario) {
        if (validarCpf(funcionario.getCpf())) {
            return false;
        }
        funcionarios.add(funcionario);
        return true;
    }

    public Funcionario buscarPorCpf(String cpfProcurado) {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario f = funcionarios.get(i);
            if (f.getCpf().equals(cpfProcurado)) {
                return f;
            }
        }
        return null;
    }

    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Funcionario> filtrarAtivos() {
        ArrayList<Funcionario> ativos = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.isAtivo()) {
                ativos.add(f);
            }
        }
        return ativos;
    }

    public boolean validarCpf(String cpf) {
        return buscarPorCpf(cpf) != null;
    }

    public boolean desativarFuncionario(String cpf) {
        Funcionario funcionario = buscarPorCpf(cpf);
        if (funcionario != null) {
            funcionario.setAtivo(false);
            return true;
        }
        return false;
    }

  

    public boolean reativarFuncionario(String cpf) {
        Funcionario funcionario = buscarPorCpf(cpf);
        if (funcionario != null) {
            funcionario.setAtivo(true);
            return true;
        }
        return false;
    }

    public int contarPorDepartamento(String departamento) {
        int contador = 0;
        for (Funcionario f : funcionarios) {
            if (f.isAtivo() && f.getDepartamento().equals(departamento)) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularTotalSalarios() {
        double total = 0;
        for (Funcionario f : funcionarios) {
            if (f.isAtivo()) {
                total += f.getSalario();
            }
        }
        return total;
    }
}
