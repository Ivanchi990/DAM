<?php 
include("bd.php");

if($_SERVER['REQUEST_METHOD'] == 'POST')

    $conecction = establecerConexion();

    if($conecction != null)
    {
        if (isset($_POST['login']) && isset($_SESSION['user'])) 
        {
            
        }
        else
        {

        }
    }

if(isset($_GET['loginIncorrecto']) && $_GET['loginIncorrecto'] == true ) 
    echo "<p style='color:red'> Usuario o contraseñas incorrectas </p>";
else
    procesarLogin($conecction, $_GET['username'], $_GET['password']);

if(!isset($_SESSION["logueado"]) || $_SESSION["logueado"]=true )  
    header('location: http://localhost/index.php');
?>