<?php

/*
*	Muestra el contenido de la parte central de la página
*	E:
*	S:
*	SQL:
*/
function showContent() 
{
	if ($_SERVER['REQUEST_METHOD'] == 'GET') 
	{	// GET
		if (!isset($_GET['cmd']))
		{
			// carga inicial de la página
			showLoging();
		}
		else 
		{
			switch ($_GET['cmd']) 
			{
				// vemos qué llegó por el GET
				case 'chats':
					// pedimos los chats a la BD
					$chats =  dameChats();
					// los mostramos
					showChats($chats);
					break;

				case 'chat':
					// pedimos el chat a la BD
					$chat =  damEChat();
					// lo mostramos
					showChat($chat);									
					break;

				case 'perfil':
					// mostramos el perfil
					showPerfil();
					break;

				case 'ajustes':
					// mostramos los ajustes
					showAjustes();
					break;

				case 'logout':
					// mostramos el logout
					showLoging();
					break;	

				case 'admin':
					// mostramos el panel del admin
					showAdmin();
					break;
				
				case 'recover':
					//mostramos el apartado de recuperación de la contraseña
					recuperarContraseña();
					showMsg("SMS enviado");
					showLoging();
					break;
				
				case 'eliminar':
					// eliminamos el chat actual
					if(eliminarChat())
					{
						showMsg("Chat borrado");
						$chats =  dameChats();				
						showChats($chats);
					}
					else
					{
						showMsg("Vaya, parece que no se ha podido eliminar el chat");
					}
					break;
				
				case 'añadir':
					// añadimos un nuevo chat
					showAñadirChat();
					break;
				
				case 'borrar':
					if(eliminarChats())
					{
						showMsg("Chats borados correctamente");
						showNothing();
					}
					else
					{
						showMsg("Chats borados no correctamente");
						$chats =  dameChats();				
						showChats($chats);
					}
					break;

				case 'crearColor':
					if(crearColor())
					{
						showMsg("El color se ha añadido correctamente");
					}
					else
					{
						showMsg("Vaya, parece que el color no se ha podido añadir");
					}
					break;

				case 'quitarColor':
					if(quitarColor())
					{
						showMsg("El color se ha eliminado correctamente");
					}
					else
					{
						showMsg("Vaya, parece que el color no se ha podido eliminar");
					}
					break;

				default:
					showMsg("Error, operación no permitida");
					break;
			}
		}
	}
	else 
	{	
		// POST
		if (isset($_POST['login'])) 
		{
			if (isset($_SESSION['user'])) 
			{								
				// login ok (comprobado en actualizar_sesion)
				$chats =  dameChats();				
				showChats($chats);
			}
			else 
			{
				showLoging();
			}
		}
		elseif (isset($_POST['contestar'])) 
		{
			// comprobamos si la imagen introducida es válida
			if (tamanoImg()) 
			{
				if (guardarMensaje()) 
				{
					showMsg("Mensaje enviado");
					$chats =  dameChats();				
					showChats($chats);
				}
				else 
				{
					showMsg("Error no enviado");
				}
			}
			else 
			{
				showMsg("Error, imagen demasiado grande");
			}
		}
		elseif (isset($_POST['añadirChat'])) 
		{
			if(telefonoRegistrado())
			{
				showMsg("El chat no se ha podido crear");
			}
			else
			{
				if(añadirChat())
				{
					showMsg("Chat creado correctamente");
					$chats =  dameChats();				
					showChats($chats);
				}
				else
				{
					showMsg("EL chat no ha podido añadirse");
				}
			}
		}
		elseif (isset($_POST['editar'])) 
		{
			// comprobamos si el estado nuevo es válido
			if (maximoCaracteresEstado()) 
			{	
				if (perfilModificado()) 
				{
					showMsg("Perfil modificado");
					$chats =  dameChats();				
					showChats($chats);
				}
				else 
				{
					showMsg("Error al modificar el perfil");
				}

			}
			else 
			{
				showMsg("Error máximo de caracteres");
			}	
		}
		elseif (isset($_POST['guardar_color'])) 
		{
			// se gestiona el cambio de color
			if (guardarColor()) 
			{
				showMsg("Color cambiado");
				$chats =  dameChats();				
				showChats($chats);
			}
			else 
			{
				showMsg("Error no se cambio de color");
			}
		}
		elseif (isset($_POST['backup'])) 
		{
			// se crea una copia de seguridad
			if (backupChat()) 
			{
				showMsg("backup guardado");
				$chats =  dameChats();				
				showChats($chats);
			}
			else 
			{
				showMsg("Error no realizar el backup");
			}
		}
	}
}

/*
* Realiza algunas acciones relacionadas con la sesión
* S: 
* SQL:
*/
function actualizar_sesion() 
{
	// POST login
	if ($_SERVER['REQUEST_METHOD'] == 'POST') 
	{
		if (isset($_POST['login'])) 
		{
			if (loginValido()) 
			{
				//$_SESSION['user'] = $_POST['numero'];					
				// Creamos la sesión
				/* Esta línea a continuación se usa si tuvieramos una administración 
				* en la aplicación (teléfono 611111111)
				* El resto de funciones (por ejemplo show_menu) miran
				* este valor para saber si tienen que mostrar más o menos opciones
				*/
				//$_SESSION['admin'] = ($_POST['numero'] == '611111111');
			}
		}
	} 
	else
	{
		// GET logout
		if (isset($_GET['cmd'])) 
		{
			if  ($_GET['cmd'] == 'logout') 
			{
				unset($_SESSION);
				session_destroy();
			}
		}
	}
}

/*
*	Función recupera la contraseña enviando un sms al usuario
*	E:
*	S: 
*	SQL:
*/
function recuperarContraseña() 
{

}

/*
*	Comprueba el tamaño de la imagen seleccionada, el tamaño de la 
* 	imagen estara en el fichero de configuración
*	E:
*	S: booleano: tamaño correcto
*	SQL: 
*/
function tamanoImg() 
{
	return true;
}

/*
*	Función que guarda el chat en un fichero 
*	E:
*	S: booleano: guardado correctamente
*	SQL:
*/
function backupChat() 
{
	return true;
}

/*
*	Función que crea un nuevo color de fondo
*	E:
*	S: booleano: creado correctamente
*	SQL:
*/
function crearColor() 
{
	return true;
}

/*
*	Función que elimina un color de fondo
*	E:
*	S: booleano: eliminado correctamente
*	SQL:
*/
function quitarColor() 
{
	return true;
}
?>