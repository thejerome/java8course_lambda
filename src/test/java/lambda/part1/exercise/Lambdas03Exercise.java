package lambda.part1.exercise;

import static org.junit.Assert.assertEquals;

import java.util.StringJoiner;
import org.junit.Test;

public class Lambdas03Exercise {

  private final String delimeter = "-";

  private static String stringProd(String s, int i) {
    final StringBuilder sb = new StringBuilder();
    for (int j = 0; j < i; j++) {
      sb.append(s);
    }
    return sb.toString();
  }

  @Test
  public void generic0() {
    final GenericProduct<Integer> prod = new GenericProduct<Integer>() {
      @Override
      public Integer prod(Integer a, int i) {
        return a * i;
      }
    }; // Use anonymous class

    assertEquals(prod.prod(3, 2), Integer.valueOf(6));
  }

  @Test
  public void generic1() {
    final GenericProduct<Integer> prod = null; // Use statement lambda

    assertEquals(prod.prod(3, 2), Integer.valueOf(6));
  }

  @Test
  public void generic2() {
    final GenericProduct<Integer> prod = null; // Use expression lambda

    assertEquals(prod.prod(3, 2), Integer.valueOf(6));
  }

  @Test
  public void strSum() {
    final GenericProduct<String> prod = Lambdas03Exercise::stringProd; // use stringProd;

    assertEquals(prod.prod("a", 2), "aa");
  }

  private String stringSumWithDelimeter(String s, int i) {
    final StringJoiner sj = new StringJoiner(delimeter);
    for (int j = 0; j < i; j++) {
      sj.add(s);
    }
    return sj.toString();
  }

  @Test
  public void strSum2() {
    final GenericProduct<String> prod = this::stringSumWithDelimeter; // use stringSumWithDelimeter;

    assertEquals(prod.prod("a", 3), "a-a-a");
  }

  private interface GenericProduct<T> {

    T prod(T a, int i);

    default T twice(T t) {
      return prod(t, 2);
    }
  }
}