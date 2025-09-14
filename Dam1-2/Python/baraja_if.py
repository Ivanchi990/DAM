from enum import Enum
import random

class Carta:
    def __init__(self, numero, palo):
        self.numero = numero
        self.palo = palo

class Palo(Enum):
    OROS = 1
    COPAS = 2
    ESPADAS = 3
    BASTOS = 4

class Numero(Enum):
    AS = 1
    DOS = 2
    TRES = 3
    CUATRO = 4
    CINCO = 5
    SEIS = 6
    SIETE = 7
    SOTA = 10
    CABALLO = 11
    REY = 12

class Baraja:

    def __init__(self):
        self.monton = list()
        self.cartas = list()
        for palo in Palo:
            for numero in Numero:
                self.cartas.append(Carta(numero, palo))

    def mostrar_baraja(self):
        for carta in self.cartas:
            print(f"{carta.numero.name} de {carta.palo.name}")

    def barajar(self):
        pos = random.randint(0, 39)
        baraja_aux = list()
        for i in range(40):
            pos = random.randint(0, 39 - i)
            baraja_aux.append(self.cartas[pos])
            self.cartas.pop(pos)
        self.cartas = baraja_aux


    def siguiente_carta(self):
        if len(self.cartas) > 0:
            self.monton.append(self.cartas[len(self.cartas)-1])
            carta = self.monton[len(self.monton)-1]
            self.cartas.pop(len(self.cartas)-1)
            print(f"{carta.numero.name} de {carta.palo.name}")
        else:
            print("Vaya, parece que no quedan cartas")


    def cartas_disponibles(self):
        print("Quedan ", len(self.cartas), " cartas disponibles.")


    def dar_cartas(self):
        if len(self.cartas) > 0:
            cantidad = int(input("Introduce el número de cartas que quieres: "))
            if cantidad < len(self.cartas):
                for i in range(cantidad):
                    self.siguiente_carta()
            else:
                print("Vaya, parece que no hay cartas suficientes.")
        else:
            print("Vaya, parece que no hay cartas suficientes.")


    def cartas_monton(self):
        if len(self.monton) > 0:
            for carta in self.monton:
                print(f"{carta.numero.name} de {carta.palo.name}")
        else:
            print("Vaya, parece que no hay cartas suficientes.")

baraja = Baraja()
op = ["Barajar", "Siguiente carta", "Cartas disponibles", "Dar cartas", "Ver monton de cartas", "Mostrar baraja", "Salir"]
opc = 0

while True:
    for i in range(len(op)):
        print(f"{i+1} - {op[i]}\n")

    opc = int(input("¿Que quieres hacer ?\n"))

    if opc == 1:
            baraja.barajar()
    elif opc == 2:
        baraja.siguiente_carta()
    elif opc == 3:
        baraja.cartas_disponibles()
    elif opc == 4:
        baraja.dar_cartas()
    elif opc == 5:
        baraja.cartas_monton()
    elif opc == 6:
        baraja.mostrar_baraja()
    elif opc == 7:
        print("Adios... :)")
        break
    else:
        print("\nVaya parece que no es una opción válida :(")