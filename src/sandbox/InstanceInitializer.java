package sandbox;

public class InstanceInitializer {
    String aName = "Martin";

//    static {
//      aName = "";    // this initializer cannot be static, as it uses an attribute
//    }

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

class DataClass {
    final int weight;

    DataClass(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        DataClass a = new DataClass(68);
//        a.weight = 30;   // as weight is final, it cannot be set again. I find this
        // approach better than using a private variable with a getter.
        // but according to https://softwareengineering.stackexchange.com/a/250543
        // getters provide flexibility, and even laziness. So getters do have more advantage.
    }
}

class Egg {
    Egg() {
        number = 5;   // does not matter if this assignation is written
        // lines before the variable declaration of "number" (line 67)
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);   // shows 5, because the constructor is run at last. First initializers.
    }
    {
        number = 10;   // also does not fail, although number is defined afterwards
//        System.out.println(number);   // weird, that it is not allowed to read the variable before line 71.
        // but it is posible to set it to 10.
    }
    private int number = 3;
    {
        System.out.println(number);   // allowed to read number
        number = 4;
    }
}