package lambda.part1.exercise;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import data.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Lambdas02Exercise {

    //use Arrays.sort with lambda
    @Test
    public void sortPersonsByAge() {
        Person[] persons = {
                new Person("name 3", "lastName 3", 20),
                new Person("name 1", "lastName 2", 40),
                new Person("name 2", "lastName 1", 30)
        };

        Arrays.sort(persons, (p1, p2) -> Integer.valueOf(p1.getAge()).compareTo(Integer.valueOf
                (p2.getAge())));
        assertArrayEquals(persons, new Person[]{
                new Person("name 3", "lastName 3", 20),
                new Person("name 2", "lastName 1", 30),
                new Person("name 1", "lastName 2", 40),
        });
    }

    //use FluentIterable and lambda
    @Test
    public void findFirstWithAge30() {
        List<Person> persons = ImmutableList.of(
                new Person("name 3", "lastName 3", 20),
                new Person("name 1", "lastName 2", 30),
                new Person("name 2", "lastName 1", 30)
        );

        Person person = null;

        Optional<Person> personOptional = FluentIterable.from(persons).firstMatch((p) -> p.getAge()
                == 30);
        //persons.stream().filter((p) -> p.getLastName().equals("lastName 2")).findFirst();
        if (personOptional.isPresent()) {
            person = personOptional.get();
        }
        assertEquals(person, new Person("name 1", "lastName 2", 30));
    }
}