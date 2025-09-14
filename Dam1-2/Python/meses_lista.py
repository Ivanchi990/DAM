meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
dias = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

num = 0
while num <= 0 or num > 12:
    num = int(input("Introduce el número del mes: "))

print("El número ", num, "corresponde al mes " + meses[num-1] + " dicho mes tiene", dias[num-1], "dias.")