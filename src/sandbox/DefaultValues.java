package sandbox;

public class DefaultValues {
    static float value;
    static int value2;
    static double value3;
    static long value4;

    public static void main(String[] args) {
        System.out.println(value);   // 0.0
        System.out.println(value2);  // 0
        System.out.println(value3);  // 0.0
        System.out.println(value4);  // 0

        // so, although long and floats do have respectively L anf f as suffix when defined,
        // their default values do not show this

        var someVal = 1/0;   // compiles although it has no sense dividing by zero
        // actually this throws an ArithmeticException

//        boolean algo = 0;   // cannot assign number to boolean
//        boolean algo2 = !0;   // cannot negate numbers, only booleans
    }
}
