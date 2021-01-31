import logging
import threading
import time
import random

# Configuracion del Logger
format = "%(asctime)s: %(message)s"
logging.basicConfig(format=format, level=logging.INFO, datefmt="%H:%M:%S")


# Clase
class Example_Thread(threading.Thread):
    # Constructor
    def __init__(self, id_thread: int, delay_time: float, msg: str):
        super().__init__()
        self.id_thread = id_thread
        self.delay_time = delay_time
        self.msg = msg

    # Método
    def message(self):
        time.sleep(self.delay_time)
        print(f"ID Thread: {self.id_thread} - Message: {self.msg}")

    # Run
    def run(self):
        self.message()


thread = []
delay_time = random.uniform(2.5, 4.5)
print(f"Estimado usuario por favor espere {delay_time} segundos")
thread = Example_Thread(id_thread=0, delay_time=delay_time, msg="Un saludo con un poco de espera")
thread.start()
