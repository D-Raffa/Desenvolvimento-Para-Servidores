/*
 * Tela de Alteração de Dados do Usuário
 * Permite alterar o nome de usuario e/ou a senha
 */
package restaurantes;

import java.awt.Color;
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
import javax.swing.SwingConstants;

public class TelaAlterarDados extends JFrame {

    // tela objeto JPanel (tela em si)
    private final JPanel tela;

    // campos de texto
    private final JTextField txtNovoUsuario;
    private final JPasswordField passSenhaAtual;
    private final JPasswordField passNovaSenha;
    private final JPasswordField passConfNovaSenha;

    // usuario logado no momento
    private final String usuarioLogado;

    // Metodo construtor -- recebe o usuario logado
    public TelaAlterarDados(String usuarioLogado) {

        this.usuarioLogado = usuarioLogado;

        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("ALTERAR DADOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(500, 200, 426, 310);

        tela = new JPanel();
        tela.setBackground(SystemColor.white);
        setContentPane(tela);
        tela.setLayout(null);

        // ----------------------------------------------------------
        // adicionando elementos na tela
        // ----------------------------------------------------------

        // titulo
        JLabel lblTitulo = new JLabel("ALTERAR DADOS DO USUÁRIO");
        lblTitulo.setBounds(0, 5, 426, 35);
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        tela.add(lblTitulo);

        // usuario atual (somente leitura, para referencia)
        JLabel lblUsuarioAtual = new JLabel("Usuário logado: " + usuarioLogado);
        lblUsuarioAtual.setBounds(0, 38, 426, 18);
        lblUsuarioAtual.setFont(new Font("Calibri", Font.ITALIC, 13));
        lblUsuarioAtual.setForeground(Color.WHITE);
        lblUsuarioAtual.setHorizontalAlignment(SwingConstants.CENTER);
        tela.add(lblUsuarioAtual);

        // ----------------------------------------------------------
        // campo: novo nome de usuario
        // ----------------------------------------------------------
        JLabel lblNovoUsuario = new JLabel("NOVO USUÁRIO");
        lblNovoUsuario.setBounds(24, 70, 130, 15);
        tela.add(lblNovoUsuario);

        txtNovoUsuario = new JTextField();
        txtNovoUsuario.setBounds(170, 68, 219, 19);
        txtNovoUsuario.setColumns(10);
        tela.add(txtNovoUsuario);

        // ----------------------------------------------------------
        // campo: senha atual (para confirmar identidade)
        // ----------------------------------------------------------
        JLabel lblSenhaAtual = new JLabel("SENHA ATUAL");
        lblSenhaAtual.setBounds(24, 100, 130, 15);
        tela.add(lblSenhaAtual);

        passSenhaAtual = new JPasswordField();
        passSenhaAtual.setBounds(170, 98, 219, 19);
        tela.add(passSenhaAtual);

        // ----------------------------------------------------------
        // campo: nova senha
        // ----------------------------------------------------------
        JLabel lblNovaSenha = new JLabel("NOVA SENHA");
        lblNovaSenha.setBounds(24, 130, 130, 15);
        tela.add(lblNovaSenha);

        passNovaSenha = new JPasswordField();
        passNovaSenha.setBounds(170, 128, 219, 19);
        tela.add(passNovaSenha);

        // ----------------------------------------------------------
        // campo: confirmar nova senha
        // ----------------------------------------------------------
        JLabel lblConfNovaSenha = new JLabel("CONFIRMAR SENHA");
        lblConfNovaSenha.setBounds(24, 160, 130, 15);
        tela.add(lblConfNovaSenha);

        passConfNovaSenha = new JPasswordField();
        passConfNovaSenha.setBounds(170, 158, 219, 19);
        tela.add(passConfNovaSenha);

        // instrucao ao usuario
        JLabel lblDica = new JLabel("* Preencha apenas os campos que deseja alterar.");
        lblDica.setBounds(24, 188, 380, 15);
        lblDica.setFont(new Font("Calibri", Font.ITALIC, 11));
        lblDica.setForeground(Color.WHITE);
        tela.add(lblDica);

        // ----------------------------------------------------------
        // botoes
        // ----------------------------------------------------------
        JButton btnSalvar = new JButton("SALVAR");
        btnSalvar.setBounds(80, 220, 117, 30);
        tela.add(btnSalvar);

        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(240, 220, 117, 30);
        tela.add(btnCancelar);

        // ----------------------------------------------------------
        // acao no botao SALVAR
        // ----------------------------------------------------------
        btnSalvar.addActionListener((ActionEvent e) -> {

            String novoUsuario  = txtNovoUsuario.getText().trim();
            String senhaAtual   = passSenhaAtual.getText();
            String novaSenha    = passNovaSenha.getText();
            String confNovaSenha = passConfNovaSenha.getText();

            // pelo menos um campo deve ser preenchido
            if ("".equals(novoUsuario) && "".equals(novaSenha)) {

                JOptionPane.showMessageDialog(null,
                        "Preencha ao menos um campo para alterar\n"
                        + "(Novo Usuário ou Nova Senha)!");
                return;
            }

            // senha atual sempre obrigatorio para confirmar identidade
            if ("".equals(senhaAtual)) {

                JOptionPane.showMessageDialog(null,
                        "Informe sua senha atual para confirmar a alteração!");
                passSenhaAtual.grabFocus();
                return;
            }

            // se foi digitada nova senha, confirmar que batem
            if (!"".equals(novaSenha) && !novaSenha.equals(confNovaSenha)) {

                JOptionPane.showMessageDialog(null,
                        "A nova senha e a confirmação não coincidem!");
                passNovaSenha.grabFocus();
                return;
            }

            // chama o metodo de alteração na classe Usuario
            Usuario usu = new Usuario();
            boolean alterado = usu.alteraDados(
                    usuarioLogado,
                    senhaAtual,
                    novoUsuario,
                    novaSenha);

            if (alterado == true) {

                JOptionPane.showMessageDialog(null,
                        "Dados alterados com sucesso!\n"
                        + "Você será redirecionado ao login.");

                dispose(); // fecha tela de alteração

                // fecha a tela pai (TelaBemVindo) e volta ao login
                for (java.awt.Window w : java.awt.Window.getWindows()) {
                    w.dispose();
                }

                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(null,
                        "Não foi possível alterar os dados!\n"
                        + "Verifique se a senha atual está correta\n"
                        + "ou se o novo usuário já está em uso.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // acao no botao CANCELAR -- fecha apenas esta tela
        btnCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }
}
