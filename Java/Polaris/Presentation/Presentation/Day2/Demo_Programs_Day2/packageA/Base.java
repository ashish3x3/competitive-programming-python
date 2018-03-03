package packageA;
 public class Base {
    public String publicStr = "publicString";
    protected String protectedStr = "protectedString";
    String defaultStr = "defaultString";
    private String privateStr = "privateString";

    public void print() {
        System.out.println("packageA.Base has access to");
        System.out.println("    " + publicStr);
        System.out.println("    " + protectedStr);
        System.out.println("    " + defaultStr);
        System.out.println("    " + privateStr);

        Base b = new Base(); // -- other Base instance
        System.out.println("    b." + b.publicStr);
        System.out.println("    b." + b.protectedStr);
        System.out.println("    b." + b.defaultStr);
        System.out.println("    b." + b.privateStr);
    }
}

