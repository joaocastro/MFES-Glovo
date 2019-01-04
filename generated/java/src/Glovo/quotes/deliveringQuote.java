package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class deliveringQuote {
  private static int hc = 0;
  private static deliveringQuote instance = null;

  public deliveringQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static deliveringQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new deliveringQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof deliveringQuote;
  }

  public String toString() {

    return "<delivering>";
  }
}
