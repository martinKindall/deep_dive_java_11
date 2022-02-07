package sandbox;

public class UnitiliazedVars {
    // static variables are also known as class variables
    static int staticValue = 10;
    static int staticValue2;

    // these properties are instance variables
    int prop;
    boolean flag;
    UnitiliazedVars anotherRef;
    int[] someArray;
    char someChar;

    {
        System.out.println(prop + " hi");   // compiles and runs, it prints "0 hi"
    }

    static void greeting() {
        System.out.println("Saying hi");
    }

    public static void main(String[] args) {
        int items;

//        System.out.println(items);   // the compiler will fail when trying to read
        // an uninitialized local variable

        UnitiliazedVars someObj;
//        System.out.println(someObj);   // also applies for objects

        UnitiliazedVars obj = new UnitiliazedVars();

        // although the following props are not initialized, they show default values
        // 0, false, null and null respectively
        // this is a different behaviour from local variables.

        System.out.println(obj.prop);
        System.out.println(obj.flag);
        System.out.println(obj.anotherRef);
//      System.out.println(obj.anotherRef.flag);   // this one compiles but throws a nullpointer
        System.out.println(obj.someArray);
        System.out.println(UnitiliazedVars.staticValue);
        System.out.println(UnitiliazedVars.staticValue2);
        UnitiliazedVars.staticValue2 = 40;
        System.out.println(UnitiliazedVars.staticValue2);
        OtherContext.method(100);
        System.out.println(UnitiliazedVars.staticValue2);
        System.out.println(obj.staticValue2);   // we can also access static members
        // from instances
        obj.greeting();
        System.out.println(obj.someChar);   // prints the null char

        var unObj = new UnitiliazedVars();   // local type inference

        var someVal3 = (short) 30;
//        someVal3 = 1_000_000;   // does not compile, as the inferred type is a short
        // and the value exceeds the 16 bits.

//        var algo30;   // does not compile, var variables must be initialized right away.
        int algo31;

        int a1 = 1, a2 = 2;
//        var b1 = 1, b2 = 2;   // does not compile, not allowed for var
//        var someReference = null;   // cannot infer type, does not compile
        var someRef = (UnitiliazedVars) null;
        var someRef2 = (Object) null;

        someRef = null;   // allowed after inference was done.
    }
}

class OtherContext {
    static void method(int val) {
        UnitiliazedVars.staticValue2 = val;
    }
}

//class var {   // var is a reserved type name, but not a reserved keyword
//
//}

class Var {
    void nothing() {
        var var = "var";   // var is allowed also as an identifier name.
    }
}
