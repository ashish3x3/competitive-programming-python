 

   class Outer{
     
	   private String s = "Outer  string"; //Outer_Demo instance variable
	 
	  
      void getS(){
        System.out.println(s);
            }
   
      
     class Inner{
       
	private  String s = "Inner string"; 
           
       void getS(){
            System.out.println(s);
            System.out.println(Outer.this.s);
        }
          
       }
  
   }
   class Outer_Demo
   {
	    
    public static void main(String[] args){
    	
    	
       Outer o = new Outer();
       
  
       Outer.Inner oi=o.new Inner();
   
        o.getS();
        oi.getS();
      
         
        
    }
}
    
