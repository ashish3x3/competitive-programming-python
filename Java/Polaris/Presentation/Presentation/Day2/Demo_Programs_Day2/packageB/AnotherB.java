package packageB;
import packageA.Base;

public class AnotherB {
    public void print() {
        System.out.println("packageB.AnotherB has access to");
        Base b = new Base();
        System.out.println("    b." + b.publicStr);
        // -- not accessible
        // System.out.println(b.protectedStr);
        // System.out.println(b.defaultStr);
        // System.out.println(b.privateStr);
    }
}
