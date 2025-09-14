frase = ""

while (palabra := input("Introduce una palabra para añadir a la frase: \n")) != "fin":
    frase += palabra
    
print(frase)