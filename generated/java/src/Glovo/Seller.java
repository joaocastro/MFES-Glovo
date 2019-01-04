package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Seller {
  protected String name = SeqUtil.toStr(SeqUtil.seq());
  protected String description = SeqUtil.toStr(SeqUtil.seq());
  protected String address = SeqUtil.toStr(SeqUtil.seq());
  protected String city = SeqUtil.toStr(SeqUtil.seq());
  protected VDMSeq items = SeqUtil.seq();
  protected Number deliveryPrice = 0L;

  public void cg_init_Seller_2(
      final String sellerName,
      final String sellerDescription,
      final String sellerAddress,
      final String sellerCity,
      final Number sellerDeliveryPrice) {

    name = sellerName;
    description = sellerDescription;
    address = sellerAddress;
    city = sellerCity;
    deliveryPrice = sellerDeliveryPrice;
    return;
  }

  public void cg_init_Seller_1() {

    return;
  }

  public Seller() {

    cg_init_Seller_1();
  }

  public Seller(
      final String sellerName,
      final String sellerDescription,
      final String sellerAddress,
      final String sellerCity,
      final Number sellerDeliveryPrice) {

    cg_init_Seller_2(sellerName, sellerDescription, sellerAddress, sellerCity, sellerDeliveryPrice);
  }

  public String getName() {

    return name;
  }

  public String getDescription() {

    return description;
  }

  public String getAddress() {

    return address;
  }

  public String getCity() {

    return city;
  }

  public Number getDeliveryPrice() {

    return deliveryPrice;
  }

  public VDMSeq getItems() {

    return Utils.copy(items);
  }

  public void addItems(final VDMSeq newItems) {

    items = SeqUtil.conc(Utils.copy(items), Utils.copy(newItems));
  }

  public String toString() {

    return "Seller{"
        + "name := "
        + Utils.toString(name)
        + ", description := "
        + Utils.toString(description)
        + ", address := "
        + Utils.toString(address)
        + ", city := "
        + Utils.toString(city)
        + ", items := "
        + Utils.toString(items)
        + ", deliveryPrice := "
        + Utils.toString(deliveryPrice)
        + "}";
  }
}
