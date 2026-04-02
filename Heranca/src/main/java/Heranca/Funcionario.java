
package Heranca;

public class Funcionario {
    private String nome;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double calculaBonificacao () {
        return this.getSalario() * 0.1;
    }
  
  public String mostraDados (){
      return this.getNome()+ "\n SALARIO: "+ this.getSalario() + "\n Bonificação: "+ this.calculaBonificacao();
  }
}
