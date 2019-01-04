package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ChurrascoQuote {
  private static int hc = 0;
  private static ChurrascoQuote instance = null;

  public ChurrascoQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ChurrascoQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ChurrascoQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ChurrascoQuote;
  }

  public String toString() {

    return "<Churrasco>";
  }
}
