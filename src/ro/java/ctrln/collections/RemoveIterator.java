package ro.java.ctrln.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class RemoveIterator {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(integers);

//        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext(); ){
//            Integer element = iterator.next();
//            if (element ==3){
//                iterator.remove();
//            }
//        }
        integers.removeIf(element -> element == 3);// Aceeasi functien ca de mai sus ↑ doar ca folosim o expresie lamda  ☻
        System.out.println(integers);
    }
}
