import random
numero = random.randint(0, 9999)
intentos = 1
num = int(input("Introduce un número entre 0 y 9999"))
while intentos <= 3:
    if num == numero:
        print("Acertaste el número.")
        intentos = 3
    else:
        if num > numero:
            print("Introducelo de nuevo, reduciendo la cifra.")
            num = int(input("Prueba de nuevo: "))
            intentos = intentos + 1 
        elif num < numero:
            print("Introducelo de nuevo, aumentando la cifra")
            num = int(input("Prueba de nuevo: "))
            intentos = intentos + 1 
if intentos > 3:
    print("El número era ", numero)
