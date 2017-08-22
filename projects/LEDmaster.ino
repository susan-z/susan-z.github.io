#include <SoftwareSerial.h>
SoftwareSerial  BTSerial(2, 3); //RX TX
const int button1 = 9;
const int button2 = 10;
int val = 0;
int val2 = 0;
int link = 0;
int link2 = 0;

void setup() {
  BTSerial.begin(9600); 
  Serial.begin(9600);
  pinMode(button1, INPUT);
  pinMode(button2, INPUT);
}

void loop() {
  val = digitalRead(button1);
  val2 = digitalRead(button2);
  if(val == 1) {
    if(link == 0){
      link = 1; //turn it on
    }
    else {
      link = 0; //turn it off
    }
  }
  delay(150);
  if(val2 == 1) {
    if(link2 == 0) {
      link2 = 3; //turn it on
    }
    else {
      link2 = 0; //turn it off
    }
  }
  BTSerial.print(link + link2);
  Serial.println(link + link2);

  delay(150);
}
