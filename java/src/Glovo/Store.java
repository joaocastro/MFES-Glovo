package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Store extends Seller {
  private Object category;

  public void cg_init_Store_1(
      final String storeName,
      final String storeDescription,
      final String storeAddress,
      final String storeCity,
      final Number storeDeliveryPrice,
      final Object storeCategory) {

    name = storeName;
    description = storeDescription;
    address = storeAddress;
    city = storeCity;
    deliveryPrice = storeDeliveryPrice;
    category = storeCategory;
    return;
  }

  public Store(
      final String storeName,
      final String storeDescription,
      final String storeAddress,
      final String storeCity,
      final Number storeDeliveryPrice,
      final Object storeCategory) {

    cg_init_Store_1(
        storeName, storeDescription, storeAddress, storeCity, storeDeliveryPrice, storeCategory);
  }

  public Object getCategory() {

    return category;
  }

  public Store() {}

  public String toString() {

    return "Store{" + "category := " + Utils.toString(category) + "}";
  }
}
