tabla_desde = int(input("Introduce un número: ")) 
tabla_hasta = int(input("Introduce un número: ")) 
desde = 1
hasta = 10 

for num1 in range(tabla_desde, tabla_hasta + 1):
	print(f'Tabla de multiplicar del {num1}:') 
	for num2 in range(desde, hasta + 1):
		print(f'{num1} x {num2} = {num1 * num2}')
	print() 