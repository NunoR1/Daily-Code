public class JAVAFizzBuzz {
  public static void main(String args[]) {
      int x = 3;
      int y = 5;
      int z = 15;
      FizzBuzz(x);
      FizzBuzz(y);
      FizzBuzz(z);
  }
  
  static void FizzBuzz(Integer num) {
    if (num % 15 == 0) {
        System.out.println("FizzBuzz");
    } else if (num % 5 == 0) {
        System.out.println("Buzz");
    } else if (num % 3 == 0) {
        System.out.println("Fizz");
    } else {
        System.out.println("BuzzFizz");
    }
  }
}
