/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantes;

/**
 *
 * @author Rafael
 */
public class Funcionarios {

    private String nome;
    private double salario;
    private String funcao;

    protected Restaurantes restaurante;

    public double calculaComissao() {
        return restaurante.getVenda()* 0.001;
    }

    public String mostraDados() {
        return this.restaurante.getNome() +
                "\nNOME: " + this.getNome() +
               "\nSALARIO: " + this.getSalario() +
               "\nCOMISSÃO: " + this.calculaComissao() +
                "\nFUNÇÃO: " + this.getFuncao();
        
    }

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}