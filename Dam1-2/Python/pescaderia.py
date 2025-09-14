import os
import time

tamañoPantalla = 10
def borrarPantalla():
    if os.name == "posix":
        os.system("Clear")
    else:
        os.system("cls")

frase = input("Introduce la frase para la pescaderia")

#Comprobar longitud

longitud_cadena = len(frase)

while True:
    for i in range(0, longitud_cadena):
        borrarPantalla()
        print(frase[i:tamañoPantalla + i])
        time.sleep(1)