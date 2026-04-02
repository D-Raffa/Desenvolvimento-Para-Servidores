/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package company.restaurante;

public class Garcons extends Funcionarios {

    private double vendas;

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
    
    @Override
public double calculaComissao() {
    return this.getVendas() * 0.1;
}
}