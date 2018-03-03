package com.demoprograms.day7;
class GenericBox<T> {

    private T t; // T stands for "Type"

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
} 
public class BoxDemo3 {

    public static void main(String[] args) {
    	GenericBox<Integer> integerBox = new GenericBox<Integer>();
      //  integerBox.add("10"); Compile time error
        Integer someInteger = integerBox.get(); // no cast!
        System.out.println(someInteger);
    }
}
