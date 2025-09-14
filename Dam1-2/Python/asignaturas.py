asignaturas = []
notas = []

for i in range(0, 5):
    asignatura = input("Introduce una asignatura: ")
    asignaturas.append(asignatura)
    nota = input("Introduce la nota en dicha asignatura: ")
    notas.append(nota)

for i in range (len(asignaturas)):
    print("Yo estudio", asignaturas[i], "y he sacado un ", notas[i])