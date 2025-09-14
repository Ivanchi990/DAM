def es_multiplo(numero, multiplo):
    numeroEs_Multiplo = False
    if (numero % multiplo) == 0:
        numeroEs_Multiplo = True
    return numeroEs_Multiplo
numero1 = int(input("Introduce un número: "))
numero2 = int(input("Introduce un número: "))

if es_multiplo(numero1, numero2):
    print(numero2, " es múltiplo de ", numero1)
else:
    print(numero2, " no es múltiplo de ", numero1)  