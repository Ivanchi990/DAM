num1 = int(input("Introduzca el primer número: "))
num2 = int(input("Introduzca el segundo número: "))
num3 = int(input("Introduzca el tercer número: "))
if (num1 <= num2) and (num1 <= num3):
    menor = num1;
    if (num2 <= num3):
        mediano = num2;
        mayor = num3;
    else:
        mediano = num3;
        mayor = num2;
elif (num2 <= num1) and (num2 <= num3):
    menor = num2;
    if (num1 <= num3):
        mediano = num1;
        mayor = num3;
    else:
        mediano = num3;
        mayor = num1;
else:
    menor = num3;
    if (num1 <= num2):
        mediano = num1;
        mayor = num2;
    else:
        mediano = num2;
        mayor = num1;
print(mayor, " es mayor que", mediano, " y que ", menor)
