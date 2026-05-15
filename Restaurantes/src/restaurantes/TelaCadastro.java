/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class TelaCadastro extends JFrame {

    // declaração dos atributos de tela
    private final JPanel tela;
    private final JTextField txtNome;
    private final JTextField txtUsuario;
    private final JPasswordField passSenha;
    private final JPasswordField passConfSenha;

    // validação de cadastro correto
    private boolean cadastroValido;

    // metodo construtor da classe
    public TelaCadastro() {

        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("CADASTRO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha só esta tela
        setBounds(500, 200, 426, 230);

        tela = new JPanel();
        tela.setBackground(SystemColor.white);

        setContentPane(tela);
        tela.setLayout(null);

        // adicionando elementos na tela:

        JLabel lblIdentificacao = new JLabel("INFORMAR CAMPOS PARA CADASTRO");
        lblIdentificacao.setBounds(60, 0, 500, 39);
        lblIdentificacao.setFont(new Font("Calibri", 3, 19));
        tela.add(lblIdentificacao);

        JLabel lblNome = new JLabel("NOME");
        lblNome.setBounds(24, 50, 70, 15);
        tela.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(170, 50, 219, 19);
        tela.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setBounds(24, 75, 70, 15);
        tela.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(170, 75, 219, 19);
        tela.add(txtUsuario);
        txtUsuario.setColumns(10);

        JLabel lblsenha = new JLabel("SENHA");
        lblsenha.setBounds(24, 100, 70, 15);
        tela.add(lblsenha);

        passSenha = new JPasswordField();
        passSenha.setBounds(170, 100, 219, 19);
        tela.add(passSenha);

        JLabel lblconfsenha = new JLabel("CONFIRMAR SENHA");
        lblconfsenha.setBounds(24, 125, 110, 15);
        tela.add(lblconfsenha);

        passConfSenha = new JPasswordField();
        passConfSenha.setBounds(170, 125, 219, 19);
        tela.add(passConfSenha);

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setBounds(80, 156, 117, 25);
        tela.add(btnCadastrar);

        // ação no botão CADASTRAR
        btnCadastrar.addActionListener((ActionEvent e) -> {

            Usuario usu = new Usuario();

            usu.setNome(txtNome.getText());
            usu.setUsuario(txtUsuario.getText());
            usu.setSenha(passSenha.getText());

            // validação dos campos
            if ("".equals(usu.getNome())) {

                JOptionPane.showMessageDialog(null,
                        "Informe o nome!");

            } else if ("".equals(usu.getUsuario())) {

                JOptionPane.showMessageDialog(null,
                        "Informe o usuário!");

            } else if ("".equals(usu.getSenha())) {

                JOptionPane.showMessageDialog(null,
                        "Informe a senha!");

            } else if ("".equals(passConfSenha.getText())) {

                JOptionPane.showMessageDialog(null,
                        "Confirme a senha!");

            } else if (!usu.getSenha().equals(passConfSenha.getText())) {

                JOptionPane.showMessageDialog(null,
                        "As senhas não coincidem!");

            } else {

                cadastroValido = usu.cadastraUsuario(
                        usu.getNome(),
                        usu.getUsuario(),
                        usu.getSenha());

                // sucesso
                if (cadastroValido == true) {

                    JOptionPane.showMessageDialog(null,
                            "Usuário cadastrado com sucesso!\n"
                            + "Você já pode fazer login.");

                    // limpar campos
                    txtNome.setText("");
                    txtUsuario.setText("");
                    passSenha.setText("");
                    passConfSenha.setText("");

                    // fecha a tela de cadastro e volta ao login
                    dispose();

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Não foi possível cadastrar o usuário!\n"
                            + "Verifique se o nome de usuário já existe.");
                }
            }
        });

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(250, 156, 117, 25);
        tela.add(btnCancelar);

        // ação no botão CANCELAR -- fecha apenas esta tela
        btnCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }

    public void abreTela() {
        TelaCadastro PanelCadastro = new TelaCadastro();
        PanelCadastro.setVisible(true);
    }
}
 
