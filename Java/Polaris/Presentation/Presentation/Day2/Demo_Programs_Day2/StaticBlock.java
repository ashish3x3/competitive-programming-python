
public class StaticBlock{

    {
        System.out.println("This is contructor block");
    }

    public StaticBlock(){
        System.out.println("This is constructor");
    }

    public static String staticString = "Static Variable";

    static {
        System.out.println("This is first static block and "
		                                        + staticString);
    }


    

    public static void main(String[] args){

        StaticBlock statEx = new StaticBlock();
        StaticBlock.staticMethod2();
    }

    static {
        staticMethod();
        System.out.println("This is second static block");
    }

    private static void staticMethod() {
        System.out.println("This is static method");
    }

    public static void staticMethod2() {
        System.out.println("This is static method2");
    }
}

