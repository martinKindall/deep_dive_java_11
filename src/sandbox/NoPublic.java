package sandbox;

class NoPublic {
    void greetings() {}

    public static void main(String[] args) {
        new NoPublic().greetings();
    }
}
