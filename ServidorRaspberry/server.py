#!/usr/bin env python

import socket
import serial
import subprocess
import time

device = subprocess.check_output('ls /dev/ttyACM0', shell = True)
print device

try:
	serialPort = serial.Serial(device.strip(),115200)
	print "Arduino conectado"
except:
	print "Arduino nao conectado"

def servidor():
	global serialPort
	while True:
		conn, addr = socketServidor.accept();
		print "Endereco de conexao: ", addr
		data = conn.recv(BUFFER_SIZE)
		if not data: continue
		print "Dado recebido: ", data
		if data == '1':
			conn.send("A luz foi ligada")
			serialPort.write('1')
			conn.close()
		elif data == '2':
			conn.send("A luz foi desligada!")
			serialPort.write('2')
			conn.close()
		elif data == '0':
			conn.send('Encerrando o servidor')
			serialPort.close()
			conn.close()
			exit(0)

IP_ADDRESS = '192.168.0.18' # IP do servidor
TCP_PORT = 5000 # Porta de conexao do servidor
BUFFER_SIZE = 1024  # Buffer padrao

socketServidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socketServidor.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR,1)
socketServidor.bind((IP_ADDRESS, TCP_PORT))
socketServidor.listen(5)

print "Servidor iniciado!"

servidor()

print "Servidor desligado!"
