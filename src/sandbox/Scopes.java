package sandbox;

public class Scopes {

    void eatHungry(boolean hungry) {
        int originalVal = 5;

        if (hungry) {
            int bitesOfCheese = 1;
        }  // bitesOfCheese goes out of the scope here
//        System.out.println(bitesOfCheese);   // does not compile, out of scope
        {
            int anotherVar = 5;
            System.out.println(originalVal);   // does compile, reference variable
            // outside the scope, in a "parent" scope
        }
//        System.out.println(anotherVar);   // also does not compile
        // blocks of code are separate scopes
    }
}
