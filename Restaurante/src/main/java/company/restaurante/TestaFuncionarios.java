package company.restaurante;

public class TestaFuncionarios {

    public static void main(String[] args) {

        Restaurantes r1 = new Restaurantes();
        r1.setNome("Tasca da Bairrada");
        r1.setCardapio("Português");
        r1.setVenda(530000.0);
        
          Restaurantes r2 = new Restaurantes();
        r2.setNome("Restaurante Principal");
        r2.setCardapio("Português");
        r2.setVenda(500000.0);
        
          Restaurantes r3 = new Restaurantes();
        r3.setNome("Senhor Vinho");
        r3.setCardapio("Europeu");
        r3.setVenda(350000.0);
        

        Funcionarios j = new Funcionarios();
        j.setFuncao("Barman");
        j.setNome("Joao Rodrigues");
        j.setSalario(2800.0);
        j.restaurante = r1;
        
        Funcionarios j2 = new Funcionarios();
        j2.setFuncao("Barman");
        j2.setNome("Rodrigo alves");
        j2.setSalario(2800.0);
        j2.restaurante = r2;
        
        Funcionarios j3 = new Funcionarios();
        j3.setFuncao("Barman");
        j3.setNome("Ricardo Alemão");
        j3.setSalario(2800.0);
        j3.restaurante = r3;

        Funcionarios p = new Funcionarios();
        p.setFuncao("Caixa");
        p.setNome("Priscila Rodrigues");
        p.setSalario(3100.0);
        p.restaurante = r1;
        
          Funcionarios p2 = new Funcionarios();
        p2.setFuncao("Caixa");
        p2.setNome("Jaqueline limeira");
        p2.setSalario(3100.0);
        p2.restaurante = r2;
        
          Funcionarios p3 = new Funcionarios();
        p3.setFuncao("Caixa");
        p3.setNome("Claudete Santos");
        p3.setSalario(3100.0);
        p3.restaurante = r3;

        Funcionarios b = new Funcionarios();
        b.setFuncao("Recepcionista");
        b.setNome("Karina Pereira");
        b.setSalario(2800.0);
        b.restaurante = r1;
        
        Funcionarios b2 = new Funcionarios();
        b2.setFuncao("Recepcionista");
        b2.setNome("Karina Pereira");
        b2.setSalario(2800.0);
        b2.restaurante = r2;
        
        Funcionarios b3 = new Funcionarios();
        b3.setFuncao("Recepcionista");
        b3.setNome("Karina Pereira");
        b3.setSalario(2800.0);
        b3.restaurante = r3;

        Funcionarios c = new Funcionarios();
        c.setFuncao("Cumim");
        c.setNome("Fabricio");
        c.setSalario(2500.0);
        c.restaurante = r1;
        
        Funcionarios c2 = new Funcionarios();
        c2.setFuncao("Cumim");
        c2.setNome("Bruno");
        c2.setSalario(2500.0);
        c2.restaurante = r2;
        
        Funcionarios c3 = new Funcionarios();
        c3.setFuncao("Cumim");
        c3.setNome("Maria");
        c3.setSalario(2500.0);
        c3.restaurante = r3;
        
        Garcons g1 = new Garcons();
        g1.setFuncao("Garçom");
        g1.setNome("Lucas Pires");
        g1.setSalario(1800.0);
        g1.setVendas(32000.0);
        g1.restaurante = r1;
        
         Garcons g2 = new Garcons();
        g2.setFuncao("Garçom");
        g2.setNome("Daniel Prado");
        g2.setSalario(1800.0);
        g2.setVendas(23000.0);
        g2.restaurante = r2;
        
         Garcons g3 = new Garcons();
        g3.setFuncao("Garçom");
        g3.setNome("Amanda");
        g3.setSalario(1800.0);
        g3.setVendas(15000.0);
        g3.restaurante = r3;
        
         Gerentes m1 = new Gerentes();
        m1.setNome("Gerente Carlos");
        m1.setNivel("Sênior");
        m1.setSalario(15000.0);
        m1.restaurante = r1;
        
          Gerentes m2 = new Gerentes();
        m2.setNome("Gerente Davi");
        m2.setNivel("Junior");
        m2.setSalario(10000.0);
        m2.restaurante = r2;
        
          Gerentes m3 = new Gerentes();
        m3.setNome("Gerente Marcos");
        m3.setNivel("Plêno");
        m3.setSalario(12000.0);
        m3.restaurante = r3;
       

        
         
        System.out.println("=========================================");
        System.out.println(m1.mostraDados());
        System.out.println("=========================================");
        System.out.println(g1.mostraDados());
        System.out.println("=========================================");
        System.out.println(p.mostraDados());
        System.out.println("=========================================");
        System.out.println(j.mostraDados());
        System.out.println("=========================================");
        System.out.println(b.mostraDados());
        System.out.println("=========================================");
        System.out.println(c.mostraDados());
        
                
        System.out.println("=========================================");
        System.out.println(m2.mostraDados());
        System.out.println("=========================================");
        System.out.println(g2.mostraDados());        
        System.out.println("=========================================");
        System.out.println(j2.mostraDados());
        System.out.println("=========================================");
        System.out.println(p2.mostraDados());
        System.out.println("=========================================");
        System.out.println(b2.mostraDados());
        System.out.println("=========================================");
        System.out.println(c2.mostraDados());
        
        
        System.out.println("=========================================");
        System.out.println(m3.mostraDados());
        System.out.println("=========================================");
        System.out.println(g3.mostraDados());
        System.out.println("=========================================");
        System.out.println(j3.mostraDados());                       
        System.out.println("=========================================");
        System.out.println(p3.mostraDados());
        System.out.println("=========================================");
        System.out.println(b3.mostraDados());
        System.out.println("=========================================");
        System.out.println(c3.mostraDados());
   
        
    }
}