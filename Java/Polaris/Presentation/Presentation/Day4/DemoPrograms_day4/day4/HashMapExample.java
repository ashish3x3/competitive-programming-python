package com.demoprograms.day4;
 
import java.util.*;

 
public class HashMapExample{

   

    public static void main(String args[]){

 
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
       
           
        hashMap.put("One",new Integer(1)); // adding value into HashMap
        hashMap.put("Two", new Integer(2));
        hashMap.put("Three", new Integer(3));
        //hashMap.put("Three", new Integer(5));
	    hashMap.put(null,new Integer(4));
        
        hm.putAll(hashMap);

                                        

   System.out.println("HashMap contains " + hashMap.size() + "key value pairs.");
             

     //   Finding particular value from the HashMap:
            

        if(hashMap.containsValue(new Integer(1))){

            System.out.println("HashMap contains 1 as value");

        }else{

            System.out.println("HashMap does not contain 1 as value");

        }

          

       // Finding particular Key from the HashMap:        

      if (hashMap.containsKey(null) ){

            System.out.println("HashMap contains null as key");

        }else{

            System.out.println("HashMap does not contain null as key");

        }

             

        Integer o = (Integer) hashMap.get("One");        

        System.out.println("Value mapped with key \"One\" is " + o);
           

        System.out.println("Retrieving all keys from the HashMap");        
  
        Iterator<String>  iterator = hashMap.keySet().iterator();
      

        while(iterator. hasNext()){        

            System.out.println(iterator.next());

        }
                 

        System.out.println("Retrieving all  key  value pairs from the  HashMap");

       Iterator<Map.Entry<String, Integer>> itr = hashMap.entrySet().iterator();
      

        while(itr. hasNext()){        

            System.out.println(itr.next());


           
        }
        
        
       

       System.out.println("Hash Map's values");
       Iterator<Integer>   i  = hashMap.values().iterator();

               while(i.hasNext()){        

            System.out.println(iterator.next());

       }
               
        
    }
}


    

 


