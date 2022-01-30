package otherPackage;

public class StringEquality {

    void experiment() {
        var s1 = "Java";
        var s2 = "Java";
        var s3 = "Ja".concat("va");
        var s4 = s3.intern();
        var sb1 = new StringBuilder();
        sb1.append("Ja").append("va");

        System.out.println(s1 == s2);   // both are string literals and are the same -> true
        System.out.println(s1 == s3);   // this creates a new string object on runtime -> false
        System.out.println(s1.equals(s3));   // equals -> true
        System.out.println(s1 == s4);   // intern gets the literal -> true
        System.out.println(s1.equals(s2));
        System.out.println(sb1.toString() == s1);   // toString computes the value but not from the string pool -> false
        System.out.println(sb1.toString().equals(s1));
    }

    public static void main(String[] args) {
        new StringEquality().experiment();
    }
}
