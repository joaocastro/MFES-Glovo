package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Item {
  private String name = SeqUtil.toStr(SeqUtil.seq());
  private String info = SeqUtil.toStr(SeqUtil.seq());
  private Number price;

  public void cg_init_Item_1(final String itemName, final String itemInfo, final Number itemPrice) {

    name = itemName;
    info = itemInfo;
    price = itemPrice;
    return;
  }

  public Item(final String itemName, final String itemInfo, final Number itemPrice) {

    cg_init_Item_1(itemName, itemInfo, itemPrice);
  }

  public String getName() {

    return name;
  }

  public String getInfo() {

    return info;
  }

  public Number getPrice() {

    return price;
  }

  public Item() {}

  public String toString() {

    return "Item{"
        + "name := "
        + Utils.toString(name)
        + ", info := "
        + Utils.toString(info)
        + ", price := "
        + Utils.toString(price)
        + "}";
  }
}
