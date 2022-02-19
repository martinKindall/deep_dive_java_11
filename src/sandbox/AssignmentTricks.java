package sandbox;

public class AssignmentTricks {
    public static void main(String[] args) {

        int sheep = 5;
        long goat = 10;

//        sheep = sheep * goat;   // does not compile
        sheep *= goat;   // this compiles! Surprisingly, the compiler promotes and demotes
        // automatically the result to match the left side, so it casts automatically long to int.

        int wolf = 10;
        int dog = wolf = 5;   // this is valid and the result of assignment is the value assigned
        dog = (wolf = 5);   // also valid
        System.out.println(wolf);
        System.out.println(dog);

        int a, b, c = 2;
        a = b = c += 10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
