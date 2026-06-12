<?php 
session_start ();

if (!isset($_SESSION['usuario'])){
    header ('Location: login.php');
    exit;
}
?>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Restrita</title>
</head>
<body>
    <h2>Bem-Vindo Usuário, <?=  $_SESSION['usuario'] ?>! </h2>
    <p>Você esta na area protegida do sistema</p>
    <a href="logout.php"> Sair </a>
</body>
</html>