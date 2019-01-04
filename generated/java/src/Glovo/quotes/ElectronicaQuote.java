package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ElectronicaQuote {
  private static int hc = 0;
  private static ElectronicaQuote instance = null;

  public ElectronicaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ElectronicaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ElectronicaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ElectronicaQuote;
  }

  public String toString() {

    return "<Electronica>";
  }
}
