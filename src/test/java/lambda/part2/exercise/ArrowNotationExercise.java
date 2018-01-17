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
        final Function<Person, Integer> getAge = Person::getAge;

        assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
    }

    @Test
    public void compareAges() {

        BiPredicate<Person,Person> compareAges = (Person a, Person b) -> a.getAge() == b.getAge();

//        throw new UnsupportedOperationException("Not implemented");
        assertEquals(true, compareAges.test(new Person("a", "b", 22), new Person("c", "d", 22)));
    }


    // getFullName: Person -> String

    private BiFunction<Person, Person, Integer> getAgeOfPersonWithTheLongestFullName(Function<Person, String> gfn){
        return (x, y) -> gfn.apply(x).length()>gfn.apply(y).length() ? x.getAge() : y.getAge();
    }

    // ageOfPersonWithTheLongestFullName: (Person -> String) -> (Person, Person) -> int
    //
    private Function<Person, String> getFullName() {
        return p -> p.getLastName()+' '+p.getFirstName();
    }


    @Test
    public void getAgeOfPersonWithTheLongestFullName() {
        // Person -> String
        final Function<Person, String> getFullName = this.getFullName();

        // (Person, Person) -> Integer

        final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName = this.getAgeOfPersonWithTheLongestFullName(getFullName);


        assertEquals(
                Integer.valueOf(1),
                ageOfPersonWithTheLongestFullName.apply(
                        new Person("a", "b", 2),
                        new Person("aa", "b", 1)));
    }


}
