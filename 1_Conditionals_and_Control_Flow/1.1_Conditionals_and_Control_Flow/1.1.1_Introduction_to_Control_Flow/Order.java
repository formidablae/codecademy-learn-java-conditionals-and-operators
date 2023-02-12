public class Order {
  String name;
  boolean isFilled;
  double billAmount
  
  public Order(String product, boolean filled, double cost) {
    name = product;
    isFilled = filled;
    billAmount = cost;
  }
  
  public double calculateShipping(int postalZone) {
    // conditional statement
    if (postalZone == 1) {
      return 4.22;
    } else if (postalZone == 2) {
      return 3.12;
    } else if (postalZone == 3) {
      return 2.77;
    } else {
      return 1.99;
    }
  }
  
  public static void main(String[] args) {
    Order book = new Order("Consider Phlebas", true);
    // conditional statement
    if (book.isFilled) {
      double cost = book.calculateShipping(2);
      System.out.println("Shipping cost: " + cost);
    } else {
      System.out.println("Order unfilled");
    }
  }
}
