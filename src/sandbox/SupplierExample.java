package sandbox;

import java.util.function.Supplier;

public class SupplierExample {

    void executable(Supplier<String> stringCallback) {
        System.out.println("The passed value is: " + stringCallback.get());
    }

    public static void main(String[] args) {
        new SupplierExample().executable(() -> "I was passed by a lambda");
    }
}
