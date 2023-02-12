import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
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
  public void invalidArgsLess() {
    String expected = "Invalid reservation!";
    Reservation rez = new Reservation(0, 12, false);
    assertThat("Does your code print `Invalid reservation!` if `count` is less than `1` or greater than `8`?", outContent.toString(), containsString(expected));
  }
  
  @Test
  public void invalidArgsMore() {
    String expected = "Invalid reservation!";
    Reservation rez = new Reservation(9, 12, false);
    assertThat("Does your code print `Invalid reservation!` if `count` is less than `1` or greater than `8`?", outContent.toString(), containsString(expected));
  }  

  
  @Test
  public void validArgs() {
    String expected = "";
    Reservation rez = new Reservation(2, 12, true);
    assertThat("Does your code not print anything if `count` is between `1` and `8`?", outContent.toString(), containsString(expected));
  }  
}
