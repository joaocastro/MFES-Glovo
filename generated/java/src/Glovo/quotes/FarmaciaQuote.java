package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FarmaciaQuote {
  private static int hc = 0;
  private static FarmaciaQuote instance = null;

  public FarmaciaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FarmaciaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FarmaciaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FarmaciaQuote;
  }

  public String toString() {

    return "<Farmacia>";
  }
}
