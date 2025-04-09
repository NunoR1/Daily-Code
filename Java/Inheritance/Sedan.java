package Inheritance;

public class Sedan extends Car{

    double trunkSpace;

    Sedan() {
        domain = "land";
        wheels = 4;
        onRoad = true;
        speed = 0;
        trunkSpace = 0;
    }

    void goTo() {
        System.out.println("On my way");
    }
}
