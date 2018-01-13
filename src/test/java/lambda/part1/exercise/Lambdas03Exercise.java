package lambda.part1.exercise;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class Lambdas03Exercise {

    private interface GenericProduct<T> {
        T prod(T a, int i);

        default T twice(T t) {
            return prod(t, 2);
        }
    }

    // Use anonymous class
    @Test
    public void generic0() {
        final GenericProduct<Integer> prod = new GenericProduct<Integer>() {

            @Override
            public Integer prod(Integer a, int i) {
                return a * i;
            }
        };

        assertEquals(prod.prod(3, 2), Integer.valueOf(6));
    }

    // Use statement lambda
    @Test
    public void generic1() {
        final GenericProduct<Integer> prod = (h, i) -> h * i;

        assertEquals(prod.prod(3, 2), Integer.valueOf(6));
    }

    // Use expression lambda
    @Test
    public void generic2() {
        final GenericProduct<Integer> prod = (h, i) -> {
            return h * i;
        };

        assertEquals(prod.prod(3, 2), Integer.valueOf(6));
    }

    private static String stringProd(String s, int i) {
        final StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(s);
        }
        return sb.toString();
    }

    // use stringProd
    @Test
    public void strSum() {

        final GenericProduct<String> prod = Lambdas03Exercise::stringProd;
        //(h,i)->stringProd(h,i);

        assertEquals(prod.prod("a", 2), "aa");
    }

    private final String delimiter = "-";

    private String stringSumWithDelimiter(String s, int i) {
        final StringJoiner sj = new StringJoiner(delimiter);
        for (int j = 0; j < i; j++) {
            sj.add(s);
        }
        return sj.toString();
    }

    //use stringSumWithDelimiter
    @Test
    public void strSum2() {
        final GenericProduct<String> prod = this::stringSumWithDelimiter;
        //(h,i)->stringSumWithDelimiter(h,i);
        assertEquals(prod.prod("a", 3), "a-a-a");
    }
}
