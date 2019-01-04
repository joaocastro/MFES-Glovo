package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GlovoApp {
  private VDMSeq sellers = SeqUtil.seq();
  private VDMSeq drivers = SeqUtil.seq();
  private VDMSeq users = SeqUtil.seq();
  private VDMSeq orders = SeqUtil.seq();

  public VDMSeq getSellers() {

    return Utils.copy(sellers);
  }

  public VDMSeq getDrivers() {

    return Utils.copy(drivers);
  }

  public VDMSeq getAvailableDrivers() {

    VDMSeq availableDrivers = SeqUtil.seq();
    for (Iterator iterator_6 = drivers.iterator(); iterator_6.hasNext(); ) {
      Driver driver = (Driver) iterator_6.next();
      {
        if (Utils.equals(driver.getStatus(), Glovo.quotes.availableQuote.getInstance())) {
          availableDrivers = SeqUtil.conc(Utils.copy(availableDrivers), SeqUtil.seq(driver));
        }
      }
    }
    return Utils.copy(availableDrivers);
  }

  public VDMSeq getUsers() {

    return Utils.copy(users);
  }

  public VDMSeq getOrders() {

    return Utils.copy(orders);
  }

  public void addSeller(final Seller newSeller) {

    sellers = SeqUtil.conc(Utils.copy(sellers), SeqUtil.seq(newSeller));
  }

  public void addDriver(final Driver newDriver) {

    drivers = SeqUtil.conc(Utils.copy(drivers), SeqUtil.seq(newDriver));
  }

  public void registerUser(final User newUser) {

    users = SeqUtil.conc(Utils.copy(users), SeqUtil.seq(newUser));
  }

  public void addOrder(final Order order) {

    VDMSeq availableDrivers = null;
    orders = SeqUtil.conc(Utils.copy(orders), SeqUtil.seq(order));
    availableDrivers = getAvailableDrivers();
    if (availableDrivers.size() > 0L) {
      order.startDelivery(((Driver) availableDrivers.get(0)));
    }
  }

  public GlovoApp() {}

  public String toString() {

    return "GlovoApp{"
        + "sellers := "
        + Utils.toString(sellers)
        + ", drivers := "
        + Utils.toString(drivers)
        + ", users := "
        + Utils.toString(users)
        + ", orders := "
        + Utils.toString(orders)
        + "}";
  }
}
