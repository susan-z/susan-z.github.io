#include <Servo.h> //include servo library
Servo servo1; // create servo object to control servo motor
int jstick2 = A1; // analog pin to connect the joystick U/D (orange)
int UD_val; // read U/D value from joystick
double loadcell = A3; // analog pin A0
double force; // variable to read force exerted on loadcell
int start = 45; // servo start position
void setup() {
 servo1.attach(A4);// attaches servo on analog pin 4
 Serial.begin(9600);
 servo1.write(start); // starting position of servo
}
 double forceKG(double val) {
 return (469.00 - val) / 60.0;
 } // convert to kgs
void loop() {
 UD_val = analogRead(jstick2); // read joystick value
 //Serial.println(UD_val);
 if (UD_val > 550){
 UD_val = map(UD_val, 550, 1023, start, 0);
 }
 else{
 UD_val = map(UD_val, 0, 510, 180, start);
 }
 // scale it to use it with the servo, maximum commanded force of 2.5kg and a precision of 10g.
 servo1.write(UD_val); // tell the servo to move
 force = analogRead(loadcell);
 //Serial.println(force);
 Serial.println(String(forceKG(force)) + "kg");
 Serial.println(String(UD_val) + "degrees");
 delay(500);
}

