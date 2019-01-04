package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PortuguesaQuote {
  private static int hc = 0;
  private static PortuguesaQuote instance = null;

  public PortuguesaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PortuguesaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PortuguesaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PortuguesaQuote;
  }

  public String toString() {

    return "<Portuguesa>";
  }
}
