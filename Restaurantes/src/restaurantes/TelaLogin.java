/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package restaurantes;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame {

    // tela objeto JPanel (tela em si)
    private final JPanel panelTela;

    // txtUsuario objeto JTextField (campo na tela)
    private final JTextField txtUsuario;

    // pswSenha objeto PasswordField (campo de tela)
    private final JPasswordField pswSenha;

    // validar se o usuario é correto
    private boolean usuarioValido;

    // Metodo construtor
    public TelaLogin() {

        // coloca o objeto na referencia do centro da tela
        setLocationRelativeTo(null);

        // não permite que o objeto seja expandido
        setResizable(false);

        // coloca titulo na caixa JFrame
        setTitle("Login -- Restaurante da Fatec");

        // quando clicado no X encerra todo o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // define o posicionamento e tamanho
        //         x    y   width  height
        setBounds(500, 200, 426, 212);

        // crio um objeto JPanel e atribuo ele a variavel panelTela
        panelTela = new JPanel();

        // define a cor de fundo do JPanel (tela)
        panelTela.setBackground(SystemColor.white);
        setContentPane(panelTela);

        // vou utilizar meu panel sem utilizar o padrão
        panelTela.setLayout(null);

        // adicionando elementos na tela:
        JLabel lblIdentificacao = new JLabel("IDENTIFICAÇÃO");
        lblIdentificacao.setBounds(144, 0, 160, 39);
        lblIdentificacao.setFont(new Font("Calibri", 4, 19));
        panelTela.add(lblIdentificacao);

        // identificação e posicionamento dos labels
        JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setBounds(24, 65, 70, 15);
        panelTela.add(lblUsuario);

        JLabel lblSenha = new JLabel("SENHA");
        lblSenha.setBounds(24, 92, 70, 15);
        panelTela.add(lblSenha);

        // identificação e posicionamento dos textFields
        txtUsuario = new JTextField();
        txtUsuario.setBounds(112, 63, 219, 19);
        panelTela.add(txtUsuario);
        txtUsuario.setColumns(10);

        pswSenha = new JPasswordField();
        pswSenha.setBounds(112, 90, 219, 19);
        panelTela.add(pswSenha);

        // identificação e posicionamento dos botões
        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.setBounds(200, 136, 117, 25);
        panelTela.add(btnEntrar);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setBounds(60, 136, 117, 25);
        panelTela.add(btnCadastrar);

        // ação no botão ENTRAR
        btnEntrar.addActionListener((ActionEvent e) -> {

            // instancio a classe usuario
            Usuario usu = new Usuario();

            // utilizo o setter de usuario e senha
            usu.setUsuario(txtUsuario.getText());
            usu.setSenha(pswSenha.getText());

            if ("".equals(txtUsuario.getText())) {

                JOptionPane.showMessageDialog(null,
                        "Campo usuário precisa ser informado!",
                        "Atenção",
                        JOptionPane.ERROR_MESSAGE);
                txtUsuario.grabFocus();

            } else if ("".equals(pswSenha.getText())) {

                JOptionPane.showMessageDialog(null,
                        "Campo senha precisa ser informado!",
                        "Atenção",
                        JOptionPane.ERROR_MESSAGE);
                pswSenha.grabFocus();

            } else {

                // verifico se o usuario consta no banco de dados
                usuarioValido = usu.verificaUsuario(usu.getUsuario(),
                        usu.getSenha());

                if (usuarioValido == true) {

                    // fecha a tela de login
                    dispose();

                    // abre a tela de boas-vindas passando o nome do usuario
                    TelaBemVindo telaBV = new TelaBemVindo(usu.getUsuario());
                    telaBV.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Usuário inválido ou inexistente!",
                            "Atenção",
                            JOptionPane.ERROR_MESSAGE);
                    limpaText();
                    txtUsuario.grabFocus();
                }
            }
        });

        // ação no botão CADASTRAR -- abre a tela de cadastro
        btnCadastrar.addActionListener((ActionEvent e) -> {

            TelaCadastro telaCad = new TelaCadastro();
            telaCad.setVisible(true);

        });
    }

    public void abreTela() {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }

    public void limpaText() {
        txtUsuario.setText("");
        pswSenha.setText("");
    }
}
