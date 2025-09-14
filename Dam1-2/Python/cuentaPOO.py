class Cuenta:
    def _init_(self,numero_cuenta,titular,saldo,interes):
	    self.__numero_cuenta = numero_cuenta
	    self.__titular = titular
	    self.__saldo = saldo
	    self.__interes = interes
	@property
	def numero_cuenta(self):
		return self.__numero_cuenta

	@numero_cuenta.setter
	def numero_cuenta(self, numero):
		self.__numero_cuenta = numero

	def ingresar(self,cantidad):
		self.__saldo += cantidad

	def retirar(self,cantidad):
		if self.__saldo >= cantidad:
			self.__saldo -= cantidad
			return cantidad
		else:
			return 0

	def mostrar(self):
		print(f"Titular:{self.__titular}")
		print(f"Numero de cuenta:{self.__numero_cuenta}")
		print(f"Saldo:{self.__saldo}")
		print(f"Interes:{self.__interes}")

class Oficina:
	def _init_(self):
		self.cuentas = list()
	def agregar(self, cuenta):
		self.cuentas.append(cuenta)
	def buscar_por_titular(self,titular):
		pass

	def buscar_por_numero_cuenta(self, numero):
		for cuenta in self.cuentas:
			if cuenta.numero_cuenta == numero:
				return cuenta
		return None

	def mostrar_cuentas(self):
		for cuenta in self.cuentas:
			cuenta.mostrar()

def menu():
	print("1- Listar cuentas")
	print("2- AÃ±adir cuenta")
	print("3- Ingresar en cuenta")
	print("4- Retirar efectivo")
	print("5- Consultar cuenta")
	print("6- Salir")


def buscar_cuenta():
	cuenta = None
	while cuenta == None:
		numero = input("Dame el numero de cuenta sobre la que quieres operar: ")
		cuenta = oficina.buscar_por_numero_cuenta(numero)
	return cuenta

salir = False
oficina = Oficina()
while not salir:
	menu()
	opcion = int(input("Opcion:"))
	if opcion == 1:
		oficina.mostrar_cuentas()
	elif opcion == 2:
		numero = input("Dame el numero de cuenta:")
		titular = input("Dame el titular: ")
		saldo = float(input("Dame el importe con el que quieres abrir la cuenta: "))
		tipo = float(input("Dame el interes: "))
		cuenta = Cuenta(numero,titular,saldo,tipo)
		oficina.agregar(cuenta)
	elif opcion == 3:
		cuenta = buscar_cuenta()
		cantidad = float(input("Dame la cantidad: "))
		cuenta.ingresar(cantidad)
	elif opcion == 4:
		cuenta = buscar_cuenta()
		cantidad = float(input("Dame la cantidad que quieres retirar: "))
		if cuenta.retirar(cantidad)>0:
			print(f"Se han retirado {cantidad} euros")
		else:
			print("Saldo insuficiente")
	elif opcion == 5:
		cuenta = buscar_cuenta()
		cuenta.mostrar()
	else:
		salir = True