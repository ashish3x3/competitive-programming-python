package com.demoprograms.day7;
class Box {

        private Object object;

        public void add(Object object) {
            this.object = object;
        }

        public Object get() {
            return object;
        }
    }
public class BoxDemo2 {

    public static void main(String[] args) {

        // ONLY place Integer objects into this box!
        Box integerBox = new Box();

        // Imagine this is one part of a large application modified by one programmer who has not seen the above comment
        integerBox.add("10"); // note how the type is now String

        // ... and this is another part of the application , perhaps written by a different programmer 
        Integer someInteger = (Integer)integerBox.get();
        System.out.println(someInteger);
    }
}
