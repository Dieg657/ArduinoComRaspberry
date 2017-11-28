# ArduinoComRaspberry
Conexão via TCP/IP ao Raspberry Pi 3 com Arduino acendendo Lâmpada!

## Como funciona?

Este código todo funciona em três etapas:
### Arduino
 1. No Arduino, o arquivo *INO* deste repositório deverá ser carregado nele, o pino usado *Signal* neste projeto é o PINO 10, mas você pode configurar outro se assim desejar!
 2. Ligar o relê de *5VDC*, no seguinte esquema, *GND* do relê com *GND* do Arduíno, *VCC* do relê com *5VCC* do Arduino e o *PIN 10* do Arduíno com o *SIGNAL* do relê.
 3. Carregar o *Skecth* no Arduíno.
 ##### O Arduíno utilizado foi o Arduíno UNO
### Raspberry
 1. O código *server.py* deverá ser executado no Raspberry precedido pelo *python em sudo*, a porta e IP usados nessa aplicação foram fixados anteriormente, é recomendável alterar estes parametros antes de executar este código no seu Raspberry. 
##### O Raspberry utilizado foi o Raspberry Pi 3. 
### Android
 1. O código disposto neste repositório foi desenvolvido para rodar no Android 5.0.1 *(Lollipop)*, ele já se encontra pré-disposto para compilação, há dois campos para entrada de dados *IP do Servidor, Porta do Servidor*, bem como os botões que efetuam o envio dos comandos de *Desligar e Ligar*, há um *TextView* que é responsável por retornar a resposta do servidor, caso esteja tudo funcionando devidamente o código do *Servidor* no Raspberry deverá retornar uma mensagem dizendo se o Arduíno, ligou ou desligou o Lâmpada.
