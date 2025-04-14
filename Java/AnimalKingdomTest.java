// Base class
// TODO: Define a class called Animal with:
class Animal {
    protected  String name;

    Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("A");
    }

    @Override
    public String toString() {
        return "Animal: " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal) {
            return this.name.equals(((Animal) o).name);
        }
        return false;
    }
}
// - A protected String field called name
// - A constructor that takes a name and assigns it
// - A public void method called speak() that prints a generic sound
// - Override toString() to return "Animal: " + name
// - Override equals(Object o) to compare names if o is an Animal

// Subclass
// TODO: Define a class called Mammal that extends Animal with:
class Mammal extends Animal {
    protected boolean warmBlooded = true;
    protected String dietType, sound;
    protected int numLegs;

    Mammal(String name, boolean warmBlooded, String dietType, int numLegs, String sound) {
        super(name);
        this.warmBlooded = warmBlooded;
        this.dietType = dietType;
        this.numLegs = numLegs;
        this.sound = sound;
    }

    @Override
    public void speak() {
        System.out.println(this.name + " says: " + this.sound);
    }

    // 4. Add a method to Mammal called performTrick() and call it via downcasting
    public void performTrick() {
        System.out.println(this.name + " did a back-flip");
    }
}
// - A protected boolean field called warmBlooded (set to true)
// - A protected String field called dietType (e.g., "herbivore")
// - A protected int field called numLegs (e.g., 4)
// - A protected String field called sound (e.g., "growl")
// - A constructor that uses super to set name and sets these fields
// - Override speak() to print the value of sound prefixed by name

// Subclasses of Mammal
// TODO: Define a class Dog that extends Mammal
class Dog extends Mammal {
    Dog(String name) {
        super(name, true, "omnivore", 4, "Woof!");
    }

    @Override
    public void speak() {
        System.out.println(this.name + " says: Woof!");
    }
    // 3. Override equals() in Dog or Cat to also check the type☻
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            return this.name.equals(((Animal) o).name);
        }
        return false;
    }
}
// - Constructor takes name and passes name, true, "omnivore", 4, "Woof!" to super
// - Override speak() to print "<name> says: Woof!"

// TODO: Define a class Cat that extends Mammal
class Cat extends Mammal {
    Cat(String name) {
        super(name, true, "carnivore", 4, "Meow!");
    }

    @Override
    public void speak() {
        System.out.println(this.name + " says: Meow!");
    }

    // 3. Override equals() in Dog or Cat to also check the type☻
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            return this.name.equals(((Animal) o).name);
        }
        return false;
    }
}
// - Constructor takes name and passes name, true, "carnivore", 4, "Meow!" to super
// - Override speak() to print "<name> says: Meow!"

// TODO: Define a final class Human that extends Mammal
final class Human extends Mammal {
    Human(String name) {
        super(name, true, "omnivore", 2, "Hello!");
    }
}
// - Constructor takes name and passes name, true, "omnivore", 2, "Hello!" to super

// TODO: Define a class Reptile that extends Animal
class Reptile extends Animal {
    boolean warmBlooded = false;
    int numLegs;
    String dietType, sound;

    Reptile(String name, boolean warmBlooded, String dietType, int numLegs, String sound) {
        super(name);
        this.warmBlooded = warmBlooded;
        this.dietType = dietType;
        this.numLegs = numLegs;
        this.sound = sound;
    }

    @Override
    public void speak() {
        System.out.println(this.name + " says: " + this.sound);
    }
}
// - Add fields: boolean warmBlooded (set to false), int numLegs, String dietType, String sound
// - Constructor should take all values and use super for name
// - Override speak() to print the value of sound prefixed by name

// Main class to test
// TODO: Define class AnimalKingdomTest with a main method
public class AnimalKingdomTest {
    public static void main(String[] args) {
        Animal a1 = new Dog("Buddy");
        Animal a2 = new Cat("Whiskers");

        a1.speak();
        a2.speak();

        System.out.println(a1);
        System.out.println(a2);

        System.out.println(a1.equals(new Dog("Buddy")));

        // 4. Add a method to Mammal called performTrick() and call it via downcasting☻
        Mammal m1 = (Mammal) a1;
        m1.performTrick();

        Mammal m2 = (Mammal) a2;
        m2.performTrick();
    }
}
// - Create Animal a1 = new Dog("Buddy")
// - Create Animal a2 = new Cat("Whiskers")
// - Call speak() on both (demonstrating polymorphism)
// - Print both using System.out.println
// - Use equals() to compare a1 to a new Dog("Buddy")

// Additional TODOs:
// 1. Create a new subclass of Animal (e.g., Bird) and override speak()
class Fish extends Animal {
    boolean warmBlooded = false;
    String dietType, sound;
    int numLegs = 0;

    Fish(String name, boolean warmBlooded, String dietType, int numLegs, String sound) {
        super(name);
        this.warmBlooded = warmBlooded;
        this.dietType = dietType;
        this.numLegs = numLegs;
        this.sound = sound;
    }
    @Override
    public void speak() {
        System.out.println(this.name + " says: " + this.sound);
    }
}
// 2. Try to extend Human – what happens and why?
//class Teacher extends Human {
    // It is not possible to inherit from human. The IDE states that we can't inherit from human because it is final.
    // This is because the purpose of the final keyword is to restrict a class from being inherited from.
//}

