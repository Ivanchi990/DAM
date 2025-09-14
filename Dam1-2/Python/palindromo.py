cadena = input("Introduce una cadena: ")
print("La cadena ", cadena, " es un plindromo: "  esPalindromo(cadena, ))

def filtrar(cadena):
    caracterEliminar = ":,.!"
    for caracter in caracterEliminar:
        cadena = cadena.replace(caracter, "")
    cadena = cadena.lower()
    return cadena

def invertir(cadena):
    cadenaNueva = ""
    for caracter in cadena:
        cadenaNueva = caracter + cadenaNueva
    return cadenaNueva
        

def esPalindromo(cadena):
    cadena = filter(cadena)
    return cadena == invertir(cadena)