public class Zoo {
    public static void main(String... args) {
        String animal = args.length > 0 ? args[0] : "mono";
        System.out.println("Hola Zoologico, veo un " + animal);
    }
}