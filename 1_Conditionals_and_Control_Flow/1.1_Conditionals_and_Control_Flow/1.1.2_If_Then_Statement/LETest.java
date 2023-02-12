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
    String expected = "High value item!";
    Order highOrder = new Order(false, 36.00);
    assertThat("Does your code print `High value item!` when orders over 24.00 are created?", outContent.toString(), containsString(expected));
  }
  
  @Test
  public void conditionalFalseTest() {
    String expected = "High value item!";
    Order lowOrder = new Order(true, 9.00);
    assertTrue("Does your code print nothing when a low value item is created?", !outContent.toString().contains(expected));
  }      
}
