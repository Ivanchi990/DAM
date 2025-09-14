def temperatura_media(max, min):
    return (max + min) / 2

max = int(input("Introduce la temperatura máxima: "))
min = int(input("Introduce la temperatira mínima: "))

print("La temperatura media es de", temperatura_media(max, min), "ºC")