package com.demoprograms.day6;

class CommonObject {
  int i;
  int j;
  
  public int add() {
    return i+j;
  }
}
class ComputerService implements Runnable {
 
	CommonObject co;
    int[] a;
    int[] b;
    
    
    public ComputerService(CommonObject co, int[] a, int[] b) {
      this.co = co;
      this.a = a;
      this.b = b;
    }
    
    public void run() {
      try {
          
    
          synchronized(co) {
        	

          for(int i=0;i<a.length;i++) {
        	 // co.wait();
              co.i = a[i];
              co.j = b[i];
        
           System.out.println("Thread :"+Thread.currentThread()+"   "+co.add());
       // co.notify();
          }
      
         }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
}

public class ThreadTest {
	  public ThreadTest() {
	    CommonObject co = new CommonObject();
	    Thread t1 = new Thread(new ComputerService(co, new int[]{5,10,15,20,25,30},
	                             new int[]{5,10,15,20,25,30}));
	    Thread t2 = new Thread(new ComputerService(co,new int[]{15,12,15,20,25,30},
	                             new int[]{5,10,15,20,25,30}));
	    t1.start();
	   
	    t2.start();

	  }
	  public static void main(String[] args) {
	    new ThreadTest();
	  }
	}

