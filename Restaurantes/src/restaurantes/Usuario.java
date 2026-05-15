/*
 * Classe Usuario -- gerencia autenticacao e cadastro no banco de dados
 * Metodos: verificaUsuario, cadastraUsuario, deletaUsuario, alteraDados
 */
package restaurantes;

import java.sql.SQLException;

public class Usuario {

    // criação dos atributos privados da classe
    private String usuario;
    private String nome;
    private String senha;

    // atributos que armazenarão o retorno do banco
    private boolean resultUsuario;
    private boolean resultCadastro;
    private boolean resultDeleta;
    private boolean resultAltera;

    // criação dos getters e setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // ----------------------------------------------------------
    // metodo de verificação da autenticidade do usuario
    // ----------------------------------------------------------
    public boolean verificaUsuario(String Usuario, String Senha) {

        Conexao banco = new Conexao();

        try {

            banco.abrirConexao();
            banco.stmt = banco.con.createStatement();

            // alias "u" evita conflito entre nome da tabela e da coluna
            banco.resulset =
                    banco.stmt.executeQuery("SELECT * FROM usuario u"
                            + " WHERE u.usuario = '" + usuario + "'"
                            + " AND u.senha = md5('" + senha + "')");

            if (banco.resulset.next()) {
                resultUsuario = true;
            } else {
                resultUsuario = false;
            }

            banco.fecharConexao();

        } catch (SQLException ec) {
            System.out.println(" ERRO AO CONSULTAR USUÁRIO " + ec.getMessage());
        }

        return resultUsuario;
    }

    // ----------------------------------------------------------
    // metodo de cadastro do usuario
    // ----------------------------------------------------------
    public boolean cadastraUsuario(String nome,
                                   String usuario,
                                   String senha) {

        Conexao banco = new Conexao();

        try {

            banco.abrirConexao();
            banco.stmt = banco.con.createStatement();

            String sql =
                    "INSERT INTO usuario(nome, usuario, senha) "
                    + "VALUES ('" + nome + "', "
                    + "'" + usuario + "', "
                    + "md5('" + senha + "'))";

            banco.stmt.executeUpdate(sql);

            resultCadastro = true;

            banco.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar usuario " + ex.getMessage());
            resultCadastro = false;
        }

        return resultCadastro;
    }

    // ----------------------------------------------------------
    // metodo de exclusão do usuario
    // ----------------------------------------------------------
    public boolean deletaUsuario(String usuario) {

        Conexao banco = new Conexao();

        try {

            banco.abrirConexao();
            banco.stmt = banco.con.createStatement();

            String sql = "DELETE FROM usuario"
                       + " WHERE usuario.usuario = '" + usuario + "'";

            banco.stmt.executeUpdate(sql);

            resultDeleta = true;

            banco.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuario " + ex.getMessage());
            resultDeleta = false;
        }

        return resultDeleta;
    }

    // ----------------------------------------------------------
    // metodo de alteração de dados do usuario
    // Recebe: usuario atual, senha atual (para autenticar),
    //         novo usuario (pode ser vazio para não alterar),
    //         nova senha   (pode ser vazia para não alterar)
    // ----------------------------------------------------------
    public boolean alteraDados(String usuarioAtual,
                               String senhaAtual,
                               String novoUsuario,
                               String novaSenha) {

        Conexao banco = new Conexao();

        try {

            banco.abrirConexao();
            banco.stmt = banco.con.createStatement();

            // primeiro confirma se a senha atual está correta
            banco.resulset =
                    banco.stmt.executeQuery("SELECT * FROM usuario u"
                            + " WHERE u.usuario = '" + usuarioAtual + "'"
                            + " AND u.senha = md5('" + senhaAtual + "')");

            if (!banco.resulset.next()) {
                // senha atual incorreta -- não permite alterar
                banco.fecharConexao();
                resultAltera = false;
                return resultAltera;
            }

            // monta a instrução UPDATE dinamicamente
            // somente atualiza os campos que foram preenchidos
            String setClause = "";

            if (!"".equals(novoUsuario)) {
                setClause += " usuario = '" + novoUsuario + "'";
            }

            if (!"".equals(novaSenha)) {
                if (!"".equals(setClause)) {
                    setClause += ","; // separa os campos se os dois foram informados
                }
                setClause += " senha = md5('" + novaSenha + "')";
            }

            String sql = "UPDATE usuario"
                       + " SET" + setClause
                       + " WHERE usuario.usuario = '" + usuarioAtual + "'";

            banco.stmt.executeUpdate(sql);

            resultAltera = true;

            banco.fecharConexao();

        } catch (SQLException ex) {
            System.out.println("Erro ao alterar dados do usuario " + ex.getMessage());
            resultAltera = false;
        }

        return resultAltera;
    }
}
