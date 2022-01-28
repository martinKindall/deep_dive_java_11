package sandbox;

public class Playing {

    public static void main(String[] args) {
        float aValue = 10.0f;

        System.out.println("And the value is: " + aValue);

        var someValue = 25;   // var keyword
    }
}

abstract class AnAbstractClass {

    public abstract void swim();   // abstract method cannot have a body

    public void pool() {
        swim();
    }
}
