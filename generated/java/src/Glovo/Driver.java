package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Driver {
  private String name = SeqUtil.toStr(SeqUtil.seq());
  private String city = SeqUtil.toStr(SeqUtil.seq());
  private Object status = Glovo.quotes.availableQuote.getInstance();

  public void cg_init_Driver_1(final String driverName, final String driverCity) {

    name = driverName;
    city = driverCity;
    return;
  }

  public Driver(final String driverName, final String driverCity) {

    cg_init_Driver_1(driverName, driverCity);
  }

  public String getName() {

    return name;
  }

  public String getCity() {

    return city;
  }

  public Object getStatus() {

    return status;
  }

  public void makeAvailable() {

    status = Glovo.quotes.availableQuote.getInstance();
  }

  public void makeUnavailable() {

    status = Glovo.quotes.unavailableQuote.getInstance();
  }

  public void makeDelivering() {

    status = Glovo.quotes.deliveringQuote.getInstance();
  }

  public Driver() {}

  public String toString() {

    return "Driver{"
        + "name := "
        + Utils.toString(name)
        + ", city := "
        + Utils.toString(city)
        + ", status := "
        + Utils.toString(status)
        + "}";
  }
}
