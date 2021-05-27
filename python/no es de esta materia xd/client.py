import socket
from ftplib import FTP
from time import time

TCP_IP = "iele1400.ddns.net"  # Only a local server
TCP_PORT = 55555  # Just a random choice
BUFFER_SIZE = 4096  # Standard chioce
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
ftp = FTP()


def conct_socket(nombre: str):
    """

    :return:
    """

    print("Enviando Socket solicitud al servidor...", end='')
    try:
        s.bind(("12.12.12.8", 49344))
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
    print(f"\rArchivo {nombre} guardado exitosamente.")
    print(f"La velocidad de transferencia fue: {vel_transfer} MB/s")
    print(f"Tiempo de transferencia fue: {round(t_total, 1)} s")

    s.close()


def conct_ftp(nombre: str):
    """

    :param nombre:
    :return:
    """
    print("Enviando solicitud FTP al servidor...", end='')
    try:
        ftp.connect(TCP_IP, 21)
        ftp.login('c_iele1400', 'uniandes2020')
        print("\rConexión FTP exitosa                         ")
    except FTP.all_errors:
        print("\rConexión FTP rechazada por el servidor       ")

    ftp.cwd("/imagenes_proyecto_final")
    start_time = time()
    ftp.retrbinary("RETR " + nombre, open(nombre, 'wb').write)
    print(f"Archivo {nombre} solicitado.", end='')
    elapsed_time = time() - start_time
    print(f"\rArchivo {nombre} guardado exitosamente.")

    tamanio = float(ftp.size(nombre)) / 1048576
    vel_transfer = round(tamanio / elapsed_time, 1)
    print(f"La velocidad de transferencia fue: {vel_transfer} MB/s")
    print(f"Tiempo de transferencia fue: {round(elapsed_time, 1)} s")

    ftp.quit()


def mostrar_menu():
    print("\nOpciones")
    print("1. Descargar 650k.jpg con Sockets")
    print("2. Descargar 45m.mp4 con Sockets")
    print("3. Descargar 650k.jpg con FTP")
    print("4. Descargar 45m.mp4 con FTP")
    print("5. Salir de la aplicacion")


def iniciar_aplicacion():
    """Ejecuta el programa para el usuario."""
    mostrar_menu()
    opcion_seleccionada = int(input("Por favor seleccione una opción: "))
    print("#############################")
    if opcion_seleccionada == 1:
        conct_socket("650k.jpg")
        print("#############################")
    elif opcion_seleccionada == 2:
        conct_socket("45m.mp4")
        print("#############################")
    elif opcion_seleccionada == 3:
        conct_ftp("650k.jpg")
        print("#############################")
    elif opcion_seleccionada == 4:
        conct_ftp("45m.mp4")
        print("#############################")
    elif opcion_seleccionada == 5:
        print("Finalizando APP")
    else:
        print("Por favor ingrese una opcion válida")


# PROGRAMA PRINCIPAL
iniciar_aplicacion()
