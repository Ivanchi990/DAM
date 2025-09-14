package practica10;

public class Test {

	public static void main(String[] args) 
	{
		ColaDinamica cola = new ColaDinamica();
		rellenar(cola);
		vaciar(cola);
	}
	
	
	
	public static void rellenar(ColaDinamica cola) 
	{
		for(char letra ='a'; letra <= 'z';letra++) 
		{
			cola.meter(letra);
		}
	}
	
	
	
	public static void vaciar(ColaDinamica cola) 
	{
		while(!cola.vacia()) 
		{
			System.out.print(cola.sacar() + "");
		}
	}

}
