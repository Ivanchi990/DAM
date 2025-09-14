def decirDias(mes, año):
   if mes > 0:
       if mes == 1 and 3 and 5 and 7 and 8 and 10 and 12:
           return 31
       elif mes == 4 and 9 and 11:
           return 30
       else:
           if (año % 4 and (año % 100 or not año % 400)) and mes == 2:
               return 28
           else:
               return 29
mes = int(input("Introduce el número del mes: "))
año = int(input("Introduce el año: "))  

print("El mes tiene ", decirDias(mes, año), "dias.")