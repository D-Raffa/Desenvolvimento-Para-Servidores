/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packageorientação;

/**
 *
 * @author Rafael
 */
public class TestaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //estancia do primeiro objeto segundo as aulas do professor 
        Cliente c1 = new Cliente ();
    
        // Atribuido valores aos atributos 
        //do objeto instanciado 
        c1.codigo = 1;
        c1.nome = "Rafael Leme";
        
        //segundo objeto
        Cliente c2 = new Cliente();
        
        // atribuindo valor aos atributos 
        // do objeto estanciado 
        
        c2.codigo =2;
        c2.nome = "Larissa Perez";
        
        //mostrando conteudo 
        //com que foi atribuido 
        
        System.out.println(c1.codigo);
        System.out.println(c1.nome);
        
         System.out.println(c2.codigo);
         System.out.println(c2.nome);
        
        
    }
    
}
