package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JaponesaQuote {
  private static int hc = 0;
  private static JaponesaQuote instance = null;

  public JaponesaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static JaponesaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new JaponesaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof JaponesaQuote;
  }

  public String toString() {

    return "<Japonesa>";
  }
}
