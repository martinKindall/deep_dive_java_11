package sandbox;

import java.util.ArrayList;

public class Playing {

    public static void main(String[] args) {
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
