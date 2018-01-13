package lambda.part2.exercise;

import static org.junit.Assert.assertEquals;

import data.Person;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.Test;

public class ArrowNotationExercise {

  private static int strAge(Person person) {
    return person.getAge();
  }

  private static String getFullName(Person person) {
    return person.getFirstName() + " " + person.getLastName();
  }

  @Test
  public void getAge() {
    // Person -> Integer
    final Function<Person, Integer> getAge = ArrowNotationExercise::strAge;

    assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
  }

  @Test
  public void compareAges() {
    // TODO use BiPredicate
    // compareAges: (Person, Person) -> boolean

    throw new UnsupportedOperationException("Not implemented");
    //assertEquals(true, compareAges.test(new Person("a", "b", 22), new Person("c", "d", 22)));
  }

  // TODO
  // getFullName: Person -> String

  // TODO
  // ageOfPersonWithTheLongestFullName: (Person -> String) -> (Person, Person) -> int
  //

  @Test
  public void getAgeOfPersonWithTheLongestFullName() {
    // Person -> String
    final Function<Person, String> getFullName = null; // TODO

    // (Person, Person) -> Integer
    // TODO use ageOfPersonWithTheLongestFullName(getFullName)
    final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName = null;

    assertEquals(
        Integer.valueOf(1),
        ageOfPersonWithTheLongestFullName.apply(
            new Person("a", "b", 2),
            new Person("aa", "b", 1)));
  }
}
