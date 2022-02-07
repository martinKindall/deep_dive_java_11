package sandbox;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Playing {

    protected void greeting() {}
    void greeting2() {}

    public static void main(String... args) {
        float aValue = 10.0f;

        System.out.println("And the value is: " + aValue);

        var someValue = 25;   // var keyword

//        float anotherVal = 9 + 1.0;   // double cannot be converted to float like this
        var anotherVal = 9 + 1.0f;   // this compiles
        double anotherVal2 = 9 + 1.0f;   // this compiles
        System.out.println(anotherVal);
        System.out.println(anotherVal2);

        final int someval = 3, another = 4;
        int myScor = 9;

        switch (myScor) {
//            8:   // wrong, it is missing the "case" keyword
            case 9:
            case 10:
                System.out.println("asd");
            default:
                System.out.println("asd2");
                break;
        }

        var var = 3;   // var as variable name is allowed

//        int num = 1 + 2.0;   // also does not work
        double tuesday = 5_6;
        double tuesday5 = 5_6_0;
        double tuesday6 = 5__6_0;
        double tuesday2 = 5_6L;
        double tuesday3 = 56_0;
        double tuesday4 = 5_60;
        System.out.println(tuesday);
        System.out.println(tuesday2);
        System.out.println(tuesday3);
        System.out.println(tuesday4);
        System.out.println(tuesday5);
        System.out.println(tuesday6);

//        boolean wednesday = 1 > 2 ? !true;   // incomplete tenary operation
        short someVal = (short) Integer.MAX_VALUE;   // compiles but conversion looses the real value
        System.out.println(someVal);   // short is namely smaller than Integer in terms of bits

//        long friday = 8.0L;   // does not work
        long friday = 8L;
        System.out.println(friday);

//        var saturday = 2_.0;   // does not work
        var saturday = 2_0.0_0;
        System.out.println(saturday);

        long something = 10L;
        float something2 = 11f;
        float something3 = 11.0f;

        float casted = (float) 10.0;  // casting works
        long casted2 = ((long) 10.0) + 1;  // casting works
        System.out.println(casted);
        System.out.println(casted2);

        // examples of Java labels, although
        // according to https://stackoverflow.com/a/27696742/6398014
        // I wouldn't recommend using this
        OUTER: for (var i = 0; i < 3; i++) {
            INNER: do {
                i++;
                System.out.println("hi");
            } while (false);
        }

        someLabel:
        for (var i = 0; i < 100; i++) {
            System.out.println("Outer loop runs just one time");
            for (var j = 0; j < 100; j++) {
                if (i % 20 == 0) {
                    break someLabel;
                }
            }
        }

        int[] someArr = {6, 8, 9};
        List<Integer> aList = new ArrayList<>();
        aList.add(someArr[0]);
        aList.add(someArr[2]);
        aList.set(1, someArr[1]);
        aList.remove(0);

        System.out.println(aList);
        System.out.println("C" + Arrays.compare(someArr, new int[] {6, 8, 9}));   // 0, neither greater nor smaller
        System.out.println("M" + Arrays.mismatch(someArr, new int[] {6, 8, 9}));   // -1, no mismatch
        System.out.println("M" + Arrays.mismatch(someArr, new int[] {6, 8, 10}));   // mismatch at index 2
        System.out.println("M" + Arrays.mismatch(someArr, new int[] {}));   // mismatch at index 0
        System.out.println("M" + Arrays.mismatch(someArr, new int[] {6}));   // mismatch at index 1

        int multiplier = 1;
        multiplier *= -1;
        List<Integer> someList = new ArrayList<>(List.of(99, 66, 77, 88));
//        someList.sort((x, y) -> multiplier * y.compareTo(x));   // does not compile, because
        // multiplier is not final

        System.out.println(someList);

        List<Integer> someList2 = List.of(99, 66, 77, 88);
//        someList2.sort((x, y) -> multiplier * y.compareTo(x));   // compile error, immutable list

        Door door = new Door() {   // we can use the anonymous syntax on concrete classes too
            public void something() {}
        };
//        door.something();   // but we cannot extend new methods not defined in the concrete class
                              // if we used the type Door at the variable definition

        // on the contrary, here it works, because the following object
        // although uses the Door constructor, is not a Door type, so we can call something()
        new Door() {
            public void something() {}
        }.something();

        SomethingAnonymous algo = new SomethingAnonymous() {
            @Override
            public void show() {
                System.out.println("hi");
            }
        };

//        String line;
//        Console c = System.console();
//        if ((line = c.readLine()) != null) {   // this c.readLine throws a NullPointer Exceptin
//            System.out.println("Your requested meal: " + line);
//        }

        Set<? extends RuntimeException> mySet = new TreeSet<RuntimeException>();
        Set<? extends RuntimeException> mySet2 = new TreeSet<NullPointerException>();
        Set<? extends RuntimeException> mySet3 = new HashSet<RuntimeException>();
        Set<? extends RuntimeException> mySet4 = new HashSet<IllegalArgumentException>();

        new Door() {
            // we can
            void existingMethod(int num) {
                System.out.println("was here");
            }
            void setup() {}
        }.setup();

        new Door() {}.existingMethod();

//        class RandomClass {}.new RandomClass();   // not allowed

//        class Magician {
//            protected class MagicWand {   // cannot be protected here (inside static maybe)
//                void abracadabra() {
//                    System.out.println("Hocus pocus");
//                }
//            }
//        }

//        magic(Stream.empty());   // NoSuchElementException (No value present)
        magic(Stream.iterate(1, x -> x++));   // this one returns 1 before the increment
                                                    // so it's actually a stream of 1
        magic(Stream.iterate(1, x -> ++x));
//        magic(Stream.of(5, 10));   // NoSuchElementException (No value present)

        List<Integer> dataStream = new ArrayList<>();
//        IntStream.range(0, 100).serial().forEach(x -> dataStream.add(x));   // serial does not exist
        IntStream.range(0, 100).parallel().forEach(x -> dataStream.add(x));
        System.out.println("data 1 " + dataStream.size());   // size will be lower than 100 because of the
        // parallel nature of the stream -> there is data loss

        // all the following are alternatives that deal with this problem and gather successfully all values
        List<Integer> dataStream2 = new ArrayList<>();
        IntStream.range(0, 100).parallel().forEachOrdered(x -> dataStream2.add(x));
        System.out.println("data 2 " + dataStream2.size());

        List<Integer> dataStream3 = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(0, 100).parallel().forEach(x -> dataStream3.add(x));
        System.out.println("data 3 " + dataStream3.size());

        List<Integer> dataStream4 = new CopyOnWriteArrayList<>();
        IntStream.range(0, 100).parallel().forEach(x -> dataStream4.add(x));
        System.out.println("data 4 " + dataStream4.size());

        List<Integer> dataStream5 = new ArrayList<>();
        IntStream.range(0, 100).forEach(x -> dataStream5.add(x));
        System.out.println("data 5 " + dataStream5.size());

        List<Integer> dataStream6 = new ArrayList<>();
        IntStream.range(0, 100).sequential().forEach(x -> dataStream6.add(x));
        System.out.println("data 6 " + dataStream6.size());

        // streams exercise

        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();

        // the following code does not terminate
//        var result = Stream.generate(() -> "")
//                .filter(notEmpty)
//                .collect(Collectors.groupingBy(k -> k))
//                .entrySet()
//                .stream()
//                .map(Map.Entry::getValue)
//                .flatMap(Collection::stream)
//                .collect(Collectors.partitioningBy(notEmpty));
//        System.out.println(result);

        char initial = 'a';
        GenerateStrings gen = new GenerateStrings();
        Supplier<String> supply = () -> gen.generate();

        Stream.generate(supply)
                .limit(5)
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x));

        SomeInterface someThing = x -> x * 2;   // conforms to the startGame method in the interface
        someThing.win();
        someThing.win2();

        AlsoALambda check = w -> w.length() > 5;
