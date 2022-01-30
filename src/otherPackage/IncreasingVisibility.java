package otherPackage;

public abstract class IncreasingVisibility {

    protected abstract void greeting();

    public void saySentence() {
        System.out.println("Hi there, the following is a greeting: ");
        greeting();
    }
}
