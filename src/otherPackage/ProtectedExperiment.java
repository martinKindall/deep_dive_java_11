package otherPackage;

import sandbox.Playing;

public class ProtectedExperiment {
    public static void main(String[] args) {
//        new Playing().greeting();   // it is protected, cannot be accessed
//        new Playing().greeting2();   // has package private modifier
    }
}

class Student extends Playing {
    private int graduationYear = 2018;

    public void foo() {
        greeting();   // protected, it is allowed because Student is a subclass of Playing
//        greeting2();   // package private
    }
}
