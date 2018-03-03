package packageA;

  public class SubA extends Base {
    public void print() {
        System.out.println("packageA.SubA has access to");
        System.out.println("    " + publicStr + " (inherited from Base)");
        System.out.println("    " + protectedStr + " (inherited from Base)");
        System.out.println("    " + defaultStr + " (inherited from Base)");
        // -- not accessible - private elements are even not inherited
        // System.out.println(privateStr);

        Base b = new Base(); // -- other Base instance
        System.out.println("    b." + b.publicStr);
        System.out.println("    b." + b.protectedStr);
        System.out.println("    b." + b.defaultStr);
        // -- not accessible
        // System.out.println(b.privateStr);
    }
}
