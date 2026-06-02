package service;
import model.Funcionario;
import java.util.ArrayList;

public class GerenciadorFuncionarios {

 private ArrayList<Funcionario> funcionarios;
 
 public GerenciadorFuncionarios() {
  funcionarios = new ArrayList<>();
 }
 
 public void cadastrar(Funcionario funcionario) {
  funcionarios.add(funcionario);
 }

 public Funcionario buscarPorCpf(String cpfProcurado) {
  
  if (cpfExiste(cpfProcurado)) {
   
   for (int i = 0; i < funcionarios.size(); i++) {
    Funcionario f = funcionarios.get(i);
    if (f.getCpf().equals(cpfProcurado)) {
     return f;
    }
   }
  }
  return null;
 }

 public boolean cpfExiste(String cpfProcurado) {
  for (int i = 0; i < funcionarios.size(); i++) {
   Funcionario f = funcionarios.get(i);

   if (f.getCpf().equals(cpfProcurado)) {
    return true;
   }
  }
  return false;
 }
 
}
