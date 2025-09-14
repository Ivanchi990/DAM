dia = int(input("Introduzca el dia."))
mes = int(input("Introduzca el mes."))
año = int(input("Introduzca el año"))
divisible4 = año % 4 == 0
divisible100 = año % 100 == 0
divisible400 = año % 400 == 0
if divisible4 and (not divisible100 or divisible400):
    print("El año ", año, " es bisiesto.")
else:
    print("El año ", año, " no es bisiesto.")