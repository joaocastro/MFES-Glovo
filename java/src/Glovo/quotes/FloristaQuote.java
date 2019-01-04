package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FloristaQuote {
  private static int hc = 0;
  private static FloristaQuote instance = null;

  public FloristaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FloristaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FloristaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FloristaQuote;
  }

  public String toString() {

    return "<Florista>";
  }
}
