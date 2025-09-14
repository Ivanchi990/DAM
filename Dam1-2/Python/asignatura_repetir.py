asignaturas = ["Mate", "Lengua", "Química", "Fisica", "Inglés", "Francés", "Educación física"]
notas = []

for i in range(len(asignaturas)):
    nota = int(input("Introduce la nota de la asigntura " + asignaturas[i] +": \n"))
    notas.append(nota)

cont = 0
for i in notas:
    if i < 5:
        print("La asignatura " + asignaturas[cont]+ " tienes que recuperar por tu calificación de ", i)
    cont = cont + 1