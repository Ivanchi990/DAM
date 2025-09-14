package practica10;

public class ColaDinamica 
{
	Nodo primero;
	Nodo ultimo;
	
	public ColaDinamica() 
	{
		primero= null;
		ultimo= null;
	}
	
	
	public boolean vacia() 
	{
		return primero == null;
	}
	
	
	public void meter(Object obj) 
	{
		Nodo nuevo = new Nodo(obj,null);
		if(vacia()) 
		{
			primero = nuevo;
		}
		else 
		{
			//Enlazamos el ultimo nodo con el nuevo
			ultimo.enlace = nuevo;	
		}
		ultimo = nuevo;
	}
	
	public Object sacar() 
	{
		if(vacia()) 
		{
			System.out.println("La cola esta vacia");
			return null;
		}
		else  
		{
			Object auxiliar = primero.info;
			primero = primero.enlace;
			return auxiliar;
		}
	}
}
