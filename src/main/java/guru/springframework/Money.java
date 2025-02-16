package guru.springframework;

public class Money implements Expression {
  protected int amount;
  protected String currency;

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  protected String currency() {
    return currency;
  };

  public static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount && this.currency == money.currency;
  }

  @Override
  public Money reduce(Bank bank, String toCurrency) {
    // return this;
    // int rate = (currency.equals("CHF") && toCurrency.equals("USD")) ? 2 : 1;
    return new Money(amount / bank.rate(this.currency, toCurrency), toCurrency);
  }

  public Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  @Override
  public Expression plus(Expression addend) {
    // TODO Auto-generated method stub
    return new Sum(this, addend);
  }

  @Override
  public String toString() {
    return "Money [amount=" + amount + ", currency=" + currency + "]";
  }

}
