<?php

function establecerConexion()
{
    $servername = "localhost";
    $username = "root";
    $password = "root";

    $conexion = new mysqli($servername, $username, $password);

    if ($conexion->connect_error) 
    {
        die("Connection failed: " . $conexion->connect_error);
    }

    return $conexion;
}

function loginValido()
{
    $conexion = establecerConexion();

    $query = 'SELECT * FROM USUARIOS WHERE user = $_SESSION["user"] and pass = $_SESSION["pass"]';

    $result = $conexion->query($query);

    if($result->num_rows == 1)
    {
        return true;
    }

    return false;
}
?>