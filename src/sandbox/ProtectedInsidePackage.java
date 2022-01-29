package sandbox;

public class ProtectedInsidePackage {

    void foo() {

        // both are allowed, as we are in the same package
        new Playing().greeting();
        new Playing().greeting2();
    }
}
