package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class waitingQuote {
  private static int hc = 0;
  private static waitingQuote instance = null;

  public waitingQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static waitingQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new waitingQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof waitingQuote;
  }

  public String toString() {

    return "<waiting>";
  }
}
