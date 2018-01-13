package lambda.part2.exercise;

import static org.junit.Assert.assertEquals;

import data.Person;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.junit.Test;

public class ArrowNotationExercise {

  private static String getFullName(Person person) {
    return person.getFirstName() + " " + person.getLastName();
  }

  private static boolean compareAges(Person a, Person b) {
    return a.getAge() >= b.getAge();
  }

  //  private static int ageOfPersonWithTheLongestFullName(Person a, Person b) {
  //    Comparator.comparingInt(Person::)
  //  }

  public static BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName(
      Function<Person, String> getFullName) {
    return (p1, p2) -> (getFullName.apply(p1)
                                   .length() > getFullName.apply(p2)
                                                          .length())
        ? p1.getAge() : p2.getAge();
  }

  @Test
  public void getAge() {
    // Person -> Integer
    final Function<Person, Integer> getAge = Person::getAge;

    assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
  }

  @Test
  public void compareAges() {
    // TODO use BiPredicate
    // compareAges: (Person, Person) -> boolean
    BiPredicate<Person, Person> biPredicate = (s, p) -> (s.getAge()) == (p.getAge());

    assertEquals(true, biPredicate.test(new Person("a", "b", 22), new Person("c", "d", 22)));
  }

  // TODO
  // getFullName: Person -> String

  // TODO
  // ageOfPersonWithTheLongestFullName: (Person -> String) -> (Person, Person) -> int
  //

  @Test
  public void getAgeOfPersonWithTheLongestFullName() {
    // Person -> String
    final Function<Person, String> getFullName = ArrowNotationExercise::getFullName; // TODO

    // (Person, Person) -> Integer
    // TODO use ageOfPersonWithTheLongestFullName(getFullName)
    final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName = ageOfPersonWithTheLongestFullName(
        getFullName);

    assertEquals(
        Integer.valueOf(1),
        ageOfPersonWithTheLongestFullName.apply(
            new Person("a", "b", 2),
            new Person("aa", "b", 1)));
  }
}
