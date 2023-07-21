package guru.springframework;

public interface Expression {
  Money reduce(Bank bank, String toCurrency);

  public Expression plus(Expression addend);

  Expression times(int multiplier);
}
