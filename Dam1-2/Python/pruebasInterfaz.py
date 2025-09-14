from email.mime import application
import tkinter as tk
from tkinter import *
from turtle import width

#Comienzo de la prueba con tkinter
class Ventana_prueba:
    
    def __init__(self, ventana):
        self.ventana=ventana
        self.ventana.title("Prueba ventana")
        self.ventana.config(height=350, width=350)

if __name__ == "__main__":
    ventana = Tk()
    application=Ventana_prueba(ventana)
    ventana.mainloop()
    