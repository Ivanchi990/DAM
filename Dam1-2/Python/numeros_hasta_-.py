numeros = []

num = 0
while num >= 0:
    num = int(input("Introduce un número: \n"))
    if num >= 0:
        numeros.append(num)

print(*numeros)