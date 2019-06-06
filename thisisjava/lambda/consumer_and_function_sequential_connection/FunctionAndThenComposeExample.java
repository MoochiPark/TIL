package io.wisoft.seminar.thisisjava.lambda.consumer_and_function_sequential_connection;

import java.util.function.Function;

public class FunctionAndThenComposeExample {

  public static void main(String[] args) {
    Function<Members, Address> functionA;
    Function<Address, String> functionB;
    Function<Members, String> functionAB;
    String city;

    functionA = m -> m.getAddress();
    functionB = a -> a.getCity();

    functionAB = functionA.andThen(functionB);
    city = functionAB.apply(
        new Members("홍길동", "hong", new Address("한국", "서울"))
    );
    System.out.println("거주 도시: " + city);

    functionAB = functionB.compose(functionA);
    city = functionAB.apply(
        new Members("홍길동", "hong", new Address("한국", "부산"))
    );
    System.out.println("거주 도시: " + city);
  }

}
