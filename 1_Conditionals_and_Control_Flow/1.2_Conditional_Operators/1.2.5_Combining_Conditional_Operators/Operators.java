public class Operators {
  public static void main(String[] args) {
    int a = 6;
    int b = 3;

    boolean ex1 = !(a == 7 && (b >= a || a != a));
    System.out.println(ex1);

    boolean ex2 = a == b || !(b > 3);
    System.out.println(ex2);

    boolean ex3 = !(b <= a && b != a + b);
    System.out.println(ex3); 

  }
}
