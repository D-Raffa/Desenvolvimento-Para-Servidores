/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurantes;

/**
 *
 * @author Rafael
 */
public class TestaConexao {
    
/*
Teste para verificar se o banco conecta e desconecta
*/

    public static void main(String[] args) {
        
        Conexao c = new Conexao (); //criando objeto conexão
        c.abrirConexao();  //chamando o metodo de abertura do bando de dados
        
        try{
            Thread.sleep(4000);  //fazendo uma pausa de 4 segundos
            c.fecharConexao(); //fechando a conexão
            
        }catch (InterruptedException ex){
            //mensagem caso ocorra o erro
            System.out.println("houve algum problema com o encerramento da conexao" + ex.getMessage());
        }
        
        
    }
    
}
