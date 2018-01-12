package lambda.part2.exercise;

import data.Person;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class ArrowNotationExercise {

    @Test
    public void getAge() {
        // Person -> Integer
        final Function<Person, Integer> getAge = Person::getAge; // DONE

        assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
    }

    @Test
    public void compareAges() {
        // DONE: use BiPredicate
        BiPredicate<Person, Person> compareAges = (p1, p2) -> p1.getAge() == p2.getAge();

        //throw new UnsupportedOperationException("Not implemented");
        assertEquals(true, compareAges.test(new Person("a", "b", 22), new Person("c", "d", 22)));
    }

    // DONE
    // getFullName: Person -> String
    public static String getFullName(Person person) {
        return person.getLastName() + person.getFirstName();
    }


    // DONE
    // ageOfPersonWithTheLongestFullName: (Person -> String) -> (Person, Person) -> int
    public static BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName(Function<Person, String> getFullName) {
        return (p1, p2) -> (getFullName.apply(p1).length() > getFullName.apply(p1).length())
                ? p1.getAge() : p2.getAge();
    }

    @Test
    public void getAgeOfPersonWithTheLongestFullName() {
        // Person -> String
        final Function<Person, String> getFullName = ArrowNotationExercise::getFullName; // DONE

        // (Person, Person) -> Integer
        // DONE: use ageOfPersonWithTheLongestFullName(getFullName)
        final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName =
                ageOfPersonWithTheLongestFullName(getFullName);

        assertEquals(
                Integer.valueOf(1),
                ageOfPersonWithTheLongestFullName.apply(
                        new Person("a", "b", 2),
                        new Person("aa", "b", 1)));
    }
}
