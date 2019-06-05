package io.wisoft.seminar.thisisjava.optional.ex2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {

  public static <T>Optional<T> getAsOptional(List<T> list, int index) {
    try {
      return Optional.of(list.get(index));
    } catch (ArrayIndexOutOfBoundsException e) {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {

    List<String> list = Arrays.asList("박대원", "한현구", "구아람");

    System.out.println(getAsOptional(list, 2));

    List<String> cities = Arrays.asList("서울", "대구", "부산");

    Optional<String> maybeCity = getAsOptional(cities, 2);

    int lenth = maybeCity.map(String::length).orElse(0);
    System.out.println("length: " + lenth);
    System.out.println(getAsOptional(cities, 2));
  }

}
