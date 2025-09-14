lado1 = int(input("Introduzca el valor del primer lado: "))
lado2 = int(input("Introduzca el valor del segundo lado: "))
lado3 = int(input("Introduzca el valor del tercer lado: "))
if(lado1 == 0 or lado2 == 0 or lado3 == 0):
    print("El valor no puede ser 0")
elif(((lado1 ** 2) == (lado2 ** 2 + lado3 ** 2)) or((lado2 ** 2) == (lado1 **2 + lado3 ** 2)) or ((lado3 ** 2) == (lado1 ** 2 + lado2 **2))):
    print("El triángulo es pitagórico (rectángulo).")
elif((lado1 == lado2 and lado3 != lado1)or(lado2 == lado3 and lado1 != lado2) or (lado1 == lado3 and lado2 != lado3)):
    print("El triángulo es isósceles.")
elif(lado1 == lado2 and lado2 == lado3):
    print("Tu triángulo es equilátero.")
else:
    print("Su triángulo es escaleno.")