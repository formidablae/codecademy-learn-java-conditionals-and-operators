import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.containsString;

public class LETest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void conditionalTrueTest() {
    String expected = "Shipping";
    Order filledOrder = new Order(true, 36.00);
    filledOrder.ship();
    assertThat("Does your program print `Shipping` using an `if-then-else` conditional when the `Order` instance `isFilled` field is `true`?", outContent.toString(), containsString(expected));
  }
  
  @Test
  public void conditionalFalseTest() {
    String expected = "Order not ready";
    Order unfilledOrder = new Order(false, 9.00);
    unfilledOrder.ship();
    assertThat("Does your program print `Order not ready` using an `if-then-else` conditional when the `Order` instance `isFilled` field is `false`?", outContent.toString(), containsString(expected));  
  }      
}
