suma = 0
media = 0
while True:
    num = int(input("Introduzca un número: "))
    suma = num + suma
    media = (suma) / (media + 1)
    print(suma)
    print(media)
    if num == 0:
        break