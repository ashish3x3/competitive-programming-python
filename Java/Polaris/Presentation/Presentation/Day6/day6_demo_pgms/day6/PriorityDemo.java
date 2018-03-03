package com.demoprograms.day6;


class PriorityDemo extends Thread{
 public void run(){
   System.out.println("running thread name is:"+Thread.currentThread().getName());
   System.out.println("running thread priority is:"+Thread.currentThread().getPriority());

  }
 public static void main(String args[]){
	 PriorityDemo m1=new PriorityDemo();
	 PriorityDemo m2=new PriorityDemo();
  m1.setPriority(Thread.MIN_PRIORITY);
  m2.setPriority(Thread.MAX_PRIORITY);
  m1.start();
  m2.start();
 
 }
}   
