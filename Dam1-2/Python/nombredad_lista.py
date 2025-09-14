"""Queremos guardar los nombres y las edades de los alumnos de un curso,
haz un programa que solicite el nombre y la edad de cada alumno, la lectura 
finalizará con un asterisco.
Tras finalizar muestra los mayores de edad y los que la tienen mas alta"""

nombres = list()
edades = list()

nombre = ''
while nombre != '*':
    nombre = input("Introduce el nombre del alumno: \n")
    edad = int(input("Introduce la edad del alumno: \n"))