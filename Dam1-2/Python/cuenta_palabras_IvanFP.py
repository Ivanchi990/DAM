def contarPalabras(cadena):
    return len(cadena.split())

cadena = str(input("Introduce una cadena: "))
print("La cadena tiene ", int(contarPalabras(cadena)), " palabras")

def contarDos(frase):
    contador = 0
    esEspacio = False
    for caracter in frase:
        if caracter != " " and esEspacio:
            contador = contador + 1
            esEspacio = False
    return contador

frase = input("Introduce una frase")
print("La frase tiene", contarDos(frase), "palabras")