package sandbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Playing {

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

        int multiplier = -1;
        List<Integer> someList = new ArrayList<>(List.of(99, 66, 77, 88));
        someList.sort((x, y) -> multiplier * y.compareTo(x));
        someList.sort((x, y) -> {
            return multiplier * y.compareTo(x);
        });
        System.out.println(someList);

        List<Integer> someList2 = List.of(99, 66, 77, 88);
//        someList2.sort((x, y) -> multiplier * y.compareTo(x));   // compile error, immutable list
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
