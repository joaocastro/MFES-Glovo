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
    for (Iterator iterator_7 = drivers.iterator(); iterator_7.hasNext(); ) {
      Driver driver = (Driver) iterator_7.next();
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

  public User getUserByName(final String name) {

    for (Iterator iterator_8 = users.iterator(); iterator_8.hasNext(); ) {
      User user = (User) iterator_8.next();
      {
        if (Utils.equals(user.getName(), name)) {
          return user;
        }
      }
    }
    return new User();
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

  public void addItemToSeller(final String sellerName, final Item item) {

    for (Iterator iterator_9 = sellers.iterator(); iterator_9.hasNext(); ) {
      Seller seller = (Seller) iterator_9.next();
      {
        if (Utils.equals(seller.getName(), sellerName)) {
          seller.addItem(item);
        }
      }
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
