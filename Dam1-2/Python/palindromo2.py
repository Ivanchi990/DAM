def es_palindromo(palabra):
    for i in palabra:
        aux += i
    

palabra = input("Introduce una palabra: \n")

if(es_palindromo(palabra)):
    print(f"La palabra {palabra} es un palíndromo.")
else:
    print("Vaya parece que la palabra {palabra} no es un palíndromo.")