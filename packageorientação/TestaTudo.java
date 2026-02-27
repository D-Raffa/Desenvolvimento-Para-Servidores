/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packageorientação;

/**
 *
 * @author Rafael
 */
public class TestaTudo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //instancia dos objetos 
        Agencia a1 = new Agencia();
        Cliente c1 = new Cliente();
        Conta co1 = new Conta ();
        CartaoDeCredito cdc1 = new CartaoDeCredito();
        
        //atribuindo valores aos atributos dos objetos
        
        c1.codigo = 1;
        c1.nome = "Rafael Lima";
        a1.numero = 1234;
        
        co1.numero = 1234 ;
        co1.saldo = 1000;
        co1.limite = 500;
        
        cdc1.numero = 1111;
        cdc1.dataDeValidade = "01/01/2026";
        
        //mostrando todos os objetos 
        
        System.out.println("Agencia: " + a1.numero);
         System.out.println("Codigo do Cliente: " + c1.codigo);
          System.out.println("Nome do Cliente: " + c1.nome);
           System.out.println("Numero da Conta do Cliente: " + co1.numero);
            System.out.println("Saldo da Conta do Cliente: " + co1.saldo);
             System.out.println("Limite da Conta do Cliente: " + co1.limite);
              System.out.println("Numero Do Cartao de Credito do Cliente: " + cdc1.numero);
               System.out.println("Data de Validade do Cartao de Credito do Cliente: " + cdc1.dataDeValidade);
                
    }
    
}
