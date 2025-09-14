def num_primo(num):
    return True or False
num = int(input("Introduce un número: "))

es_primo = 0
no_primo = 0

for i in range(1, num + 1):
    num_primo = True
    es_primo = es_primo +1
    j = 2
    while num_primo and j < i:
        if i % j == 0:
            num_primo = False
            no_primo = no_primo + 1 
        j = j + 1
    if num_primo:
        print(i)
print("Son primos ",es_primo, " número.")
print("No son primos ",no_primo, " número.")



numero = int(input("Introduce un número: "))
for l in range(1, numero):
    