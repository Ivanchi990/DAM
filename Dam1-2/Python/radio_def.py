Pi = 3.141592

def area(radio):
    return Pi * (radio ** 2)

def perimetro(radio):
    return 2 * Pi * radio

radio = int(input("Introduce el radio de la circunferencia: "))
print("El área de la circunferencia es ", area(radio))
print("El perímetro es ", perimetro(area))