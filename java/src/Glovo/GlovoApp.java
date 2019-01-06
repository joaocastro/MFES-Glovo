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

  public Seller getSellerByName(final String name) {

    for (Iterator iterator_9 = sellers.iterator(); iterator_9.hasNext(); ) {
      Seller seller = (Seller) iterator_9.next();
      {
        if (Utils.equals(seller.getName(), name)) {
          return seller;
        }
      }
    }
    return new Seller();
  }

  public VDMSeq getDrivers() {

    return Utils.copy(drivers);
  }

  public VDMSeq getAvailableDriversByCity(final String city) {

    VDMSeq availableDrivers = SeqUtil.seq();
    for (Iterator iterator_10 = drivers.iterator(); iterator_10.hasNext(); ) {
      Driver driver = (Driver) iterator_10.next();
      Boolean andResult_2 = false;

      if (Utils.equals(driver.getStatus(), Glovo.quotes.availableQuote.getInstance())) {
        if (Utils.equals(driver.getCity(), city)) {
          andResult_2 = true;
        }
      }

      if (andResult_2) {
        availableDrivers = SeqUtil.conc(Utils.copy(availableDrivers), SeqUtil.seq(driver));
      }
    }
    return Utils.copy(availableDrivers);
  }

  public VDMSeq getUsers() {

    return Utils.copy(users);
  }

  public User getUserByName(final String name) {

    for (Iterator iterator_11 = users.iterator(); iterator_11.hasNext(); ) {
      User user = (User) iterator_11.next();
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

  public VDMSeq getWaitingOrders() {

    VDMSeq waitingOrders = SeqUtil.seq();
    for (Iterator iterator_12 = orders.iterator(); iterator_12.hasNext(); ) {
      Order order = (Order) iterator_12.next();
      {
        if (Utils.equals(order.getState(), Glovo.quotes.waitingQuote.getInstance())) {
          waitingOrders = SeqUtil.conc(Utils.copy(waitingOrders), SeqUtil.seq(order));
        }
      }
    }
    return Utils.copy(waitingOrders);
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

  public Boolean addOrder(final Order order) {

    VDMSeq availableDrivers = null;
    orders = SeqUtil.conc(Utils.copy(orders), SeqUtil.seq(order));
    availableDrivers = getAvailableDriversByCity(order.getUser().getCity());
    if (availableDrivers.size() > 0L) {
      order.startDelivery(((Driver) availableDrivers.get(0)));
      return true;
    }

    return false;
  }

  public Order triggerWaitingOrder() {

    Order order = null;
    VDMSeq availableDrivers = null;
    if (getWaitingOrders().size() > 0L) {
      order = ((Order) getWaitingOrders().get(0));
      availableDrivers = getAvailableDriversByCity(order.getUser().getCity());
      if (availableDrivers.size() > 0L) {
        order.startDelivery(((Driver) availableDrivers.get(0)));
      }
    }

    return order;
  }

  public void addItemToSeller(final String sellerName, final Item item) {

    for (Iterator iterator_13 = sellers.iterator(); iterator_13.hasNext(); ) {
      Seller seller = (Seller) iterator_13.next();
      {
        if (Utils.equals(seller.getName(), sellerName)) {
          seller.addItem(item);
        }
      }
    }
  }

  public VDMSeq getRestaurantsByCity(final String city) {

    VDMSeq restaurants = SeqUtil.seq();
    for (Iterator iterator_14 = sellers.iterator(); iterator_14.hasNext(); ) {
      Seller seller = (Seller) iterator_14.next();
      Boolean andResult_4 = false;

      if (Utils.is_(seller, Restaurant.class)) {
        if (Utils.equals(seller.getCity(), city)) {
          andResult_4 = true;
        }
      }

      if (andResult_4) {
        restaurants = SeqUtil.conc(Utils.copy(restaurants), SeqUtil.seq(seller));
      }
    }
    return Utils.copy(restaurants);
  }

  public VDMSeq getStoresByCity(final String city) {

    VDMSeq stores = SeqUtil.seq();
    for (Iterator iterator_15 = sellers.iterator(); iterator_15.hasNext(); ) {
      Seller seller = (Seller) iterator_15.next();
      Boolean andResult_5 = false;

      if (Utils.is_(seller, Store.class)) {
        if (Utils.equals(seller.getCity(), city)) {
          andResult_5 = true;
        }
      }

      if (andResult_5) {
        stores = SeqUtil.conc(Utils.copy(stores), SeqUtil.seq(seller));
      }
    }
    return Utils.copy(stores);
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
