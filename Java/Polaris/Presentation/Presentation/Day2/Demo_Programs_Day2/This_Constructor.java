class This_Constructor{
    private double interest;
    private String type;
   
    public This_Constructor(){
       this("personal loan");
    }
   
    public This_Constructor(String type){
        this.type = type;
        
        System.out.println(type);
    }   
    
    public static void main(String args[])
    
    {
    	This_Constructor obj=new This_Constructor();
    }
}
    
 
