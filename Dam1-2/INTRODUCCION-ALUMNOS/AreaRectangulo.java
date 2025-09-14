package estructurasdecontrol;


import java.util.Scanner;

/* programa que calcule el area y el perimetro del rectangulo*/

public class AreaRectangulo {

	public static  void main(String[] args)
	{
		//creamos un objeto de tipo Scanner
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Introduce la base: ");
		double base = entrada.nextDouble();
		
		System.out.println("Introduce la altura: ");
		double altura = entrada.nextDouble();
		
		//calculamos el area del rectangulo
		
		double area = base * altura;
		
		System.out.println("El area del rectangulo es: " + area );
		
		//calculamos el perimetro 
		
		double perimetro = 2 * (base + altura);
		
		System.out.println("El perimetro del rectangulo es: " + perimetro);

	}

}
