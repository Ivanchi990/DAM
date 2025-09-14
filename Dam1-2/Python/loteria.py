boleto = []

for i in range(0, 5):
    numero = input("Introduce un número: ")
    boleto.append(numero)

boleto.sort()
print(*boleto)