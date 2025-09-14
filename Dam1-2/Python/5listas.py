import random

matriz = []

#Lleno la lista de listas con números aleatorios de 0 a 10

for i in range(5):
    lista2 = []
    for j in range(5):
        num = random.randint(0, 10)
        lista2.append(num)
    matriz.append(lista2)
    
print(*matriz)

#Imprimpo la matriz

for i in range(5):
    print("\n")
    for j in range(5):
        print(matriz[i][j], end = " ")

#Imprimo la suma de las filas y las columnas de la matriz

sumaC = 0
sumaF = 0

print("\n")
for h in range(5):
    sumaC = 0
    for i in range(5):
        sumaC += matriz[i][h]
    print(f"\nLa suma de la columna {h+1}: ", sumaC)

for x in range(5):
    sumaF = 0
    for j in range(5):
        sumaF += matriz[x][j]   
    print(f"\nLa suma de la fila {x+1}: ", sumaF)