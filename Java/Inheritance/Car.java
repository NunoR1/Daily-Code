package Inheritance;

public class Car extends Vehicle{

    int wheels;
    boolean onRoad;

    Car() {
        domain = "land";
        wheels = 4;
    }

    void honk() {
        System.out.println("HONK");
    }
}
