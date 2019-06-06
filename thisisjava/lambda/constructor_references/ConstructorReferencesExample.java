package io.wisoft.seminar.thisisjava.lambda.constructor_references;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {

  public static void main(String[] args) {
    Function<String, Members> function1 = Members::new;
    Members member1 = function1.apply("angel");

    BiFunction<String, String, Members> function2 = Members::new;
    Members member2 = function2.apply("신천사", "angel");
  }

}
