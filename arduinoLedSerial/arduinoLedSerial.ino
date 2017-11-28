/*
 * Area da constante
 */
const int ledPin = 10;

void setup() {
  pinMode(ledPin,OUTPUT);
  Serial.begin(115200);
}

void loop() {
  /*
   * Verifica se a Porta Serial está disponível
   */
  if(Serial.available()){
    /*
     * Faz a leitura do inteiro vindo da Porta Serial e passa
     * para a função acendeOuApagaLed
     */
     acendeOuApagaLed(Serial.read());
  }
  delay(100);
}

void acendeOuApagaLed(char n){
  switch(n){
    case '1':
    digitalWrite(ledPin,HIGH);
    Serial.println("Acendeu LED");
    break;
    case '2':
    digitalWrite(ledPin,LOW);
    Serial.println("Apagou LED");
    break;
    default:
    digitalWrite(ledPin,LOW);
    Serial.println("Dado invalido");
    break; 
  }
}

