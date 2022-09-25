
/**
 * This is the class representation of the interface Money
 * and implements some functionalities for it.
 */

public class SimpleMoney implements Money {

  private final int dollars;
  private final int cents;

  /**
   * Constructs a SimpleMoney object and initializes the given money in dollars in cents.
   *
   * @param dollars value of money in dollars.
   * @param cents   value of money in cents.
   * @throws IllegalArgumentException will throw an IllegalArgumentException for any invalid inputs.
   */
  public SimpleMoney(int dollars, int cents) throws IllegalArgumentException {
    validateInputs(dollars, cents);
    if (cents >= 100) {
      int n = cents / 100;
      this.cents = cents - n * 100;
      this.dollars = dollars + n;
    } else {
      this.dollars = dollars;
      this.cents = cents;
    }
  }


  @Override
  public Money add(Money other) throws IllegalArgumentException {
    if (other == null) {
      throw new IllegalArgumentException("Money value is null");
    } else if (other.getDecimalValue() < 0) {
      throw new IllegalArgumentException("Negative amount of money is not accepted.");
    }
    return other.add(this.dollars, this.cents);
  }

  @Override
  public Money add(int dollars, int cents) throws IllegalArgumentException {
    validateInputs(dollars, cents);
    int totalDollars = this.dollars + dollars;
    int totalCents = this.cents + cents;
    if (totalCents >= 100) {
      int n = totalCents / 100;
      totalCents = totalCents - n * 100;
      totalDollars = totalDollars + n;
    }
    return new SimpleMoney(totalDollars, totalCents);
  }

  @Override
  public double getDecimalValue() {
    double cents = (double) this.cents / 100;
    return (this.dollars + cents);
  }

  /**
   * A functionality that returns the money in string format.
   *
   * @return returns a string of the form "$xx.yy"
   */

  @Override
  public String toString() {
    return String.format("$%.2f", getDecimalValue());
  }

  private void validateInputs(int dollars, int cents) {
    if (dollars < 0 || cents < 0) {
      throw new IllegalArgumentException("Negative amount of money is not accepted.");
    }
  }
}
