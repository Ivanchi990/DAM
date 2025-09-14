print("--[Bienvenido a la pizzería BonnaPizza]--")
vege = int(input("Que tipo de pizza desea \n [1]-Vegetariana \n [2]-No vegetariana"))
if vege == 1:
    opcv = int(input("Que ingrediente extra desea: \n [1]-Pimiento \n [2]-Tofu"))
    if opcv == 1:
        print("Ha elegido una pizza vegetariana con pimiento, tomate y mozzarela.")
    elif opcv == 2:
        print("Ha elegido una pizza vegetariana con tofu, tomate y mozzarela.")
    else:
        print("Opción no válida.")
elif vege == 2:
    opcv = int(input("Que ingrediente extra desea: \n [1]-Peperoni \n [2]-Jamón \n [3]-Salmón"))
    if opcv == 1:
            print("Ha elegido una pizza no vegetariana con peperoni, tomate y mozzarela.")
    elif opcv == 2:
        print("Ha elegido una pizza no vegetariana con jamón, tomate y mozzarela.")
    elif opcv == 3:
        print("Ha elegido una pizza no vegetariana con salmón, tomate y mozzarela.")
    else:
        print("Opción no válida.")
else:
    print("Opción no válida.")