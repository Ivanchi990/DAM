import random

def init():
    tablero = list()
    
    for i in range(3):
        fila = list()
        for j in range(3):
            fila.append("-")
        tablero.append(fila)
    return tablero
        
def empezar():
    return (random.randint(0, 1))

def empiezaMaquina():
    num = random.randint(0, 1)
    if num == 0:
        return 'X'
    else:
        return 'O'

def tableroLleno(tablero):
    for i in range(3):
        for j in range(3):
            if tablero[i][j] == '-':
                return False
    return True

def victoria(tablero):
    if (tablero[0][0] == 'X' and tablero[1][1] == 'X' and tablero[2][2]) == 'X' or (tablero[0][2] == 'X' and tablero[1][1] == 'X' and tablero[2][0] == 'X') or (tablero[0][0] == 'O' and tablero[1][1] == 'O' and tablero[2][2]) == 'O' or (tablero[0][2] == 'O' and tablero[1][1] == 'O' and tablero[2][0] == 'O'):
        return True
    for i in range(3):
        cont = 0
        for j in range(3):
            if tablero[i][j] == 'X' or tablero[i][j] == 'O':
                cont += 1
            if tablero[j][i] == 'X' or tablero[j][i] == 'O':
                cont += 1
        return (cont == 3)
    
def mostrarTablero(tablero):
    print("+---+---+---+" + f"\n| {tablero[0][0]} | {tablero[0][1]} | {tablero[0][2]} |" + "\n+---+---+---+" + f"\n| {tablero[1][0]} | {tablero[1][1]} | {tablero[1][2]} |" + "\n+---+---+---+" + f"\n| {tablero[2][0]} | {tablero[2][1]} | {tablero[2][2]} |" + "\n+---+---+---+")

def posValida(tablero, uno, dos):
    return (tablero[uno][dos] == '-')

tablero = init()
mostrarTablero(tablero)

continuar = True
while not continuar:
    quien = empezar()
    tablero = init()
    if quien == 0: 
        print("Empieza la máquina, elige tu ficha: X o O: ")
    else:
        como = empiezaMaquina()
        print(f"Empizas tu jugando con {como}")
    continuar = tableroLleno()