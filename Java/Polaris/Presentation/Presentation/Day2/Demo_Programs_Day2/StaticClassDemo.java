 

class StaticClassDemo{
   private   String s = "Outer string"; //Outer instance variable
      
      void getS(){
        System.out.println(s); 
    }
   
  
    
    static class StaticInnerClass{
        private  static String s = "Inner string"; //Inner instance variable, uninitialized
       
        static void getS(){
            System.out.println(s);
        }
        
     static   void getOuterS(){
           System.out.println("Hi");
       }
       
        
    }
    
    public static void main(String[] args){
        StaticClassDemo o = new StaticClassDemo();
               
        StaticInnerClass.getS();
        o.getS();
        StaticInnerClass.getOuterS();
     
        
    }
}
