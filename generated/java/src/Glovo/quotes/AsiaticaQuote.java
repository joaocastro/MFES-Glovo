package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AsiaticaQuote {
  private static int hc = 0;
  private static AsiaticaQuote instance = null;

  public AsiaticaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AsiaticaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AsiaticaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AsiaticaQuote;
  }

  public String toString() {

    return "<Asiatica>";
  }
}
