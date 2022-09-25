import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * This class represents SimpleMoney class test file.
 */


public class SimpleMoneyTest {

  private Money simpleMoney;
  Random random = new Random();

  int min = 0;
  int max = 1000;

  @Test
  public void testWhenInputsAreZero() {
    simpleMoney = new SimpleMoney(0, 0);
    SimpleMoney simpleMoney1 = new SimpleMoney(0, 0);
    simpleMoney.add(simpleMoney1);
    assertEquals("$0.00", simpleMoney1.toString());
  }

  @Test
  public void testNegativeInputs() {

    for (int i = 0; i < 1000; i++) {
      int dollars = -(random.nextInt(10000));
      int cents = (int) (Math.random() * (max - min + 1) + min);
      String expectedMessage = "Negative amount of money is not accepted.";
      String actualMessage = null;
      try {
        simpleMoney = new SimpleMoney(dollars, -cents);
      } catch (IllegalArgumentException e) {
        actualMessage = e.getMessage();
      }
      assertEquals(actualMessage, expectedMessage);
    }
  }

  @Test
  public void testAddWithPositiveInputs() {
    for (int i = 0; i < 1000; i++) {
      int dollars = random.nextInt(10000);
      int cents = (int) (Math.random() * (max - min + 1) + min);
      simpleMoney = new SimpleMoney(dollars, cents);
      int dollars1 = random.nextInt(10000);
      int cents1 = (int) (Math.random() * (max - min + 1) + min);
      SimpleMoney simpleMoney1 = new SimpleMoney(dollars1, cents1);
      simpleMoney = simpleMoney.add(simpleMoney1);
      assertEquals(testAddFunc(dollars, cents, dollars1, cents1).toString()
              , simpleMoney.toString());
    }
  }

  @Test
  public void testInputsMaxValues() {
    String expectedMessage = "Negative amount of money is not accepted.";
    String actualMessage = null;
    try {
      SimpleMoney simpleMoney1 = new SimpleMoney(Integer.MAX_VALUE, Integer.MAX_VALUE);
      SimpleMoney simpleMoney = new SimpleMoney(Integer.MAX_VALUE, Integer.MAX_VALUE);
      simpleMoney.add(simpleMoney1);
    } catch (IllegalArgumentException e) {
      actualMessage = e.getMessage();
    }
    assertEquals(actualMessage, expectedMessage);
  }


  @Test
  public void testGetDecimalValue() {
    for (int i = 0; i < 1000; i++) {
      int dollars = random.nextInt(10000);
      int cents = (int) (Math.random() * (max - min + 1) + min);
      simpleMoney = new SimpleMoney(dollars, cents);
      assertEquals(testGetDecimalValueFunc(dollars, cents), simpleMoney.getDecimalValue(), 0.001);
    }
  }

  @Test
  public void testToString() {
    for (int i = 0; i < 1000; i++) {
      int dollars = random.nextInt(10000);
      int cents = (int) (Math.random() * (max - min + 1) + min);
      simpleMoney = new SimpleMoney(dollars, cents);
      assertEquals(testToStringFunc(dollars, cents), simpleMoney.toString());
    }
  }

  private double testGetDecimalValueFunc(int dollars, int cents) {
    double cents1 = (double) cents / 100;
    return (dollars + cents1);
  }

  private String testToStringFunc(int dollars, int cents) {
    return String.format("$%.2f", testGetDecimalValueFunc(dollars, cents));
  }

  private Money testAddFunc(int d1, int c1, int d2, int c2) {
    int totalDollars = d1 + d2;
    int totalCents = c1 + c2;
    if (totalCents >= 100) {
      int n = totalCents / 100;
      totalCents = totalCents - n * 100;
      totalDollars = totalDollars + n;
    }
    return new SimpleMoney(totalDollars, totalCents);
  }
}
