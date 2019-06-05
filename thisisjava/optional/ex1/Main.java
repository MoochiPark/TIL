package io.wisoft.seminar.thisisjava.optional.ex1;

import java.util.Optional;

public class Main {

  public static String City(Order order) {
    return Optional.ofNullable(order).map(Order::getMembers)
        .map(Members::getAddress)
        .map(Address::getCity)
        .orElse("Seoul");
  }

  public static void main(String[] args) {

    Order order = new Order();
//    Order order = null;
    Members members = new Members();
    Address address = new Address();

    order.setMembers(members);
    members.setAddress(address);
    address.setCity("Tokyo");

    System.out.println(City(order));

  }

}

