package guru.springframework;

public class Sum implements Expression {
  Expression augmend;
  Expression addmend;

  public Sum(Expression augmend, Expression addmend) {
    this.augmend = augmend;
    this.addmend = addmend;
  }

  @Override
  public Money reduce(Bank bank, String toCurrency) {
    int amount = augmend.reduce(bank, toCurrency).amount + addmend.reduce(bank, toCurrency).amount;
    return new Money(amount, toCurrency);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  @Override
  public Expression times(int multiplier) {
    return new Sum(augmend.times(multiplier), addmend.times(multiplier));
  }
}
