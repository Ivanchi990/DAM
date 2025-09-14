package practica10;

public class Nodo 
{
	Object info;
	Nodo enlace;
	
	public Nodo(Object info, Nodo enlace)
	{
		this.enlace = enlace;
		this.info = info;
	}
}
