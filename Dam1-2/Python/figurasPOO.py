class Rectangulo:
    
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura
    
    def nombre(self):
        return self.nombre
    
    def nombre(self, nombre):
        self.nombre = nombre
    
    def edad(self):
        return self.edad
    
    def edad(self, edad):
        self.edad = edad
    
    def calcularArea(self):
        return self.base * self.altura
    
    def calcularPerimetro(self):
        return (self.base * 2) + (self.altura * 2)

rec = Rectangulo(12, 2)

area = rec.calcularArea()
per = rec.calcularPerimetro()

print("El área del rectángulo es: ", area, "\nEl perímetro del rectángulo es: ", per)