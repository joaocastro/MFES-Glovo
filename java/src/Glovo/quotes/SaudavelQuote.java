package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SaudavelQuote {
  private static int hc = 0;
  private static SaudavelQuote instance = null;

  public SaudavelQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SaudavelQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SaudavelQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SaudavelQuote;
  }

  public String toString() {

    return "<Saudavel>";
  }
}
