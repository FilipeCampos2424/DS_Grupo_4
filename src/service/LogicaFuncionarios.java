///esboço do codico, ainda não está completo apenas para ter uma ideia

import java.util.ArrayList;
import java.util.Scanner;

public class LogicaFuncionarios01 {


 private ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();

public void listarTodos() {
    
 if (listaDeFuncionarios.isEmpty()) {
 System.out.println("Nenhum funcionário cadastrado no sistema.");
        return; 
    }

    System.out.println("Lista de Todos os Funcionários");
    
    
    for (Funcionario f : listaDeFuncionarios) {
        System.out.println("Nome: " + f.nome + " | CPF: " + f.cpf + " | Cargo: " + f.cargo);
    }
}

public boolean cadastrar(Funcionario f) {
  
    if (validar(f) == false) {
        System.out.println("Não foi possível cadastrar: dados inválidos.");
        return false; 
    }

   
    listaDeFuncionarios.add(f);
    System.out.println("Funcionário cadastrado com sucesso!");
    return true;
}

public boolean atualizar(Funcionario f) {

    if (validar(f) == false) {
        System.out.println("Não foi possível atualizar:");
        return false;
    }

   
    for (Funcionario existente : listaDeFuncionarios) {
        
        if (existente.cpf.equals(f.cpf)) {
            
            
            existente.nome = f.nome; existente.cargo = f.cargo;existente.salario = f.salario; existente.departamento = f.departamento; 
            
            System.out.println("Funcionário atualizado");
            return true; 
        }
    }

    System.out.println("Funcionário com o CPF " + f.cpf + " não foi encontrado.");
    return false;
}
public boolean gerenciar(ArrayList<Funcionario> listaFuncionarios) {
    Scanner leia = new Scanner(System.in);
    int menu;

    do {
        System.out.println("==========Menu Gerenciar============");
        System.out.println("1-Buscar por CPF");
        System.out.println("2-Contas por Departamentos");
        System.out.println("3-Desativar Funcionario");
        System.out.println("4-Buscar Por Nome"); 
        System.out.println("5-Todos os funcionarios");
        System.out.println("6-Sair");
        System.out.println("====================================");
        System.out.print("Escolha uma opção: ");
        menu = leia.nextInt();

        switch (menu) {
            case 1:
                System.out.println("");
                
                break; 
                
            case 2:
                System.out.println("");
                break;
                
            case 3:
                System.out.println("");
                break;
                
            case 4:
                System.out.println("");
                break;
                
            case 5:
                System.out.println("");
                break;
                
            case 6:
                System.out.println("");
                break;
                
            default:
               
                System.out.println("");
                break;
        }

    } while(menu != 6);


    return true; 
}



public boolean validar(Funcionario f) {
  
if (f.salario <= 0) {

  System.out.println(" O salário deve ser maior que zero");
   return false;


}
if (f.nome == null || f.nome.isEmpty()) {
    System.out.println(" O nome do funcionário não pode ficar vazio.");
    return false; 
}
if (f.cpf ==null || f.cpf.length() != 11   ) {
    System.out.println(" O CPF do funcionário deve ter exatamente 11 dígitos.");
    return false; 
}


      
        return true; 
}



    public static void main(String[] args) {
        //aqui vai ser o geral, aonde podera selecionar uma das opcoes desde consultyar a cadastrar  um funcionario
      // preparar para receber o objeto funcionario
        Scanner leia = new Scanner(System.in);
      int r;
do{
        System.out.println(("==========Menu============"));
        System.out.println(("1-Cadastrar:Funcionario "));
        System.out.println(("2-Atualizar:Funcionario"));
        System.out.println(("3-Gerenciar :Funcionarios"));
        System.out.println(("4-Sair"));

        System.out.println(("=========================="));
        r = leia.nextInt();
        

}while(r !=4);

       

System.out.println("Programa encerrado.");
        leia.close(); 
        

      
    }




}