//        check.nothing();   // does not compile, nothing is private
        System.out.println(check.isLongerThan5("Mart"));
        System.out.println(check.isLongerThan5("Martin"));

        Integer a = 3;
        int b = 5;
        System.out.println("Integer + int: " + (a + b));

//        System.out.println(test((int i) -> i == 5));   // int cannot be used to define Integer in this case
        System.out.println(test((Integer i) -> i == 5));
        System.out.println(test((i) -> i == 5));   // using parentheses without type is also allowed
        System.out.println(test((i) -> {
            return i == 5;   // previous is syntax sugar of this
        }));

        short something6 = 'a';
        char mammal = 83;
        char mammal2 = (short) 83;  // makes no difference from the previous line
//        short sumethin = 65535;   // does not compile, too big
//        char sumething2 = -1;   // also does not compile, char does not have negative

        System.out.println(something6);
        System.out.println(mammal);
        System.out.println(mammal2);

        long numer10 = 10L;

        int binaryFormat = 0b1010;   // numbe 10
        int hexFormat = 0x0a;  // number 10

//        int intCannotBeNull = null;   // primitive types cannot be null
        String butStringCanBeNull = null;

        int[] anArray = new int[10];
        int size = anArray.length;   // arrays do have length as attribute

        String someWord = "Hello";
        int wordLength = someWord.length();   // Strings do have a length method instead
        int _anotherVar = 10;

        int num, num2;

