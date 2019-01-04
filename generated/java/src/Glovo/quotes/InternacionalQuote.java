package Glovo.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class InternacionalQuote {
  private static int hc = 0;
  private static InternacionalQuote instance = null;

  public InternacionalQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static InternacionalQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new InternacionalQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof InternacionalQuote;
  }

  public String toString() {

    return "<Internacional>";
  }
}
