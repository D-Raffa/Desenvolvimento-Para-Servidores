/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio2;

/**
 *
 * @author Rafael
 */
public class TestaFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
       Funcionario fn1 = new Funcionario();
       fn1.nome = "Rafael Leme";
       fn1.salario = 12000;
       fn1.cargo = "Product Owner";
        
       fn1.Aumento(5000);
  
       Funcionario fn2 = new Funcionario();
       fn2.nome = "Larissa Perez";
       fn2.salario = 8000;
       fn2.cargo = "Design";
       
        fn2.Aumento(3000);
        
        System.out.println(fn1.nome);
        System.out.println(fn1.salario);
        
        System.out.println(fn2.nome);
        System.out.println(fn2.salario);
       
        fn1.DadosFuncionario();
        fn2.DadosFuncionario();
       
    }
    
}
