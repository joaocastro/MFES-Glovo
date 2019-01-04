package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Restaurant extends Seller {
  private Object category;

  public void cg_init_Restaurant_2(
      final String restaurantName,
      final String restaurantDescription,
      final String restaurantAddress,
      final String restaurantCity,
      final Number restaurantDeliveryPrice,
      final Object restaurantCategory) {

    name = restaurantName;
    description = restaurantDescription;
    address = restaurantAddress;
    city = restaurantCity;
    deliveryPrice = restaurantDeliveryPrice;
    category = restaurantCategory;
    return;
  }

  public void cg_init_Restaurant_1() {

    return;
  }

  public Restaurant() {

    cg_init_Restaurant_1();
  }

  public Restaurant(
      final String restaurantName,
      final String restaurantDescription,
      final String restaurantAddress,
      final String restaurantCity,
      final Number restaurantDeliveryPrice,
      final Object restaurantCategory) {

    cg_init_Restaurant_2(
        restaurantName,
        restaurantDescription,
        restaurantAddress,
        restaurantCity,
        restaurantDeliveryPrice,
        restaurantCategory);
  }

  public Object getCategory() {

    return category;
  }

  public String toString() {

    return "Restaurant{" + "category := " + Utils.toString(category) + "}";
  }
}
