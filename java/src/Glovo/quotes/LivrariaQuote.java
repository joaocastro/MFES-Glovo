package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LivrariaQuote {
  private static int hc = 0;
  private static LivrariaQuote instance = null;

  public LivrariaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static LivrariaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new LivrariaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof LivrariaQuote;
  }

  public String toString() {

    return "<Livraria>";
  }
}
