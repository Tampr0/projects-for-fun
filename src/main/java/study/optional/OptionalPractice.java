package study.optional;

import java.util.Optional;

public class OptionalPractice {
    public static void main(String[] args) {
        OptionalPractice optional = new OptionalPractice();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //.empty creates an empty optional
        Optional<String> c = Optional.empty();

        // .ofNullable allows passed parameter to be null
        Optional<Integer> a = Optional.ofNullable(value1);

        //throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optional.sum(a,b));

        String moja = null;

        System.out.println(Optional.ofNullable(moja).orElseThrow(IllegalArgumentException::new));

    }



    public Integer sum(Optional<Integer> a, Optional<Integer> b) {

        //.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //.orElse - returns the value if present otherwise returns the default vaule passed
        Integer value1 = a.orElse(new Integer(0));

        //.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }

}
class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Integer getAge() {
        return age;
    }
}
class metOpt {

}

