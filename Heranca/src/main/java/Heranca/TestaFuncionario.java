/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Heranca;

/**
 *
 * @author Rafael
 */
public class TestaFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gerente g = new Gerente();
        
        g.setNome("Rafael Leme");
        g.setSalario(5000);
        
        g.setUsuario("Leme");
        g.setSenha("biscoito");
        
        Telefonista t = new Telefonista();
        t.setNome("Larissa");
        t.setSalario(10000);
        
        t.setEstacaoDeTrabalaho(15);
        
        Secretaria s = new Secretaria();
        s.setNome("Luiza");
        s.setSalario(6000);
        s.setRamal(356);
        
        //mostrar dados do gerente
        System.out.println("=========================================");
        System.out.println("GERENTE: ");
        System.out.println("Nome: " + g.getNome());
        System.out.println("Salario: " + g.getSalario());
        System.out.println("Usuario: " + g.getUsuario());
        System.out.println("Senha: " + g.getSenha());
        System.out.println("Bonificação: " + g.calculaBonificacao());
        
        //mostrar dados telefonista
        System.out.println("=========================================");
        System.out.println("TELEFONISTA: ");
        System.out.println("Nome: " + t.getNome());
        System.out.println("Salario: " + t.getSalario());
        System.out.println("Esteação de Trabalho: " + t.getEstacaoDeTrabalaho());
        System.out.println("Bonificação: " + t.calculaBonificacao());
        //mostrar dados da secretaria 
        System.out.println("=========================================");
        System.out.println("SECRETARIA: ");
        System.out.println("Nome: " + s.getNome());
        System.out.println("Salario: " + s.getSalario());
        System.out.println("Ramal: " + s.getRamal());
        System.out.println("Bonificação: " + s.calculaBonificacao());
        //mostra dados 
        System.out.println("=========================================");
        System.out.println(" GERENTE: " + g.mostraDados());
        System.out.println("=========================================");
        System.out.println(" SECRETARIA: " + s.mostraDados());
        System.out.println("=========================================");
        System.out.println(" TELEFONISTA: " + t.mostraDados());
    }
    
}
