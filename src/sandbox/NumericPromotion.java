package sandbox;

public class NumericPromotion {
    public static void main(String[] args) {
        System.out.println(1 + 2.0);   // promoted to double
        System.out.println(1 + 2.0f);   // promoted to float

        short n1 = 1, n2 = 1;
//        short result = n1 + n2;   // this does not compile, n1 and n2 are neccesarily promoted
        System.out.println(n1 + n2);   // promoted to integer, although none of them is one

        int first = 10;
        long second = 20L;
        var res = first * second;   // this is a long
        System.out.println(res);

        float num = 2.0f;
        double num2 = 3.0;
        var res2 = num  + num2;   // promoted to double
        System.out.println(res2);

//        long avalue = 1929192913913193921;   // although this number fits in a long
        // this does not compile because the compiler thinks of it as an int.
        long correctValue = 1929192913913193921L;   // adding the L instructs the compiler
        // to use a long and it works.Another
//        long correctValue2 = (long) 1929192913913193921;   // casting does not help here

        int somenum = (int) 1.0;   // this works

        long goat = 10L;
        short sheep = 1;

        long res3 = sheep + goat;
//        sheep = sheep + goat;   // does not compile as expected
        sheep += goat;   // but this does work, compilator does casting automatically
        System.out.println(sheep);

//        boolean output = true == 3;   // does not compile
//        boolean comp = new ObjA() == new ObjB();   // does not compile
        Empty a1 = new ObjA();
        Empty a2 = new ObjB();
        boolean comp2 = a1 == a2;   // we can compare objects of the same type

        Empty a3 = new ObjA();
        ObjB a4 = new ObjB();
        boolean comp23 = a3 == a4;   // and this works too.
    }
}

interface Empty {}
class ObjA implements Empty {}
class ObjB implements Empty {}