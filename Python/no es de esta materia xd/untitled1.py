import socket
from ftplib import FTP
from time import time

TCP_IP = "iele1400.ddns.net"  # Only a local server
TCP_PORT = 55555  # Just a random choice
BUFFER_SIZE = 4096  # Standard chioce
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
ftp = FTP()


def conct_socket():
    """

    :return:
    """

    nombre = "650k.jpg"

    print("Enviando Socket solicitud al servidor...", end='')
    try:
        s.bind(("12.12.12.21", 49344))
        s.connect((TCP_IP, TCP_PORT))
        print("\rConexión Socket exitosa                 ")
    except socket.timeout:
        print("\rTiempo de conexión agotado               ")
    except:
        print("\rConexión Socket rechazada por el servidor")

    s.send(nombre.encode())
    print(f"Archivo {nombre} solicitado.", end='')
    vwr = s.recv(BUFFER_SIZE).decode()
    lista = vwr.split("<SEPARATOR>")
    nombre_arc = lista[0]
    tamanio = float(lista[1])/1048576
    b_temporal = True
    t_total = 0

    with open(nombre_arc, "wb") as f:
        while b_temporal:
            start_time = time()
            recv_data = s.recv(BUFFER_SIZE)
            elapsed_time = time() - start_time
            t_total += elapsed_time
            if not recv_data:
                b_temporal = False
            f.write(recv_data)
        f.close()

    vel_transfer = round(tamanio/t_total, 1)
    with open("nombre_arc.csv", "a") as f:
        f.write(f"Socket;650k.jpg;{t_total};{vel_transfer}\n")
        f.close()

    s.close()
