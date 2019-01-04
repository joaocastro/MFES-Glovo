package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RoupaQuote {
  private static int hc = 0;
  private static RoupaQuote instance = null;

  public RoupaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static RoupaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new RoupaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof RoupaQuote;
  }

  public String toString() {

    return "<Roupa>";
  }
}
