//Program: Write a program to create deadlock between two threads. 
public class MyDeadlock {
 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
        MyDeadlock mdl = new MyDeadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}


/*


Well if you see through the code you will understand that first in the main method we created the class object using that object we called the thread class object created above and finally called the start() method of Thread class as a result run() gets invoked.When the first thread invokes run first it obtains a lock on first String object, then it tries to acquire lock on second String object. Now consider a situation when first thread acquires lock on first String object and second thread acquires lock on second String object now the first thread waits for the release of lock on second String object hold by Thread2 and the second thread waits for the release of lock on first String object by Thread1.So both keeps waiting and leads to deadlock.

Solution :
Thread trd1 = new Thread("My Thread 1"){
public void run(){
while(true){
synchronized(str1){
synchronized(str2){
System.out.println(str1 + str2);
}}}}};
Thread trd2 = new Thread("My Thread 2"){
public void run(){
while(true){
synchronized(str1){
synchronized(str2){
System.out.println(str2 + str1);
}}}}};



*/
