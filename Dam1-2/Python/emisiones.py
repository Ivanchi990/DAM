emisiones = 0
acum = 0
div = 0
while emisiones >= 0:
    matricula = input("Introduce la matrícula de tu vehículo: ")
    emisiones = int(input("Introduce el nivel de emisión de tu vehículo: "))
    if emisiones > 0:
        acum = acum + emisiones
        div = div + 1
        print("Si desea finalizar introduce un número negativo.")
if acum > 0:
    print("El promedio de emisiones es de ", acum / div)
elif acum == 0:
    print("El promedio de emisiones es 0.")
else:
    print("Fin")

