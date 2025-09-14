lista1, lista2, lista3 = [], [], []

for i in range (5):
    num1 = int(input("Introduce un número para la lista1: "))
    lista1.append(num1)
    num2 = int(input("Introduce un número para la lista2: "))
    lista2.append(num2)

for j in lista1:
    lista3.append(j)
for l in lista2:
    lista3.append(l)

print(*lista3)