package company.restaurante;

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
