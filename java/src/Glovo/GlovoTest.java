package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GlovoTest {
  private Order.TimeStamp time = new Order.TimeStamp(5L, 10L);
  private Driver driTest1 = new Driver("Luis", "Porto");
  private User userTest1 = new User("Manuel", "Porto");
  private Item itemTest1 = new Item("Caneta", "Caneta para escrita", 1L);
  private VDMSeq items = SeqUtil.seq(itemTest1);
  private Restaurant restTest1 =
      new Restaurant(
          "McDonalds",
          "cadeia mundial de restaurantes de fast food",
          "Aliados",
          "Porto",
          5L,
          Glovo.quotes.Fast_FoodQuote.getInstance());
  private Store storeTest1 =
      new Store(
          "FNAC",
          "cadeia de lojas",
          "NorteShopping",
          "Porto",
          4L,
          Glovo.quotes.ElectronicaQuote.getInstance());
  private Seller sellerTest1 = new Seller("Rui", "Teste", "FEUP", "Porto", 4L);

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void assertFalse(final Boolean cond) {

    return;
  }

  private void assertEqual(final Object expected, final Object actual) {

    return;
  }

  private void testDriver() {

    throw new UnsupportedOperationException();
  }

  private void testUser() {

    throw new UnsupportedOperationException();
  }

  private void testItem() {

    throw new UnsupportedOperationException();
  }

  private void testRestaurant() {

    throw new UnsupportedOperationException();
  }

  private void testStore() {

    throw new UnsupportedOperationException();
  }

  private void testSeller() {

    throw new UnsupportedOperationException();
  }

  private void testOrder() {

    throw new UnsupportedOperationException();
  }

  public static void main() {

    new GlovoTest().testDriver();
    new GlovoTest().testUser();
    new GlovoTest().testItem();
    new GlovoTest().testRestaurant();
    new GlovoTest().testSeller();
    new GlovoTest().testStore();
    new GlovoTest().testOrder();
  }

  public GlovoTest() {}

  public String toString() {

    return "GlovoTest{"
        + "time := "
        + Utils.toString(time)
        + ", driTest1 := "
        + Utils.toString(driTest1)
        + ", userTest1 := "
        + Utils.toString(userTest1)
        + ", itemTest1 := "
        + Utils.toString(itemTest1)
        + ", items := "
        + Utils.toString(items)
        + ", restTest1 := "
        + Utils.toString(restTest1)
        + ", storeTest1 := "
        + Utils.toString(storeTest1)
        + ", sellerTest1 := "
        + Utils.toString(sellerTest1)
        + "}";
  }
}
