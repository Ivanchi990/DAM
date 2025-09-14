letra = 0
while(letra != ' '):
    letra = input("Intoduce una letra: ")
    if(letra == 'a' or letra == 'e' or letra == 'i' or letra == 'o' or letra == 'u'):
        print("Es vocal")
    else:
        print("No es vocal")