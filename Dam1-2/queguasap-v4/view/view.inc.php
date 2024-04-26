<?php

/*
*	Muestra el encabezado
*	E:
*	S:
*	SQL:
*/
function showHeader()
{
	echo 
	'<!DOCTYPE html>
	<html>
		<head>
			<title>KGuasAp</title>
			<link rel="icon" href="view/images/bd.jpg">
			<link rel="stylesheet" type="text/css" href="view/css/estilo.css">
			<meta charset= "utf-8">
			<link rel="shortcut icon" href="maquinalinkedin.jpeg" />
		</head>
	<body>
		<div id="principal">';
}

/*
*	Muestra el menú
*	E:
*	S:
*	SQL: select logo, texto from usuario where usuario = ?;
*/
function showMenu() 
{
	if (isset($_SESSION['user'])) 
	{
		echo 
		'<header>
			<section id="estado">
				<img src="view/images/f.jpg" class="imgRedonda"/><br>
				<p>Estoy trabajando</p>
			</section>
			<nav class="menu">
				<ul>
					<li><a href="index.php?cmd=chats" class="btn">CHAT</a></li>
					<li><a href="index.php?cmd=perfil" class="btn">Perfil</a></li>
					<li><a href="index.php?cmd=ajustes" class="btn"><img src="view/images/ajustes.png" width=30 height=30 /></a></li>';
		
		// es admin?
		if ($_SESSION['admin'])
		{
			echo 
			'<li><a href="index.php?cmd=admin" class="btn">Admin</a></li>';
		}
		echo 
		'<li><a href="index.php?cmd=logout" class="btn">Logout</a></li>
		</ul>
		</nav>
		</header>';
	}
	else
	{


		echo 
		'<header>
			<br>
			<h1>KGuasAp</h1>
		</header>';
	}
}

/*
*	Muestra el formulario de contacto
*	E:
*	S:
*	SQL:
*/
function showLoging() 
{
	echo '
	<section class="slider">
		<form action="index.php" method="post" role="form">
				<h2>Iniciar sesión</h2>
				<input id="numero" type="text" name="numero" placeholder="Número de teléfono" required="" ><br><br>
				<input id="pass" type="password" name="pass_user" placeholder="Contraseña" required="" ><br><br>
				<button type="submit" name="login">Acceder</button><br><br>
				<p id="passReco"><a href="index.php?cmd=recover">Recuperar contraseña</a></p>
		</form>
	</section>';
}

/*
* Muestra los chats una vez eliminados
* E:
* S:
* SQL: 
*/
function showNothing() 
{
	echo 
	'<section id="chats">
		<br><br>
		<button style="font-size:23px"><a href="index.php?cmd=añadir">Añadir Chat</a></button>
		<button style="font-size:23px"><a href="index.php?cmd=borrar">Borrar Chats</a></button>
	</section>';
}

/*
* Muestra los diferentes tipos de chat
* E:
* S:
* SQL: 
*/
function showChats($chats) 
{
	echo '
		<section id="chats">
		<h3><a href="index.php?cmd=chat" class="btn">Fulanito
		<img src="view/images/verde.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<h3><a href="index.php?cmd=chat" class="btn">Menganito
		<img src="view/images/rojo.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<h3><a href="index.php?cmd=chat" class="btn">Mariano
		<img src="view/images/rojo.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<h3><a href="index.php?cmd=chat" class="btn">Sefora
		<img src="view/images/verde.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<h3><a href="index.php?cmd=chat" class="btn">Romero
		<img src="view/images/verde.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<h3><a href="index.php?cmd=chat" class="btn">Goku
		<img src="view/images/verde.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<h3><a href="index.php?cmd=chat" class="btn">Vegeta
		<img src="view/images/rojo.png" width=10 height=10 /></a></h3><br>
		<div></div><br><br>
		<button style="font-size:23px"><a href="index.php?cmd=añadir">Añadir Chat</a></button>
		<button style="font-size:23px"><a href="index.php?cmd=borrar">Borrar Chats</a></button>
		</section>';
}

/*
*	Muestra un mensaje de tipo alert
*	E: $msg (mensaje que se quiere mostrar en alert)
*	S: la alerta con el mensaje
*	SQL:
*/
function showMsg($msg)
{
	echo 
	"<script type='text/javascript'>alert('".$msg."');</script>";
}

