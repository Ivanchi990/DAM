a = 0
b = 0
c = 0
d = 0
    
def mcd(a, b):
    aux = 0
    while b != 0:
        aux = b
        b = a % b
        a = aux
    return a

def simplificar(c):
    print("La fraccion simplificada es ", a/c, "/", b/c)
    
def sumar(a, b, c, d):
    print("La suma de las fracciones es ", (a*b) + (b*c), "/", (b*d))

a = int(input("Introduce el numerador1: "))
b = int(input("Introduce el denominador1: "))
c = int(input("Introduce el numerador2: "))
d = int(input("Introduce el denominador2: "))

print("La fracción es ", a, "/", b)
simplificar(mcd(a, b))
sumar(a, b, c, d)