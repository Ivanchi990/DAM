class Persona:
    def _init_(self, nombre, edad, dni, sexo, peso, altura):
        self.nombre= nombre
        # assert edad >=0, "Lo siento, la edad tiene ser mayor que 0"
        self.edad= edad
        self.dni = dni
        self.sexo = sexo
        self.peso= peso
        self.altura= altura
    
    def nombre(self):
        return self.nombre
    
    def calcular_MC(self):
        if(self.peso / (self.altura^2)<20):
            return -1
        elif(self.peso / (self.altura^2)>=20 and self.peso / (self.altura^2)<=25):
            return 0
        else:
            return 1

    def es_mayor_edad(self, edad):
        if (edad >=18):
         return True
    
    def comprobar_sexo(self, sexo):
        if(sexo!="H" or sexo!="M"):
            return True
    
    def mostrar(self):
        print(f"Nombre: {self.nombre}")
        print(f"DNI: {self.dni}")
        print(f"edad: {self.edad}")
        print(f"sexo: {self.sexo}")
        print(f"peso: {self.peso}")
        print(f"altura: {self.altura}")

    def pedir_DNI(self):
        letras = ["T","R", "W", "A", "G","M", "Y","F","P","D","X","B","N", "J", "Z","S","Q", "V","H","L", "C","K","E"]
        for letra in letras:
            letra = self.dni %23
            return letras[letra]
def pedir():
    nombre = input("Introduce el nombre: \n")
    edad = input("Introduce la edad: \n")
    dni = input("Introduce el dni sin la letra: \n")
    sexo = input("Introduce el sexo(H/M): \n")
    peso = input("Introduce el peso: \n")
    altura = input("Introduce la altura: \n")
    persona = Persona(nombre, edad, dni, sexo, peso, altura)
    return persona

def comprobarMC(persona):
    if persona.calcular_MC() == -1:
        print("Te encuentras en un peso ideal.")
    elif persona.calcular_MC() == 0:
        print("Vaya, parece que estas por debajo de tu peso ideal.")
    elif persona.calcular_MC() == 1:
        print("UY UY UY, parece que tienes sobrepeso")
        
def comprobar18(persona):
    if persona.es_mayor_edad():
        print(f"La persona con nombre {persona.nombre} es mayor de edad")
    else:
        print(f"La persona con nombre {persona.nombre} no es mayor de edad")

persona1 = pedir()
persona2 = pedir()
persona3 = pedir()

comprobarMC(persona1)
comprobarMC(persona2)
comprobarMC(persona3)

comprobar18(persona1)
comprobar18(persona2)
comprobar18(persona3)

persona1.mostrar()
persona1.mostrar()
persona1.mostrar()