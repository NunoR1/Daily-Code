package Inheritance;

public class Vehicle {

    double speed;
    String domain;
    boolean lightOn;

    Vehicle() {
        speed = 0;
        domain = "land";
        lightOn = false;
    }

    void toggleLight() {
        lightOn = !lightOn;
    }
}
