package io.wisoft.seminar.thisisjava.lambda.consumer_and_function_sequential_connection;

import java.util.function.Consumer;

public class ConsumerAndThenExample {

  public static void main(String[] args) {
    Consumer<Members> consumerA = m -> {
      System.out.println("consumerA: " + m.getName());
    };

    Consumer<Members> consumerB = m -> {
      System.out.println("consumerB: " + m.getId());
    };

    Consumer<Members> consumerAB = consumerA.andThen(consumerB);
    consumerAB.accept(new Members("홍길동", "hong", null));
  }

}
