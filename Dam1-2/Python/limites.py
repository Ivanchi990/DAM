incorrecto = True
while incorrecto:
    sup = int(input("Introduce el límite superior: "))
    inf = int(input("Introduce el límite inferior: "))
    if inf < sup:
        incorrecto = False
num = 1
suma = 0
limite = False
while num != 0:
    num = int(input("Introduce un número: "))
    if num == 0:
        break;
    if num > inf and num < sup:
        limites = True
    elif
