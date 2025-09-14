#Ejercicio 1

contraseña = input("Introduce la contraseña: \n")
if contraseña in ["sesamo"]:
  print("pasa")
else:
  print("no pasa")
  
#Ejercicio 2

base = input("Introduce la base imponible de la factura: \n")

iva = 21

def aplica_iva(base):
    base = base * iva   
    return base 

print(aplica_iva(23))

#Ejercicio 2

