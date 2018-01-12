package lambda.part2.exercise;

import data.Person;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class FunctionCombinationExercise {

    @Test
    public void personHasNotEmptyLastNameAndFirstName0() {
        // Person -> boolean
        final Predicate<Person> validate = p -> !p.getFirstName().isEmpty() && !p.getLastName().isEmpty();

        assertEquals(true, validate.test(new Person("a", "b", 0)));
        assertEquals(false, validate.test(new Person("", "b", 0)));
        assertEquals(false, validate.test(new Person("a", "", 0)));
    }

    // DONE
    // negate1: (Person -> boolean) -> (Person -> boolean)
    private Predicate<Person> negate1(Predicate<Person> test) {
        return p -> { return !test.test(p);
            // DONE
            //throw new UnsupportedOperationException();
        };
    }

    // DONE
    // validateFirstNameAndLastName: (Person -> boolean, Person -> boolean) -> (Person -> boolean)
    private Predicate<Person> validateFirstNameAndLastName(Predicate<Person> t1, Predicate<Person> t2) {
        return p -> { return t1.test(p) && t2.test(p);
            // DONE
            //throw new UnsupportedOperationException();
        };
    }

    @Test
    public void personHasNotEmptyLastNameAndFirstName1() {
        final Predicate<Person> hasEmptyFirstName = p -> p.getFirstName().isEmpty();
        final Predicate<Person> hasEmptyLastName = p -> p.getLastName().isEmpty();

        final Predicate<Person> validateFirstName = negate1(hasEmptyFirstName);
        final Predicate<Person> validateLastName = negate1(hasEmptyLastName);

        final Predicate<Person> validate = validateFirstNameAndLastName(validateFirstName, validateLastName);

        assertEquals(true, validate.test(new Person("a", "b", 0)));
        assertEquals(false, validate.test(new Person("", "b", 0)));
        assertEquals(false, validate.test(new Person("a", "", 0)));
    }

    // DONE
    // negate: (T -> boolean) -> (T -> boolean)
    private <T> Predicate<T> negate(Predicate<T> test) {
        // DONE
        return p -> !test.test(p);
        //throw new UnsupportedOperationException();
    }

    // DONE
    // and: (T -> boolean, T -> boolean) -> (T -> boolean)
    private <T> Predicate<T> and(Predicate<T> t1, Predicate<T> t2) {
        // DONE
        return p -> t1.test(p) && t2.test(p);
        //throw new UnsupportedOperationException();
    }

    @Test
    public void personHasNotEmptyLastNameAndFirstName2() {
        final Predicate<Person> hasEmptyFirstName = p -> p.getFirstName().isEmpty();
        final Predicate<Person> hasEmptyLastName = p -> p.getLastName().isEmpty();

        final Predicate<Person> validateFirstName = negate(hasEmptyFirstName); // DONE: use negate
        final Predicate<Person> validateLastName = negate(hasEmptyLastName); // DONE: use negate

        final Predicate<Person> validate = and(validateFirstName, validateLastName); // DONE: use and

        assertEquals(true, validate.test(new Person("a", "b", 0)));
        assertEquals(false, validate.test(new Person("", "b", 0)));
        assertEquals(false, validate.test(new Person("a", "", 0)));
    }

    @Test
    public void personHasNotEmptyLastNameAndFirstName3() {
        final Predicate<Person> hasEmptyFirstName = p -> p.getFirstName().isEmpty();
        final Predicate<Person> hasEmptyLastName = p -> p.getLastName().isEmpty();

        final Predicate<Person> validateFirstName = negate(hasEmptyFirstName); // DONE: use Predicate::negate
        final Predicate<Person> validateLastName = negate(hasEmptyLastName); // DONE: use Predicate::negate

        final Predicate<Person> validate = and(validateFirstName, validateLastName); // DONE: use Predicate::and

        assertEquals(true, validate.test(new Person("a", "b", 0)));
        assertEquals(false, validate.test(new Person("", "b", 0)));
        assertEquals(false, validate.test(new Person("a", "", 0)));
    }

}
