numeros = []

for i in range(10):
    numero = input("Introduce un número: ")
    numeros.append(numero)

numeros.reverse()

for j in numeros:
    print(j, end=", ")