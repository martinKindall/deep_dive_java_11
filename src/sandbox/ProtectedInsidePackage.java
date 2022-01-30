package sandbox;

import otherPackage.IncreasingVisibility;
import otherPackage.Visibility;

public class ProtectedInsidePackage {

    void foo() {

        // both are allowed, as we are in the same package
        new Playing().greeting();
        new Playing().greeting2();
    }
}

class Experiment {
    public static void main(String[] args) {
        Visibility a = new Visibility();
        a.greeting();
        IncreasingVisibility b = new Visibility();
//        b.greeting();   // does not compile, protected access.

        IncreasingVisibility c = new AnotherExperiment();
        c.saySentence();   // works and we use the abstractiontype
        // thus we have overriden the protected method which is originaly
        // not intended to be used on its own (it is protected and in another package)
        // but to be implemented only
    }
}

class AnotherExperiment extends IncreasingVisibility {
    @Override
    public void greeting() {
        System.out.println("Hi from another package");
    }
}