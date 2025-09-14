sueldo = float (input("Introduzca el salario base: "))
venta1 = float(input("Introduzca el valor de la primera venta: "))
venta2 = float(input("Introduzca el valor de la segunda venta: "))
venta3 = float(input("Introduzca el valor de la tercera venta: "))
comisiones = ((venta1 + venta2 + venta3) * 15 / 100)
sueldot = sueldo + comisiones
print("Su sueldo es de: ", sueldot, " euros.")