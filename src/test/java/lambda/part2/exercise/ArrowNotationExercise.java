package lambda.part2.exercise;

import data.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ArrowNotationExercise {

    @Test
    public void getAge() {
        // Person -> Integer
        final Function<Person, Integer> getAge = Person::getAge; // TODO

        assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
    }

    @Test
    public void compareAges() {
        // TODO use BiPredicate
        final BiPredicate<Person, Person> compareAges = (p1, p2) -> {   // TODO
            return p1 != null && p2 != null && p1.getAge() == p2.getAge();
        };
        // compareAges: (Person, Person) -> boolean

        //throw new UnsupportedOperationException("Not implemented");
        assertEquals(true, compareAges.test(new Person("a", "b", 22), new Person("c", "d", 22)));
    }

    // TODO
    // getFullName: Person -> String
    private static String getFullName(Person p) {
        return p.getFirstName().concat(" ").concat(p.getLastName());
    }

    // TODO
    // ageOfPersonWithTheLongestFullName: (Person -> String) -> (Person, Person) -> int
    //
    private static BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName(Function<Person, String> getFullName) {
        return (
                (p1, p2) -> Stream.of(p1, p2)
                        .max(Comparator.comparingInt(
                                (p) -> getFullName.apply(p).length())
                        )
                        .orElse(new Person("", "", 0))
                        .getAge()
        );
    }

    @Test
    public void getAgeOfPersonWithTheLongestFullName() {
        // Person -> String
        final Function<Person, String> getFullName = ArrowNotationExercise::getFullName; // TODO

        // (Person, Person) -> Integer
        // TODO use ageOfPersonWithTheLongestFullName(getFullName)
        final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName = ageOfPersonWithTheLongestFullName(getFullName);

        assertEquals(
                Integer.valueOf(1),
                ageOfPersonWithTheLongestFullName.apply(
                        new Person("a", "b", 2),
                        new Person("aa", "b", 1)));
    }
}
