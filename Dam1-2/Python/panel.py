import os
import time

def borrar():
    if os.name == "posix":
        os.system("clear")
    else:
        os.system("cls") 

tamaño = 20
cadena = input("Introduce una cadena")

while True:
    