cadena = str(input("Introduce una cadena: "))
cadena2 = str(input("Introduce una cadena: "))
caracter = str(input("Introduce un caracter: "))


while caracter.isalpha() == False or len(caracter) == 1:
    caracter = str(input("Introduce un caracter: "))

for i in cadena:
    print(i)

if cadena.startswith(cadena2) == True:
    print("La cadena", cadena, "comienza por ", cadena2)
else:
    print("La cadena", cadena, "no comienza por ", cadena2)

print("La cadena tiene ",cadena.count(caracter), " caracteres de ", caracter)