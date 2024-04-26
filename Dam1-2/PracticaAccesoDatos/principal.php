<?php include("session.php")?>
<!DOCTYPE html>   
<html>   
<head>  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <title> Principal Page </title>  
  <style>   
    body 
    {  
      font-family: Calibri, Helvetica, sans-serif;  
      background-color: pink;  
    }  

    button 
    {   
      background-color: #4CAF50;   
      width: 100%;  
      color: orange;   
      padding: 15px;   
      margin: 10px 0px;   
      border: none;   
      cursor: pointer;   
    }   

    form 
    {   
      border: 3px solid #f1f1f1;   
    }   

    input[type=text], input[type=password] 
    {   
      width: 100%;   
      margin: 8px 0;  
      padding: 12px 20px;   
      display: inline-block;   
      border: 2px solid green;   
      box-sizing: border-box;   
    }  

    button:hover 
    {   
      opacity: 0.7;   
    } 

    .cancelbtn 
    {   
      width: auto;   
      padding: 10px 18px;  
      margin: 10px 5px;  
    }   

    .container 
    {   
      padding: 25px;   
      background-color: lightblue;  
    }   
  </style>   
</head>    
<body>
  <?php
    $conexion = mysqli_connect("localhost", "admin", "", "base1") or
      die("Problemas con la conexión");

    $registros = mysqli_query($conexion, "select codigo,nombre,codigocurso
                          from alumnos where mail='$_REQUEST[mail]'") or
      die("Problemas en el select:" . mysqli_error($conexion));

    if ($reg = mysqli_fetch_array($registros)) 
    {
      echo "Nombre:" . $reg['nombre'] . "<br>";
      echo "Curso:";

      switch ($reg['codigocurso'])
      {
        case 1:
          echo "PHP";
          break;
        
        case 2:
          echo "ASP";
          break;
        
        case 3:
          echo "JSP";
          break;
      }
    } 
    else 
    {
      echo "No existe un alumno con ese mail.";
    }
    mysqli_close($conexion);
    ?>
    <h1> Pagina Principal </h1>
</body>     
</html>  