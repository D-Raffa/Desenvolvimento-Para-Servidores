/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio2;

/**
 *
 * @author Rafael
 */
public class Funcionario {
    String nome;
    double salario;
    String cargo;
    
     void Aumento (double AumentoSalario) { 
        this.salario += AumentoSalario;
    }
        void DadosFuncionario () {
            System.out.println("Nome do Funcionario: " + this.nome + (" // Cargo Do Funcionario: ") + this.cargo + (" // Salario do Funcionario: " + this.salario));
        }
}
