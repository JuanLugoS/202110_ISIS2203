"""from ftplib import FTP
from time import time


ftp = FTP()
ftp.connect('12.12.12.21', 21)
start_time = time()

elapsed_time = time() - start_time
print("Elapsed time: %0.10f seconds." % elapsed_time)
ftp.login('pi', 'Elgatico51')
A = "alice.txt"
ftp.retrbinary("RETR " + A, open(A, 'wb').write)

ftp.quit()"""

import subprocess
from time import time

elapsed_time = 0
start_time = time()

while elapsed_time < 10:
    elapsed_time = time() - start_time
    with open("nombre_arc.txt", "a") as f:
        f.write("xd\n")
        f.close()

process1 = subprocess.Popen(['python', 'client.py'])


