package com.demoprograms.day6;

class Callme {
   
	void call(String msg) {
      System.out.print("[" + msg);
      try {
         Thread.sleep(2000);
         
      } catch (InterruptedException e) {
         System.out.println("Interrupted");
      }
      System.out.println("]");
   }
}

// File Name : Caller.java
class Caller implements Runnable {
   String msg;
   Callme target;
   Thread t;
 
   public Caller(Callme targ, String s) {
      target = targ;
      msg = s;
      t = new Thread(this);
      t.start();
   }
   
    //synchronized calls to call()
   public void run() {
     synchronized(target) { // synchronized block  or statement
         target.call(msg);
     }
   }
}
 
class SynchronizationDemo {
   public static void main(String args[]) {
      Callme target1 = new Callme();
      
      Caller ob1 = new Caller(target1, "Hello");
      Caller ob2 = new Caller(target1, "Synchronized");
      Caller ob3 = new Caller(target1, "World");
   
      
     
   }
}
