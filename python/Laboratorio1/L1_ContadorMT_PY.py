import threading
import time

# Es el valor limite, se le pregunta al usuario por consola
numLimite = int(input("Ingrese en limite para contar:"))


# Funcion que imprime numeros pares o impares
def run(num: int, limit: int):
    for x in range(num, limit + 1):

        """ 
        En este condicional se determina si el thread imprime numeros pares o impares,
        el funcionamiento es el siguiente: si el thread imprime los numeros impares se revisa que
        el modulo sea diferente de 0 y si el thread imprime los numeros pares se revisa que 
        el modulo sea igual a 0. Por ultimo se deja un espacio de 0.2 segundos entre impresion.
        """
        if num == 1:
            if x % 2 != 0:
                print(x)
        elif num == 2:
            if x % 2 == 0:
                print(x)
        # Delay
        time.sleep(0.2)


# Creacion de los Threads
thread0 = threading.Thread(target=run, args=(1, numLimite))
thread1 = threading.Thread(target=run, args=(2, numLimite))

# Inicio del primer thread
thread0.start()
# Se le aplica un delay al segundo thread para garantizar que el conteo se haga en orden
time.sleep(0.1)
# Inicio del segundo thread
thread1.start()

