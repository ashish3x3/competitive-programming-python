import packageA.*;
import packageB.*;

// -- testing class
public class TestProtection {
    public static void main(String[] args) {
        // -- all classes are public, so class TestProtection
        // -- has access to all of them
        new Base().print();
     
        new SubA().print();
        new AnotherA().print();
        new SubB().print();
        new AnotherB().print();
    }
}

