package Glovo;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  private String name = SeqUtil.toStr(SeqUtil.seq());
  private String city = SeqUtil.toStr(SeqUtil.seq());
  private Number balance = 0L;

  public void cg_init_User_1(final String userName, final String userCity) {

    name = userName;
    city = userCity;
    return;
  }

  public User(final String userName, final String userCity) {

    cg_init_User_1(userName, userCity);
  }

  public String getName() {

    return name;
  }

  public Number getBalance() {

    return balance;
  }

  public String getCity() {

    return city;
  }

  public void charge(final Number amount) {

    balance = balance.doubleValue() - amount.doubleValue();
  }

  public void deposit(final Number amount) {

    balance = balance.doubleValue() + amount.doubleValue();
  }

  public User() {}

  public String toString() {

    return "User{"
        + "name := "
        + Utils.toString(name)
        + ", city := "
        + Utils.toString(city)
        + ", balance := "
        + Utils.toString(balance)
        + "}";
  }
}
