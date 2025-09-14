op = int(input("Indique el nombre del animal: \n[1]-Jirafa \n[2]-Elefante \n[3]-Monos"))
acum = 0
if op == 1:
    for i in range(5):
        edad = int(input("Introduce la edad de la jirafa: "))
        acum = acum + edad
    print("El promedio de las jirafas es de ", acum / 5)
elif op == 2:
    for j in range(7):
        edad = int(input("Introduce la edad del elefante: "))
        acum = acum + edad
    print("El promedio es de ", acum /7)
elif op == 3:
    for k in range(10):
        edad = int(input("Introduce la edad del mono: "))
        acum = acum + edad
    print("El promedio es de ", acum / 10)
else:
    print("Opción inválida")