class Agenda:
    
    def __init__(self, nombre, tel, email):
        self.nombre = nombre
        self.tel = tel
        self.email = email
    
    def mostrar_menu(self):
        print()
        menu = ['--Agenda Personal--'],
        ['1. Añadir contacto', "añadir"],
        ['2. Lista de contactos'],
        ['3. Buscar contacto'],
        ['4. Editar contacto'],
        ['5. Eliminar contacto'],
        ['6. Cerrar agenda']
        
        for i in range(7):
            print(menu[i][0])

contacto = Agenda("Julio Verne", 67565453, "pepipto@lamello.com")