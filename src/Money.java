/**
 * This interface is a representation for amount of US money.
 */
public interface Money {

  /**
   * A functionality to add two money amounts.
   *
   * @param other value of second amount.
   * @return sum of two moneys
   * @throws IllegalArgumentException will throw an IllegalArgumentException for any invalid inputs.
   */
  Money add(Money other);


  /**
   * A functionality to add a money amount with another given as a separate dollar and cent value.
   *
   * @param dollars value of dollars amount
   * @param cents   value of cent amount.
   * @return sum of the money amount and amount provided as input.
   * @throws IllegalArgumentException will throw an IllegalArgumentException for any invalid inputs.
   */
  Money add(int dollars, int cents);

  /**
   * A functionality that returns the decimal value of the money in the format "xx.yy"
   *
   * @return decimal value of the money.
   */
  double getDecimalValue();

}
