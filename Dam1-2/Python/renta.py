tipo = 0
renta = float(input("Introduce tu renta anual: "))
if renta > 0 and renta < 10000:
    tipo = 5
elif renta < 20000:
    tipo = 15
elif renta < 35000:
    tipo = 20
elif renta < 60000:
    tipo = 30
else:
    tipo = 45
print("Se le aplicará un tipo impositivo de ", tipo, "%.")