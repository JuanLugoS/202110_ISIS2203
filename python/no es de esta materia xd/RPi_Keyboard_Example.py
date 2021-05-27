import time

NULL_CHAR = chr(0)


def write_report(report):
    with open('/dev/hidg0', 'rb+') as fd:
        fd.write(report.encode())


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
# Press 0
write_report(NULL_CHAR * 2 + chr(39) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
# Press 0
write_report(NULL_CHAR * 2 + chr(39) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)


# Press 1
write_report(NULL_CHAR * 2 + chr(30) + NULL_CHAR * 5)
# Release keys
write_report(NULL_CHAR * 8)
write_report(NULL_CHAR * 2 + chr(40) + NULL_CHAR * 5)
time.sleep(0.5)

# Release all keys
write_report(NULL_CHAR*8)