/*
* Muestra el chat del contacto con los mensajes y el estado del contacto
* E: El array de chats ($chat)
* S:
* SQL: select idMensaje, texto, fecha, hora, fichero, idChat, telefono from mensajes where idChat = ?;
*/
function showChat($chat) 
{
	echo 
	'<section id="datosP">
		<section class="datosU">
			<img src="maquinalinkedin.jpeg" class="imgRedonda"/>
			<h3>Fulanito: Trabajando</h3>
			<br><br><br>
			<section class="mensajeU">
				<h4>Fulanito  19/05/20119  10:35</h4>
				<p>En casa</p>
				<div><div>
			</section>
			<section class="mensajeU">
				<h4>Fulanito  19/05/20119  10:30</h4>
				<p>Mira a coco</p>
				<img src="maquinalinkedin.jpeg" width=100 height=100/>
				<div><div>
			</section>
			<section class="mensajeU">
				<h4>Menganito  19/05/20119  10:28</h4>
				<p>Voy a salir</p>
				<div><div>
			</section>
			<section class="mensajeU">
				<h4>Menganito  19/05/20119  10:20</h4>
				<p>Estoy esperando a mi madre</p>
				<div><div>
			</section>
			<br><br>
			</section>
			<section class="contestar_mensaje">
			<form id="vb" action="index.php" method="post" role="form">
				<textarea id="ta" placeholder="Mensaje" rows="5" cols="40" required="" ></textarea>
				<br><br>
				<span>
					Elegir archivo<input type="file" name="b1" multiple>
				</span>
				<button type="submit" name="contestar" >Contestar</button><br><br>
			</form>
			<form id="vb" action="index.php" method="post" role="form">
				<h5>Realiza una copia de seguridad de este chat y asígnale un nombre al fichero</h5>
				<input id="nombre" type="text" name="nombre" placeholder="Nombre del fichero" required="">
				<br><br>
				<button type="submit" name="backup" >Copia de seguridad</button>
				<br><br>
			</form>
				<button style="align-items="center"""><a href="index.php?cmd=eliminar">Borrar Chat</a></button>
			</section>
		</section>';
}

/*
*	Muestra la página modificar el perfil
*	E:
*	S:
*	SQL:
*/
function showPerfil() 
{
	echo 
	'<section id="perfil">
		<form id="vb" action="index.php" method="post" role="form">
			<input id="nombre" type="text" name="nombre" placeholder="Escoge un alias de usuario" required="" >
			<br><br>	
			<span>Cambiar imagen de perfil<input type="file" name="b1" multiple></span>
			<br><br>
			<textarea id="ta" rows="5" cols="40" required="" >Estoy trabajando</textarea>
			<br><br>
			<button type="submit" name="editar" >Modificar</button>
		</form>
	</section>';
}

/*
* Muestra los ajustes para cambiar el color del fondo de la página web
* E:
* S
* SQL:
*/
function showAjustes() 
{
	echo 
	'<section id="ajustes">
		<form id="vb" action="" method="POST" role="form">
			<h4>Selecciona un color de fondo
			<select name="order" >
				<option value="rojo">Rojo</option>
				<option value="verde">Verde</option>
				<option value="azul">Azul</option>
				<option value="blanco">Blanco</option>
				<option value="rosa">Rosa</option>
			</select></h4>
			<button type="submit" name="guardar_color" >Guardar</button>
		</form>
	</section>';
}

/*
*	Muestra el footer
*	E:
*	S:
*	SQL:
*/
function showAñadirChat()
{
	echo '
	<section class="slider">
		<form action="index.php" method="post" role="form">
				<h2>Añadir contacto</h2>
				<input id="nombre" type="text" name="nombre" placeholder="Nombre del contacto" required="" >
				<br><br>
				<input id="tlf" type="text" name="tlf" placeholder="Número del contacto" required="" >
				<br><br>
				<br>
				<button type="submit" name="añadirChat" >Guardar</button>
		</form>
	</section>';
}

/*
* Muestra la página del administrador
* E:
* S:
* SQL: 
*/
function showAdmin()
{
	echo 
	'<section id="chats">
		<h3>Añadir color</h3>
		<br><br>
		<button style="font-size:23px"><a href="index.php?cmd=crearColor">Añadir color</a></button>
		<br>
		<div></div><br><br>
		<h3>Eliminar color</h3>
		<br><br>
		<button style="font-size:23px"><a href="index.php?cmd=quitarColor">Eliminar color</a></button>
		<br>
		<div></div>
		<br><br>
	</section>';
}

/*
*	Muestra el footer
*	E:
*	S:
*	SQL:
*/
function showFooter()
{
	echo 
	'<footer>
		<p>
			(c) Todos los derechos reservados - IFP 2022 <br>
			Diseñado por Ivan Fdez
		</p>
	</footer>
	</div>
	</body>
	</html>';
}
?>