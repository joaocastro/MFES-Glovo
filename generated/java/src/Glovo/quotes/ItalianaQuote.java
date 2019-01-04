package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ItalianaQuote {
  private static int hc = 0;
  private static ItalianaQuote instance = null;

  public ItalianaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ItalianaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ItalianaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ItalianaQuote;
  }

  public String toString() {

    return "<Italiana>";
  }
}
