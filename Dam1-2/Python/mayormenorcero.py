cantidad = int(input("Introduce cuantos números va a introducir: "))
mayor = 0
menor = 0
igual = 0
for i in range(1, cantidad + 1):
    num = int(input("Introduzca un número: "))
    if(num > 0):
        mayor = mayor + 1
    elif(num < 0):
        menor = menor + 1
    else:
        igual = igual + 1
print("Has introducido ", mayor, " números mayores que cero, ", menor, " números menores de cero y ", igual, " números iguales a cero.")