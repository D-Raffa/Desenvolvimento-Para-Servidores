/*
 * Tela de Boas-Vindas do Sistema de Restaurante
 * Atualizada: adicionado botão ALTERAR DADOS
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
import javax.swing.SwingConstants;

public class TelaBemVindo extends JFrame {

    // tela objeto JPanel (tela em si)
    private final JPanel panelTela;

    // usuario logado no momento
    private final String usuarioLogado;

    // Metodo construtor -- recebe o nome do usuario logado
    public TelaBemVindo(String usuarioLogado) {

        this.usuarioLogado = usuarioLogado;

        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Restaurante da Fatec -- Área do Usuário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 220, 436, 340);

        panelTela = new JPanel();
        panelTela.setBackground(SystemColor.white);
        setContentPane(panelTela);
        panelTela.setLayout(null);

        // ----------------------------------------------------------
        // adicionando elementos na tela
        // ----------------------------------------------------------

        // label titulo
        JLabel lblTitulo = new JLabel("RESTAURANTE DA FATEC");
        lblTitulo.setBounds(0, 5, 426, 35);
        lblTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTela.add(lblTitulo);

        // separador visual
        JLabel lblLinha = new JLabel("─────────────────────────────────");
        lblLinha.setBounds(0, 38, 426, 20);
        lblLinha.setFont(new Font("Calibri", Font.PLAIN, 13));
        lblLinha.setHorizontalAlignment(SwingConstants.CENTER);
        panelTela.add(lblLinha);

        // icone de boas-vindas
        JLabel lblIcone = new JLabel("🍽");
        lblIcone.setBounds(0, 60, 426, 50);
        lblIcone.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
        lblIcone.setHorizontalAlignment(SwingConstants.CENTER);
        panelTela.add(lblIcone);

        // mensagem de boas-vindas
        JLabel lblBemVindo = new JLabel("BEM-VINDO!");
        lblBemVindo.setBounds(0, 115, 426, 30);
        lblBemVindo.setFont(new Font("Calibri", Font.BOLD, 22));
        lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTela.add(lblBemVindo);

        // nome do usuario logado
        JLabel lblUsuario = new JLabel(usuarioLogado.toUpperCase());
        lblUsuario.setBounds(0, 145, 426, 25);
        lblUsuario.setFont(new Font("Calibri", Font.ITALIC, 18));
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        panelTela.add(lblUsuario);

        // label de instrucao
        JLabel lblInfo = new JLabel("O que deseja fazer?");
        lblInfo.setBounds(0, 178, 426, 18);
        lblInfo.setFont(new Font("Calibri", Font.PLAIN, 13));
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        panelTela.add(lblInfo);

        // ----------------------------------------------------------
        // botoes -- linha 1: SAIR e ALTERAR DADOS
        // ----------------------------------------------------------
        JButton btnSair = new JButton("SAIR");
        btnSair.setBounds(60, 210, 117, 30);
        panelTela.add(btnSair);

        JButton btnAlterarDados = new JButton("ALTERAR DADOS");
        btnAlterarDados.setBounds(250, 210, 130, 30);
        btnAlterarDados.setBackground(new Color(50, 100, 180));
        btnAlterarDados.setForeground(Color.WHITE);
        btnAlterarDados.setFont(new Font("Calibri", Font.BOLD, 12));
        panelTela.add(btnAlterarDados);

        // ----------------------------------------------------------
        // botoes -- linha 2: EXCLUIR CONTA (centralizado)
        // ----------------------------------------------------------
        JButton btnExcluir = new JButton("EXCLUIR CONTA");
        btnExcluir.setBounds(148, 255, 130, 30);
        btnExcluir.setBackground(new Color(180, 50, 50));
        btnExcluir.setForeground(Color.WHITE);
        btnExcluir.setFont(new Font("Calibri", Font.BOLD, 12));
        panelTela.add(btnExcluir);

        // ----------------------------------------------------------
        // acao no botao SAIR -- fecha e volta ao login
        // ----------------------------------------------------------
        btnSair.addActionListener((ActionEvent e) -> {

            int opcao = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente sair?",
                    "Confirmar Saída",
                    JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                dispose();
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            }
        });

        // ----------------------------------------------------------
        // acao no botao ALTERAR DADOS -- abre TelaAlterarDados
        // ----------------------------------------------------------
        btnAlterarDados.addActionListener((ActionEvent e) -> {

            TelaAlterarDados telaAlt = new TelaAlterarDados(usuarioLogado);
            telaAlt.setVisible(true);

        });

        // ----------------------------------------------------------
        // acao no botao EXCLUIR CONTA
        // ----------------------------------------------------------
        btnExcluir.addActionListener((ActionEvent e) -> {

            int opcao = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja EXCLUIR sua conta?\n"
                    + "Esta ação não poderá ser desfeita!",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (opcao == JOptionPane.YES_OPTION) {

                Usuario usu = new Usuario();
                boolean excluido = usu.deletaUsuario(usuarioLogado);

                if (excluido == true) {

                    JOptionPane.showMessageDialog(null,
                            "Conta excluída com sucesso!",
                            "Informação",
                            JOptionPane.INFORMATION_MESSAGE);

                    dispose();
                    TelaLogin telaLogin = new TelaLogin();
                    telaLogin.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Não foi possível excluir a conta!\n"
                            + "Verifique a conexão com o banco de dados.",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
