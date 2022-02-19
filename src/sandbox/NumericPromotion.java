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
    }
}
