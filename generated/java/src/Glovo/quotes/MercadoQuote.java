package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MercadoQuote {
  private static int hc = 0;
  private static MercadoQuote instance = null;

  public MercadoQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MercadoQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MercadoQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MercadoQuote;
  }

  public String toString() {

    return "<Mercado>";
  }
}
