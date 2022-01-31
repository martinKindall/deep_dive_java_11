package sandbox;

public class InstanceInitializer {
    String aName = "Martin";

//    static {   // this initializer cannot be static, as it uses an attribute

    static {
        System.out.println("Second init logic, this is static.");
        System.out.println("It runs before the inner main method, but after");
        System.out.println("The main method of the 'Another' class.");
    }

    InstanceInitializer() {
        System.out.println("Entering the constructor");
        {
            System.out.println("block inside constuctor");
        }
    }

    {
        System.out.println("init logic: " + aName);
        System.out.println("This runs before the constructor logic");
    }

    public static void main(String[] args) {
        System.out.println("Hi there");
        new InstanceInitializer();
    }
}

class Another {
    public static void main(String[] args) {
        System.out.println("Hi there");
        new InstanceInitializer();
    }
}
