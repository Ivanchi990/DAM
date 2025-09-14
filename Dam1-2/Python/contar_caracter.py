cadena = input("Introduce una cadena:")
caracter = input("Introduce un caracter:")

while len(caracter) != 1 or not caracter.isalpha():
    print("Caracter no válido")
    caracter = input("Intentalo de nuevo: ")

print("El caracter", caracter, " se repite", cadena.count(caracter), "veces")