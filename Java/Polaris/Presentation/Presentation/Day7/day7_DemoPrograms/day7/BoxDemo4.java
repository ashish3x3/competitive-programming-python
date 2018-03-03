package com.demoprograms.day7;
 class Box1<T> {

    private T t;          

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
           // System.out.println(U);
    }
}
public class BoxDemo4
{

    public static void main(String[] args) {
        Box1<Integer> integerBox = new Box1<Integer>();
        integerBox.add(new Integer(10));
        integerBox.inspect("some text");
    }
}

