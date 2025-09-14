num = int(input("inserta un numero: "))
numero = int(num)
contador = 0
for i in range(1, numero + 1):
    if (numero % i)==0:
        contador = contador + 1

if contador == 2:
    print ("El número es primo")
else:
    print ("El número no es primo")