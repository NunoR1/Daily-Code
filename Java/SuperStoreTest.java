// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
class Product {
    // The first two fields are protected because every subsequent class that inherits from this one is going to have
    // them. They will probably be viewed and used the most within this class family and nowhere else, so this is the
    // most fitting modifier.
    protected String name;
    protected double price;
    private final int productId; // A product's ID usually only matters in the backend, so it is probably better to keep
                                 // it private
    public static int nextId = 0; // I actually don't know. Probably because it makes it easier to check its current
                                  // value when running diagnostics on the class. It is also static so it could very
                                  // well be more useful to not encapsulate it.

    public Product(String name, double price) { // All the constructors of this program are public because they are
                                                // required outside the class to construct an instance of the class
        this.name = name;
        this.price = price;
        productId = nextId;
        nextId++;
    }

    public Product(String name, double price, int productId) {
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    // All the getter methods and the toString methods are public because they are the only way for program outside of
    // this class to get access to the information of the classes' instances
    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getNextId() {
        return this.nextId;
    }

    @Override
    public String toString() {
        return "Item Name: " + this.name +
                "\nItem Price: $" + this.price +
                "\nItem ID: " + this.productId;
    }

    @Override
    public boolean equals(Object o) { // Public because this method can only be useful outside the class
       return (this.name.equals(((Product)o).name)) && (this.productId == ((Product)o).productId);
    }
}
// - A protected String field called name
// - A protected double field called price
// - A private final int productId
// - A public static int nextId to help generate unique IDs
// - A constructor that sets name, price, and assigns a unique ID
// - Public getters for all fields
// - Override toString() to return formatted product details
// - Override equals(Object o) to compare name and productId

// TODO: Define a subclass Electronics that extends Product
class Electronics extends Product {
    // Both of these are private because there is a method that returns this information in a formatted manner
    private String brand;
    private boolean hasBattery;

    public Electronics(String name, double price, String brand, boolean hasBattery) {
        super(name, price);
        this.brand = brand;
        this.hasBattery = hasBattery;
    }

    private final void warrantyInfo() {
        System.out.println("Info on your warranty");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBrand: " + this.brand +
                ((hasBattery) ? "\nHas battery" : "\nDoesn't have battery");
    }
}
// - Add a private String field called brand
// - Add a private boolean field called hasBattery
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include brand and battery status

// TODO: Define a subclass Grocery that extends Product
class Grocery extends Product {
    // Both of these are private because there is a method that returns this information in a formatted manner
    private double weight;
    private boolean isPerishable;

    public Grocery(String name, double price, double weight, boolean isPerishable) {
        super(name, price);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    public Grocery(String name, double price, int productId, double weight, boolean isPerishable) {
        super(name, price, productId);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeight (in kg): " + this.weight +
                ((isPerishable) ? "\nIs perishable" : "\nIsn't perishable");
    }
}
// - Add a private double field called weight (in kg)
// - Add a private boolean field called isPerishable
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include weight and perishability

// TODO: Define a final class Toy that extends Product
final class Toy extends Product { // Final because this is probably the deepest this branch of inheritance needs to go,
                                  // there isn't any more information required for toys
    private int minAge; // private because there is a method that returns this information in a formatted manner

    public Toy(String name, double price, int minAge) {
        super(name, price);
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMinimum age: " + this.minAge + " years old";
    }
}
// - Add a private int field called minAge
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include minAge

// TODO: Define class SuperStoreTest with a main method
public class SuperStoreTest { // public because it includes out main function
    public static void main(String[] args) {
        Product p1 = new Product("Lightbulbs", 6);
        Product p2 = new Product("Lightbulbs", 6, 0);
        Electronics e1 = new Electronics("IPad", 400000, "Apple", true);
        Grocery g1 = new Grocery("Banana", .30, 400, true);
        Grocery g2 = new Grocery("Banana", .30, 2, 400, true);
        Toy t1 = new Toy("Lego Tuxedo Cat", 99.99, 18);
        Product[] products = {p1, e1, g1, t1};

        for (Product product : products) {
            System.out.println(product);
            System.out.println();
        }

        System.out.println(p1.equals(p2));
        System.out.println(g1.equals(g2));
    }
}

class Coupon {
    final double discountRate; // private because there is a method that returns this information in a formatted manner

    public Coupon(Product p, double discountRate) {
        this.discountRate = discountRate;
        System.out.println("The final price of " + p.getName() + " after this discount is $" + (p.getPrice() * this.discountRate));
    }
}
// - Create at least one instance of each subclass
// - Store them in a Product[] array
// - Loop through and print each item
// - Call equals() to compare two products with the same ID and name

//class Legos extends Toy {

// I am not able to extend from Toy, because it uses the final modifier. This modifier indicates that a class cannot be
// extended from.

//}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
// 2. Make a class Coupon with a final discountRate and apply it to a Product
// 3. Add a method to Electronics called warrantyInfo() and mark it final
// 4. Use access modifiers appropriately and explain your choices in comments
