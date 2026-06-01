package service;

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
  for (int i = 0; i < funcionarios.size(); i++) {
   Funcionario f = funcionarios.get(i);

   if (f.getCpf().equals(cpfProcurado)) {
    return f;
   }
  }
  return null;
 }

 
}
