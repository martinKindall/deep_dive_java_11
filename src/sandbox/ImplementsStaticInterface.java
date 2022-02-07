package sandbox;

public class ImplementsStaticInterface implements StaticInterface {

    public static void main(String[] args) {
        new ImplementsStaticInterface().load();
//        new ImplementsStaticInterface().update();   // static methods can only
        // be called from within the interface declaration
    }

    @Override
    public void greeting() {
        System.out.println("Saying hello!");
    }
}
