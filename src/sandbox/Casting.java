package sandbox;

public class Casting {
    public static void main(String[] args) {
        Anfibio tadpole = new Guarisapo();
        Anfibio tadpole2 = new Guarisapo();
        Guarisapo castedTadpole = (Guarisapo) tadpole2;   // compiles and works
//        Cat someCat = (Cat) new Guarisapo();   // does not compile when directly instantiating
        Cat someCat = (Cat) tadpole;   // compiles but throws ClassCastException on runtime
    }
}

interface Anfibio {}

class Guarisapo implements Anfibio {}

class Cat {}
