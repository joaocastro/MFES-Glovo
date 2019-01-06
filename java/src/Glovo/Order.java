package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Order {
  private String deliveryAddress = SeqUtil.toStr(SeqUtil.seq());
  private TimeStamp deliveryTime;
  private VDMSeq items = SeqUtil.seq();
  private User user;
  private Seller seller;
  private Object state = Glovo.quotes.waitingQuote.getInstance();
  private Driver driver;
  private Driver emptyDriver = new Driver("Null", "Null");

  public void cg_init_Order_1(
      final String orderDeliveryAddress,
      final TimeStamp orderDeliveryTime,
      final VDMSeq orderItems,
      final User orderUser,
      final Seller orderSeller) {

    deliveryAddress = orderDeliveryAddress;
    deliveryTime = Utils.copy(orderDeliveryTime);
    items = Utils.copy(orderItems);
    user = orderUser;
    seller = orderSeller;
    driver = emptyDriver;
    return;
  }

  public Order(
      final String orderDeliveryAddress,
      final TimeStamp orderDeliveryTime,
      final VDMSeq orderItems,
      final User orderUser,
      final Seller orderSeller) {

    cg_init_Order_1(
        orderDeliveryAddress,
        Utils.copy(orderDeliveryTime),
        Utils.copy(orderItems),
        orderUser,
        orderSeller);
  }

  public String getDeliveryAddress() {

    return deliveryAddress;
  }

  public Number getTotalPrice() {

    Number totalPrice = seller.getDeliveryPrice();
    for (Iterator iterator_17 = items.iterator(); iterator_17.hasNext(); ) {
      Item item = (Item) iterator_17.next();
      {
        totalPrice = totalPrice.doubleValue() + item.getPrice().doubleValue();
      }
    }
    return totalPrice;
  }

  public TimeStamp getDeliveryTime() {

    return Utils.copy(deliveryTime);
  }

  public VDMSeq getItems() {

    return Utils.copy(items);
  }

  public Seller getSeller() {

    return seller;
  }

  public User getUser() {

    return user;
  }

  public Object getState() {

    return state;
  }

  public Driver getDriver() {

    return driver;
  }

  public void startDelivery(final Driver assignee) {

    user.charge(getTotalPrice());
    driver = assignee;
    driver.makeDelivering();
    state = Glovo.quotes.deliveringQuote.getInstance();
  }

  public void finishDelivery() {

    driver.makeAvailable();
    state = Glovo.quotes.deliveredQuote.getInstance();
  }

  public Order() {}

  public String toString() {

    return "Order{"
        + "deliveryAddress := "
        + Utils.toString(deliveryAddress)
        + ", deliveryTime := "
        + Utils.toString(deliveryTime)
        + ", items := "
        + Utils.toString(items)
        + ", user := "
        + Utils.toString(user)
        + ", seller := "
        + Utils.toString(seller)
        + ", state := "
        + Utils.toString(state)
        + ", driver := "
        + Utils.toString(driver)
        + ", emptyDriver := "
        + Utils.toString(emptyDriver)
        + "}";
  }

  public static class TimeStamp implements Record {
    public Number minutes;
    public Number seconds;

    public TimeStamp(final Number _minutes, final Number _seconds) {

      minutes = _minutes;
      seconds = _seconds;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof TimeStamp)) {
        return false;
      }

      TimeStamp other = ((TimeStamp) obj);

      return (Utils.equals(minutes, other.minutes)) && (Utils.equals(seconds, other.seconds));
    }

    public int hashCode() {

      return Utils.hashCode(minutes, seconds);
    }

    public TimeStamp copy() {

      return new TimeStamp(minutes, seconds);
    }

    public String toString() {

      return "mk_Order`TimeStamp" + Utils.formatFields(minutes, seconds);
    }
  }
}
