package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class IndianaQuote {
  private static int hc = 0;
  private static IndianaQuote instance = null;

  public IndianaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static IndianaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new IndianaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof IndianaQuote;
  }

  public String toString() {

    return "<Indiana>";
  }
}