//        int number1, int number2;   // does not compile
    }

    private static boolean test(Predicate<Integer> p) {
        return p.test(5);
    }

    private static void magic (Stream<Integer> s) {
        Optional o = s
                .filter(x -> x < 5)
                .limit(3)
                .max((x, y) -> x - y);
        System.out.println(o.get());
    }
}

@FunctionalInterface
interface SomeInterface {
    public static void roll() { roll(); }
    private int takeBreak() {
        roll();
        return 1;
    }
    int startGame(int players);
//    default void win();   // does not compile, default methods need a body
    default void win() {
        System.out.println("I won!");
    }

    default void win2() {
        System.out.println("I won 2!");
    }
//    static void end() { win(); }   // non static method called from static context
    boolean equals(Object o);
}

interface AlsoALambda {
    boolean isLongerThan5(String word);
    private void nothing() {};
}

class GenerateStrings {
    private String current = "";

    String generate() {
        String old = current;
        current += "a";
        return old;
    }
}

abstract class AnAbstractClass {

    public abstract void swim();   // abstract method cannot have a body

    public void pool() {
        swim();
    }

//    var var = 3;   // var keyword not admissible as instance member

    int var = 3;

    void var() {
        var something = 10;
        var var = 14;

//        String new = "algo";  // also not allowed, new is special keyword
    }

    //    String new = "hola";   // new keyword not allowed
    String new2 = "hola";

    //    var aMethod() {}   // var keyword does not allow definition of methods
    void aMethod() {
    }
}

interface CanSwim {
}

class Amphibian implements CanSwim {
}

abstract class Tadpole extends Amphibian {
}   // so an abstract class can extend a concrete class

class Frog extends Amphibian {
}

class FindAllTadpoles {
    public static void main(String[] args) {
        var tadpoles = new ArrayList<Tadpole>();

        // tadpole can take the form of an Amphibian (polimorphism)
        // but not the other way around, an amphibian is not neccesarily a Tadpole, it can be a Frog
        for (Amphibian amphibian : tadpoles) {
//            CanSwim tadpole = amphibian;   // works too
//            Amphibian tadpole = amphibian;   // works too
            Object tadpole = amphibian;
        }
    }
}

class AutocloseableTest {

