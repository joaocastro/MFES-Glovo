package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class deliveredQuote {
  private static int hc = 0;
  private static deliveredQuote instance = null;

  public deliveredQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static deliveredQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new deliveredQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof deliveredQuote;
  }

  public String toString() {

    return "<delivered>";
  }
}
