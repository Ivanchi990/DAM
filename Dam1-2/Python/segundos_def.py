suma_seg = 0

def calcularSegundos(horas, minutos, segundos):
    if horas >= 0:
        suma_seg = horas * 36000
    if minutos >= 0:
        suma_seg = suma_seg + (minutos * 60)
    return suma_seg + segundos

horas = int(input("Introduce el número de horas: "))
minutos = int(input("Introduce la cantidad de segundos: "))
segundos = int(input("Introduce los segundos: "))

print("Son " ,calcularSegundos(horas, minutos, segundos), "segundos.")