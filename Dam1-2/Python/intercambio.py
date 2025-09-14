lista = ["uno", "dos", "tres", "cuatro"]

print(*lista)

def bubbleSort(lista):
    for i in range(0, len(lista)-1):
        for j in range(0, len(lista)-1-i):
            if lista[i] > lista[i+1]:
                a, b = lista.index("uno"), lista.index("dos")
                lista[b], lista[a] = lista[a], lista[b]

bubbleSort(lista)
print(*lista)