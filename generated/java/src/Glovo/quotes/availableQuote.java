package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class availableQuote {
  private static int hc = 0;
  private static availableQuote instance = null;

  public availableQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static availableQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new availableQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof availableQuote;
  }

  public String toString() {

    return "<available>";
  }
}
