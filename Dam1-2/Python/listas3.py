notas = []

for i in range(0, 5):
    nota = int(input("Introduce una nota entre 0 y 10: "))
    while nota > 10 or nota < 0:
        nota = int(input("Nota no válida, intentalo de nuevo"))
    notas.append(nota)
media = 0
alta = 0
baja = 10

print("las notas son")
for i in notas:
    print(i)
    media = media + i
    if alta < i:
        alta = i
    if baja > i:
        baja = i
    
print("La media es: " ,media / 5)
print("La nota mas alta es: ", alta)
print("La nota mas baja es: ", baja)
