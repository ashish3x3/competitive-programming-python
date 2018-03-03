package com.demoprograms.day7;
import java.util.*;
 class AListGenerics<E>
{

List<E> melements=new ArrayList<E>();

 void add(E element)
{

melements.add(element);
}


 E getElement(int index)
{

return melements.get(index);
}

}

