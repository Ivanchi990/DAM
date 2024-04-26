<?php
include("utilidades.php"); 

    function procesarLogin($connection, $username, $password)
    {
        $query = $connection -> query ("SELECT * FROM usuarios WHERE Nombre = $username and Password = $password");

        $result = mysqli_fetch_array($query);

        if($result != 0)
        {
            return true;
        }
        else
        {
            enviarMensaje("Vaya, parece que los datos no son correctos");
            
            return false;
        }
    }
?>