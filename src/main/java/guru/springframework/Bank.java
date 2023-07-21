package guru.springframework;

import java.util.HashMap;

public class Bank {
  private HashMap<Pair, Integer> rateMap = new HashMap<>();
  Money reduce(Expression source, String toCurrency) {
    return source.reduce(this, toCurrency);
  }

  public int rate(String from, String toCurrency) {
    if (from.equals(toCurrency)) return 1;
    return rateMap.get(new Pair(from, toCurrency));
  }

  public void addRate(String from, String toCurrency, int rate) {
    rateMap.put(new Pair(from, toCurrency), rate);
  }
}
