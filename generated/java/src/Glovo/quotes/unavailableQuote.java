package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class unavailableQuote {
  private static int hc = 0;
  private static unavailableQuote instance = null;

  public unavailableQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static unavailableQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new unavailableQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof unavailableQuote;
  }

  public String toString() {

    return "<unavailable>";
  }
}
