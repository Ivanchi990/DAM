def pasarBinario(num):
    bin = []
    
    while num > 2:
        n = num % 2
        num = num / 2
        bin.append(n)
    
    bin = bin.reverse
    print(*bin)

def pasarDecimal(num):
    
    n = list(n)
    decimal = 0
    
    for i in range(len(n)):
        decimal += int(n[i]) * 2 ** i
    
    print(decimal)
        
while True:
    print("CONVERSOR __/BINARIO <-> DECIMAL\__")
    opc = int(input("1-Binario --> Decimal \n2-Decimal --> Binario \n*)Salir \n\n"))
    
    if opc == 1:
        num = int(input("Introduce el número binario: \n"))
        pasarDecimal(num)
    elif opc == 2:
        num = int(input("Introduce el número decimal: \n"))
        pasarBinario(num)
    else:
        print("\n\nCHAU... :) \n")
        break