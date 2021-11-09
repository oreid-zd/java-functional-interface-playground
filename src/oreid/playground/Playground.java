package oreid.playground;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Playground {

  public static void main(String[] args) {
    executeFunction();
    executeSupplier();
    executeConsumer();
    executePredicate();
    executeOperator();
    executePrimitiveFunction();
    executeTwoArityFunction();
  }

  public static void executeFunction() {
    Function<String, Integer> strLength = s -> Integer.valueOf(s.length());
    final var result = strLength.apply("Four");
    print("Function", result);
  }

  public static void executeSupplier() {
    Supplier<Double> getPi = () -> Double.valueOf(Math.PI);
    final var result = getPi.get();
    print("Supplier", result);
  }

  public static void executeConsumer() {
    Consumer<String> printUpperCase = s -> print("Consumer", s.toUpperCase());
    printUpperCase.accept("camelCase");
  }

  public static void executePredicate() {
    Predicate<String> greaterThanThree = s -> s.length() > 3;
    final var result = greaterThanThree.test("four");
    print("Predicate", result);
  }

  public static void executeOperator() {
    UnaryOperator<String> toLowerCase = s -> s.toLowerCase();
    final var result = toLowerCase.apply("camelCase");
    print("Operator", result);
  }

  public static void executePrimitiveFunction() {
    IntFunction<Double> halfDouble = i -> i / 2.0;
    final var result = halfDouble.apply(10);
    print("IntFunction", result);
  }

  public static void executeTwoArityFunction() {
    BiFunction<Integer, Double, String> joinNums = (i, d) -> String.format("I: %d, D: %f", i, d);
    final var result = joinNums.apply(10, 150.0);
    print("BiFunction", result);
  }

  public static <T> void print(String prefix, T value) {
    System.out.println(String.format("%s: %s", prefix, value));
  }

}
