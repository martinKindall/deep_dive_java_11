package sandbox;

public interface StaticInterface {
    static void update() {

    }
    void greeting();
    private void save() {

    }
    default void load() {
        greeting();
    }
}
