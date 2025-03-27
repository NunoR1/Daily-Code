public class CoffeeShop {
    // Change the class name to CoffeeShop

    public static void main(String[] args) {
        // Create three CoffeeOrder objects
        // Use a different constructor each time
        CoffeeOrder coffee1 = new CoffeeOrder();

        CoffeeOrder coffee2 = new CoffeeOrder("large");

        CoffeeOrder coffee3 = new CoffeeOrder("small", "mocha");

        // Call describeOrder() on each and print the result
        System.out.println(coffee1.describeOrder());
        System.out.println(coffee2.describeOrder());
        System.out.println(coffee3.describeOrder());

        // Print the total number of orders using
        System.out.println(CoffeeOrder.getTotalOrders());
    }
}