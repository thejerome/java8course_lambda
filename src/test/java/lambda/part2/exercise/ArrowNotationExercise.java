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
        final Function<Person, Integer> getAge = Person::getAge;

        assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
    }

    @Test
    public void compareAges() {
        // compareAges: (Person, Person) -> boolean
        BiPredicate<Person, Person> compareAges = (a, b) -> a.getAge() == b.getAge();

        assertEquals(true, compareAges.test(new Person("a", "b", 22), new Person("c", "d", 22)));
    }

    // getFullName: Person -> String
    static Function<Person, String> getFullName = (p) -> p.getFirstName() + p.getLastName();

    // ageOfPersonWithTheLongestFullName: (Person -> String) -> (Person, Person) -> int
    static BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName(Function<Person, String> f){
        return ((person, person2) -> Stream.of(person,person2)
                .max(Comparator.comparingInt(p -> f.apply(p).length()))
                .orElseThrow(RuntimeException::new)
                .getAge());
    }

    @Test
    public void getAgeOfPersonWithTheLongestFullName() {
        // Person -> String
        final Function<Person, String> getFullName = ArrowNotationExercise.getFullName;

        // (Person, Person) -> Integer
        final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName = ageOfPersonWithTheLongestFullName(getFullName);

        assertEquals(
                Integer.valueOf(1),
                ageOfPersonWithTheLongestFullName.apply(
                        new Person("a", "b", 2),
                        new Person("aa", "b", 1)));
    }
}
