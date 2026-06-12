<?php 
session_start();
require 'usuarios.php';

$erro = '';

if ($_SERVER['REQUEST_METHOD'] ==='POST') {
    $usuario = $_POST ['usuario'] ?? '';
    $senha = $_POST['senha'] ?? '';

    if (isset($usuarios[$usuario]) && password_verify ($senha, $usuarios[$usuario])){
        $_SESSION['usuario'] = $usuario;
        header ('Location: home.php');
        exit;
    } else {
        $erro = 'Usuário ou senha invalidos!';
    }
}
?>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login com Hash e Tabaco</title>
    </head>
    <body>
    <h2>Login</h2>
    <?php if ($erro): ?>
        <p style="color:red;"><?= $erro ?></p> 
    <?php endif; ?>
        <form method="post" action="">
            <label>Usuário</label><br>
            <input type="text" name="usuario" required> <br><br> 
              <label>Senha</label><br>
            <input type="password" name="senha" required> <br><br> 

            <button type="submit"> Entrar </button>
        </form>
    </body>
</html>