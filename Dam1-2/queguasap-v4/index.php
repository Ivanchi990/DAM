<?php
// directivas para activar
error_reporting(E_ALL); 
// la notificación de errores
ini_set('display_errors', '1');
// iniciar la sesión
session_start();

include_once 'model/model.inc.php';
include_once 'view/view.inc.php';
include_once 'controller/controller.inc.php';

// tareas relacionadas con la sesión
actualizar_sesion();
// mostrar las vistas
showHeader();
showMenu();
showContent();
showFooter();
?>