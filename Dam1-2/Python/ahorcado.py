import os
import time
import getpass
import random

def borrarPantalla():
    time.sleep(1)
    if os.name == "posix":
        os.system("clear")
    else:
        os.system("cls")

vidas = 6

def verMuñeco():
    if vidas == 6:
        print("\n --------------|", "\n |             0  ", "\n |            \|/", "\n |             |  ","\n---           / \ ")

print("           /--------------------------------\ ")
print("            Bienvenido al ahorcado de PYTHON")
print("           \--------------------------------/ ")
print("-En el modo solitario se te generará una palabra aleatoriamente.")
print("-En el modo multijugador tu eligirás una palabra y el otro jugador tratará de adivinarla.")
print("-Tines una serie vidas, cada una de ellas será representada con el símbolo $.")
print("-Aviso, si en algun momento de la partida intentas adivinar la palabra y no es correcta habrás perdido. \nBuena suerte :)")

verMuñeco()
juego = int(input("1-Solitario \n2-Multijugador"))
while len(str(juego)) > 1 or str(juego).isalpha() == True:
    print("El caracter introducido no es válido, intentalo de nuevo: ")
    juego = int(input("1-Solitario \n2-Multijugador \n"))

if juego == 2:
    palabra = getpass.getpass("Introduce una palabra: ")
    palabra.lower()
else:
    palabras = ["coche", "casa", "hipopotamo", "cerveza", "edificio", "minotauro", "lego", "ordenador", "python", "ivan", "defecar", "tenis", "metro", "tren", "raton"]
    numero = random.randint(0, len(palabras) - 1)
    palabra = palabras[numero]

def verMuñeco():
    if vidas == 6:
        print("\n --------------|", "\n |             0  ", "\n |            \|/", "\n |             |  ","\n---           / \ ")
    elif vidas == 5:
        print("\n --------------|", "\n |             0  ", "\n |            \|/", "\n |             |  ","\n---           /  ")
    elif vidas == 4:
        print("\n --------------|", "\n |             0  ", "\n |            \|/", "\n |             |  ","\n---             ")
    elif vidas == 3:
        print("\n --------------|", "\n |             0  ", "\n |            \|/", "\n |               ","\n---             ")
    elif vidas == 2:
        print("\n --------------|", "\n |             0  ", "\n |            \|", "\n |               ","\n---             ")
    elif vidas == 1:
        print("\n --------------|", "\n |             0  ", "\n |             |", "\n |               ","\n---             ")
    elif vidas == 0:
        print("\n --------------|", "\n |             0  ", "\n |            ", "\n |               ","\n---             ")

def verMenu():
    opcion = int(input("¿Que quieres hacer?: \n1-Probar con una letra \n2-Adivinar palabra completa:"))
    while len(str(opcion)) > 1 or str(opcion).isalpha() == True: 
        print("El caracter introducido no es válido, intentalo de nuevo: ")
        opcion = int(input("¿Que quieres hacer?: \n1-Probar con una letra \n2-Adivinar palabra completa:"))
    return opcion

print("Tienes :", vidas * "*", " vidas")
secreto = "*" * len(palabra)
secret = "-" * len(palabra)

while vidas > 0:
    
    letras = []
    
    print("Tienes :", vidas * "$ ")
    verMuñeco()
    print(secreto)
    print(secret)

    opcion = verMenu()
    while(opcion != 1 and opcion != 2):
        print("Opción no válida")
        opcion = verMenu()

    if opcion == 1:
        caracter = input("¿Que letra quieres introducir?")
        while caracter.isalpha() == False or caracter.isdigit() == True or len(caracter) > 1: 
            print("El caracter introducido no es válido")
            caracter = input("Intentalo de nuevo")
    elif opcion == 2:
        caracter = input("¿Que palabra quieres introducir?")
        
    caracter.lower()

    if len(caracter) == 1:
        for i in range(0, len(palabra)):
            if palabra[i] == caracter:
                secreto = secreto[0:i] + caracter + secreto[(i + 1):]
                print("El caracter", caracter," se encuentra en la palabra")
        if palabra.find(caracter) == -1:
            print("El caracter ", caracter," no se encuentra en la palabra")
            letras.append(caracter)
            vidas = vidas - 1
    else:
        if caracter == palabra:
            print("Enhorabuena has acertado la palabra :)")
            verMuñeco()
            vidas = 0
        else:
            print("Lo siento la palabra no es correcta, has perdido")
            vidas = 0
            verMuñeco()
    if secreto == palabra and len(caracter) == 1:
        print("Enhorabuena acertaste la palabra")
        vidas = 0
    
    print("Ultima letra errada")
    for j in letras:
        print(letras)
print("Fin del juego, gracias por jugar")