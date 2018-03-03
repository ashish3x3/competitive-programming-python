package packageA;
 public class AnotherA {
    public void print() {
        System.out.println("packageA.AnotherA has access to");
        Base b = new Base();
        System.out.println("    b." + b.publicStr);
        System.out.println("    b." + b.protectedStr);
        System.out.println("    b." + b.defaultStr);
        // System.out.println(b.privateStr);
    }
}
