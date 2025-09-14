user = 'root'
pasw = 'thor'
correct = False

def check_user(user, pasw):
    if(user == 'root' and pasw == 'thor'):
        return True
    else:
        return False

while(correct == False):
    user2 = input("Introduce el usuario: ")
    pasw2 = input("Introduce la contraseña: ")
    if check_user(user2, pasw2) == True:
        print("Enhorabuena usuario y contraseña correcto.")
        correct = True
    else:
        print("Usuario o contraseña incorrectos, intentalo de nuevo: ")