package sandbox;

public class GarbageCollection {
    int garbage = 10;

    static boolean etwas;

    public static void main(String[] args) {
        GarbageCollection garbage = new GarbageCollection();
        garbage = null;   // now it is elegible for garbage collection
        System.gc();   // this does not ensure that the gc will act immediately
        System.out.println(etwas);
    }
}
