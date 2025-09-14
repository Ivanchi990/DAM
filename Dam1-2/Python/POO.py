class Persona:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
    
    def cumple(self):
        self.edad += 1

pedro = Persona("Pedro", 33)
juana = Persona("Juana", 23)

print(pedro.nombre, " tiene ", pedro.edad)
pedro.cumple
print(pedro.nombre, " tiene ", pedro.edad)