/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantes;

/**
 *
 * @author Rafael
 */
public class Gerentes extends Funcionarios {

    private String nivel;

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
  @Override
    public double calculaComissao() {
        return this.restaurante.getVenda() * 0.005;
    }
  @Override
    public String mostraDados() {
        return "RESTAURANTE: " + this.restaurante.getNome() +
               "\nNOME: " + this.getNome() +
               "\nSALARIO: " + this.getSalario() +
               "\nCOMISSÃO: " + this.calculaComissao() +
               "\nNÍVEL: " + this.getNivel();
    }
}
