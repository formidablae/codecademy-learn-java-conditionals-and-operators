import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LETest {
  @Test
  public void regularTest() {
    Order testOrder = new Order(false, 72.50, "Regular", "ship50");
    double testResult = testOrder.calculateShipping();
    double expected = 0.0;
    assertEquals("When we called the `calculateShipping()` method on a `\"Regular\"` order, we expected to get `0.0`, but we got `" + testResult +"`",testResult,expected, 1e-15);
  }
  
  @Test
  public void ExpressCouponTest() {
    Order testOrder = new Order(false, 72.50, "Express", "ship50");
    double testResult = testOrder.calculateShipping();
    double expected = 0.85;
    assertEquals("When we called the `calculateShipping()` method on an `\"Express\"` order using the `\"ship50\"` coupon, we expected to get `0.85`, but we got `" + testResult +"`",testResult,expected, 1e-15);
  }
  
  @Test
  public void ExpressNoCouponTest() {
    Order testOrder = new Order(false, 72.50, "Express", "freeShipping");
    double testResult = testOrder.calculateShipping();
    double expected = 1.75;
    assertEquals("When we called the `calculateShipping()` method on an `\"Express\"` order without using the `\"ship50\"` coupon, we expected to get `1.75`, but we got `" + testResult +"`",testResult,expected, 1e-15);
  }
  
    @Test
  public void OtherShippingTest() {
    Order testOrder = new Order(false, 72.50, "OtherShipping", "freeShipping");
    double testResult = testOrder.calculateShipping();
    double expected = 0.5;
    assertEquals("When we called the `calculateShipping()` method on an order that was did not specify `\"Express\"` or `\"Regular\"` shipping, we expected to get `0.5`, but we got `" + testResult +"`",testResult,expected, 1e-15);
  }
}
