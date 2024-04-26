<?php	

/*
*	Comprueba login
*	E:
*	S: booleano: conexión correcta
*	SQL: SELECT * FROM usuarios WHERE ...
*/
function loginValido()	
{
	return true;
}

/*
* 	Devuelve los chats activos
* 	E:
* 	S: array asociativo con los chats activos
* 	SQL: SELECT idChat, telefono FROM TIENE WHERE numero =  $_SESSION['user'];
*/
function dameChats() 
{
	return array();
}

/*
* 	Devuelve la información de un chat
* 	E:
* 	S: array asociativo con los mensajes de un chat
* 	SQL: SELECT mensaje FROM TIENE WHERE numero =  $_SESSION['user'];
*/
function dameChat() 
{
	return array();
}

/*
*	Guardar el mensaje en la BD
*	E:
*	S:boolean: operación correcta
*	SQL: INSERT INTO Mensaje values (?);	SELECT idMensaje, texto, fecha, hora, fichero, telefono from Mensajes;
*/
function guardarMensaje()
{
	return true;
}

/*
*	Modifica el perfil
*	E: Cambios en el perfil
*	S:
*	SQL: UPDATE INTO usuario ...
*/
function perfilModificado() 
{
	return true;
}

/*
*	Comprueba el máximo número de caracteres del texto del estado del 
* 	usuario (está en el fichero de configuración)
*	E:
*	S: booleano: número correcto
*	SQL: 
*/
function maximoCaracteresEstado() 
{
	return true;
}

/*
*	Guarda el color seleccionado en el fichero de configuración
*	E:
*	S: 
*	SQL: update INTO usuario set color = ?;
*/
function guardarColor() 
{
	return true;
}

/*
*	Función que comprueba si el número esta registrado en la base de datos
*	E:
*	S: booleano: comprobado 
*	SQL: SELECT telefono FROM usuarios WHERE telefono != ?;
*/
function telefonoRegistrado() 
{
	return true;
}

/*
*	Función que añade el nuevo chat a la base de datos
*	E:
*	S: booleano: añadido 
*	SQL: INSERT INTO tiene values(?...);
*/
function añadirChat() 
{
	return true;
}

/*
*	Función que elimina el chat
*	E:
*	S: booleano: comprueba eliminación
*	SQL: DELETE FROM escribe WHERE ...
*/
function eliminarChat() 
{
	return true;
}

/*
*	Función que elimina todos los chats de un usuario 
*	E:
*	S: booleano: eliminado correctamente
*	SQL: DELETE FROM tiene;
*/
function eliminarChats() 
{
	return true;
}
?>