package com.demoprograms.day6;

class MyThread extends Thread{
	 public void run(){
	  System.out.println("Name: "+Thread.currentThread().getName());
	  System.out.println("Daemon: "+Thread.currentThread().isDaemon());
	 }

	 public static void main(String[] args){
	  MyThread t1=new MyThread();
	  MyThread t2=new MyThread();
	  t1.setDaemon(true);
	  
	  t1.start();
	  t2.start();
	 }
	}