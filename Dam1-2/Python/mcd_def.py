num = 0

def check_mcd(num1, num2):
    if(num1 % num2 == 0):
        return True
    else:
        return False

num1 = int(input("Introduce un número: "))
num2 = int(input("Introduce un número: "))
if check_mcd(num1, num2) == True:
    print("Son mcd")
else:
    num = int(num1 % num2)
    num = num * num2
    num = num1 - num
    num = num1 % num
    print("El mcd es ", num)