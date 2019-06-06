package io.wisoft.seminar.thisisjava.lambda.supplier_functional_interface;
import java.util.function.IntSupplier;

public class SupplerExample {

  public static void main(String[] args) {
    IntSupplier intSupplier = () -> {
      int num = (int) (Math.random() * 6) + 1;
      return num;
    };

    int num = intSupplier.getAsInt();
    System.out.println("눈의 수: " + num);
  }

}
