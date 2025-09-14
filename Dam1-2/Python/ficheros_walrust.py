nombre_fichero = input("Introduce el nombre del fichero: \n")
fichero = open(nombre_fichero, 'w')

while (frase := input("Introduce lo que quieras, introduce fin para finalizar: \n")) != "fin":
    fichero.write(frase)

fichero.close()