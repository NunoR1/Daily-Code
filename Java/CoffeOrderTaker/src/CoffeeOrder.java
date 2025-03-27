public class CoffeeOrder {
    // Change the class name to CoffeeOrder

    // Create instance variables:
    // - size (String)
    // - type (String)
    // - orderID (String, make this one private)
    String size;
    String type;
    private String orderID;

    // Add a static int variable called totalOrders
    static int totalOrders;

    // Create a no-arg constructor
    // Set size to "medium" and type to "black"
    // Increment totalOrders
    CoffeeOrder() {
        size = "medium";
        type = "black";
        totalOrders++;
    }

    // Create a constructor that takes a size only
    // Set type to "black" by default
    // Increment totalOrders
    CoffeeOrder(String size) {
        this.size = size;
        type = "black";
        totalOrders++;
    }

    // Create a constructor that takes size and type
    // Increment totalOrders
    CoffeeOrder(String size, String type) {
        this.size = size;
        this.type = type;
        totalOrders++;
    }

    // Create a method describeOrder() that returns
    // something like "Order: medium black"
    String describeOrder() {
        return "Order: " + size + " " + type;
    }

    // Add a static method getTotalOrders() to return totalOrders
    static int getTotalOrders() {
        return totalOrders;
    }
}
