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
        self.cartas = list()
        for palo in Palo:
            for numero in Numero:
                self.cartas.append(Carta(numero, palo))
    
    def mostrar(self):
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
            

baraja = Baraja()

baraja.mostrar()
print("bara")
baraja.barajar()

baraja.mostrar()