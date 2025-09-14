import pyautogui as pg
import time, random

dni, edad, nombres, id_equipo= list(), list(), list(), list()

f = open("jugadores.txt", "r", encoding="utf8")

while True:
    nombre = f.readline()
    nombres.append(nombre)
    nombre = f.readline()
    nombre = nombre.strip()
    if not nombre:
        break

f.close()

for i in range(len(nombres)):
    ndni = random.randint(00000000, 99999999)
    while len(str(ndni)) != 8:
        ndni = random.randint(00000000, 99999999)
    nedad = random.randint(17, 37)
    id = random.randint(1, 21)

    id_equipo.append(id)
    dni.append(ndni)
    edad.append(nedad)

letras = ["T","R", "W", "A", "G","M", "Y","F","P","D","X","B","N", "J", "Z","S","Q", "V","H","L", "C","K","E"]

for num in range(len(nombres)):
    letra = dni[num] % 23
    nuevo = str(dni[num]) + letras[letra]
    dni[num] = nuevo

for i in range(len(nombres)):
    pg.write(f'insert into jugador values ("{nombres[i]}",{edad[i]}, "{dni[i]}", "{id_equipo[i]}");')
    time.sleep(0.4)
    pg.press('enter')