    void test() {
        //        try (StringBuilder reader = new StringBuilder()) {   // here we do have a compiler error
        //            var animal = "dog";
        //        } catch (Exception e || RuntimeException e) { // also here
        //            System.out.println("c");
        //        }

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            // this is the autoclosable feature to try resources in Java
            // is this similar to python with ?
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}

class Door {
//    int case = 1;   // "case" cannot be the name of an attribute nor a method, it is reserved.

    void existingMethod() {
        System.out.println("Was original");
    }
}
interface SomethingAnonymous {
    void show();
}


// simple generic example
class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        var one = new Box<String>("a string");
        var two = new Box<Integer>(3);
        System.out.print(one.getValue());
        System.out.print(two.getValue());

        new PrivateProtectedTest().greeting();   // although greeting is protected
        new ExtendsProtected().greeting0();
        new ExtendsProtected().greeting();
    }
}

class PrivateProtectedTest {

    void greeting0() {}
    protected void greeting() {}
    private void greeting2() {}

    public static void main(String[] args) {
        // both are allowed, as we are still inside the class
        new PrivateProtectedTest().greeting();
        new PrivateProtectedTest().greeting2();
    }
}

class ExtendsProtected extends PrivateProtectedTest {

}

class ThrowingExceptions {

//    void throwing() {   // does not compile because the exception is not handled
//        throw new FileNotFoundException();
//    }

    void throwing() throws FileNotFoundException {   // exception declaration needed
        throw new FileNotFoundException();
    }

    void anotherException() {  // RuntimeException does not need handling
        // it is considered a system exception, thus it does not require handling
        // because the client actually cannot do anything to recover

        // we declare and handle exception which are recoverable
        throw new RuntimeException();
    }

    public static void main(String[] args) {   // the exception is handled, so no declaration was needed
        try {
            new ThrowingExceptions().throwing();
        } catch (IOException | RuntimeException e) {   // multicatch notation
//        } catch (Exception | RuntimeException e) {   // does not compile, multicatch must be disjoint
            e.printStackTrace();
            System.out.println("There was an error");
        }

        new ThrowingExceptions().anotherException();
    }
}

class SuperCall {

    SuperCall() {
        System.out.println("Default parent constructor called.");
    }
    SuperCall(int a) {
        System.out.println("Parent constructor with argument was called: " + a);
    }
}

class MegaCall extends SuperCall {
    MegaCall() {
        super(10);
        System.out.println("Child's simple constructor is called");
    }

    MegaCall(int a) {
        System.out.println("Child's constructor being called: " + a);
    }

    public static void main(String[] args) {
        new MegaCall(5);   // this calls super() implicitly
        new MegaCall();   // this calls super(value) explicitly
    }
}

class MagicianTests {
    public static void main(String[] args) {
        new Magician.MagicWand();   // static inner class
        Magician.MagicWandNonStatic wand = new Magician().new MagicWandNonStatic();   // non static inner class
        wand.abracadabra();
        wand.printMageName();
    }
}

class Magician {
    protected String name = "Sirius Black";

    static class MagicWand {
        void abracadabra() {
            System.out.println("Hocus pocus");
        }
        void printMageName() {
//            System.out.println("My owner is " + name);   // not available from static context
            cannotBeProtected();   // but we can call static methods
//            something();   // same as name, non-static context method
        }
    }

    class MagicWandNonStatic {
        void abracadabra() {
            System.out.println("Hocus pocus");
        }
        void printMageName() {
            System.out.println("My owner is " + name);   // here we access the property of outer class
            something();   // outer class method, no problem, even if it is private
            cannotBeProtected();  // static methods can be called within non-static, not otherwise
        }
    }

    public static void main(String[] args) {
        new MagicWand().abracadabra();
    }

    void something() {
        class Magician2 {
            class MagicWand {
                void abracadabra() {
                    System.out.println("Hocus pocus");
                }
            }
        }

        new Magician2().new MagicWand().abracadabra();
    }

    static void cannotBeProtected() {
        class Magician2 {
//            protected class MagicWand {   // also cannot be protected here
//                void abracadabra() {
//                    System.out.println("Hocus pocus");
//                }
            }
    }
}