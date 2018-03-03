package packageB;
import packageA.Base;

public class SubB extends Base {
    public void print() {
        System.out.println("packageB.SubB has access to");
        System.out.println("    " + publicStr + " (inherited from Base)");
        // -- protectedStr is inherited element -> accessible
        System.out.println("    " + protectedStr + " (inherited from Base)");
        // -- not accessible
        // System.out.println(defaultStr);
        // System.out.println(privateStr);

        Base b = new Base(); // -- other Base instance
        System.out.println("    b." + b.publicStr);
        // -- protected element, which belongs to other object -> not accessible
         //System.out.println(b.protectedStr);

        // -- not accessible
        // System.out.println(b.defaultStr);
        // System.out.println(b.privateStr);
    }
}
