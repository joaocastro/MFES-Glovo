package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Fast_FoodQuote {
  private static int hc = 0;
  private static Fast_FoodQuote instance = null;

  public Fast_FoodQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static Fast_FoodQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new Fast_FoodQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof Fast_FoodQuote;
  }

  public String toString() {

    return "<Fast_Food>";
  }
}
