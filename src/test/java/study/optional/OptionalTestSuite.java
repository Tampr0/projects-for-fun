package study.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OptionalTestSuite {

    @Test
    public void optionalMapTest() {
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        /** utworzenie zagnieżdżonego optionala podczas mapowania **/
        //Optional<Optional<String>> nameOptionalWrapper = personOptional.map(p -> Optional.of(p.getName()));

        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);

        String name1 = nameOptional.orElse("");
        Assert.assertEquals("john", name1);

    }
    @Test
    public void optionalFlatMapTest() {

        /** "john" is a nested Optional<String> whereas 26 is Integer **/

        Person person = new Person("john", 26);         // create of a Person instance
        Optional<Person> personOptional = Optional.of(person);      // taking a person into Optional

        Person person1 = personOptional.orElseThrow(IllegalArgumentException::new);     //
        Integer age1 = personOptional
                .map(Person::getAge)
                .orElse(26);
    }
    @Test
    public void theBigTest() {
        Person person = new Person("Jonn", 26);
        Person personNull = null;


        //empty Optional
        Optional<Person> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());

        // adding a object to empty Optional
        empty = Optional.of(person);
        Assert.assertTrue(empty.isPresent());

        //.of - ONLY if it's NOT NULL
        try {
            Optional<Person> personOptionalNull = Optional.of(personNull);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        Optional<Person> personOptional = Optional.of(person);

        //.ofNullable
        Optional<Person> personOptionalNull1 = Optional.ofNullable(personNull);

        //ifPresent
        Optional<String> name = Optional.of("Mateusz");
        name.ifPresent(n -> {
            System.out.println(n.length());
            n = n.toUpperCase();
            System.out.println(n);
        });

        //
        List<String> companyList = Arrays.asList("PayPal", "Nokia", "IBM", "Tchibo");
        Optional<List> optionalList = Optional.of(companyList);

        int size = optionalList
                .map(List::size)
                .orElse(0);
    }
    // funkcja filter :
    @Test
    public void workingPassword() {
        //boolean correctPassword
        String password = "  Password";
        Optional<String> passOpt = Optional.of(password);

        boolean correctPassword = passOpt
                .filter(s -> s.equals("Password"))
                .isPresent();

        correctPassword = passOpt
                .map(String::trim)
                .filter(p -> p.equals("Password"))
                .isPresent();
    }

    //Przykład rozwiązywania Chaining Optionals z wykazaniem lepszego rozwiązania tj. optChainingTwo

    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input){
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }
    @Test
    public void optChaining() {

        //find first empty - w tym przykładzie wykonują się wszystkie .map(Optional::Get) aby następnie
        //zadziałała metoda .findFirst.
        Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    @Test
    public void optChainingMethRef() {

        //w tym przykładzie gettuje się jedynie Optional z .findFirst()
        Optional<String> found = Stream.<Supplier<Optional<String>>>of(this::getEmpty, this::getHello, this::getBye)
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
    @Test
    public void optChainingLambda() {

        //w tym przykładzie gettuje się jedynie Optional z .findFirst(),
        // lambda dla metod przyjmujących argument
        Optional<String> found = Stream.<Supplier<Optional<String>>>of(
                () -> createOptional("empty"),
                () -> createOptional("hello"))
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }






}
