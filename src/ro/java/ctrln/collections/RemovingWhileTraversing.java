package ro.java.ctrln.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class RemovingWhileTraversing {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        //        for (Integer intInteger : integers) {
        //            if (intInteger == 5){
        //                integers.get(5);//☻ Daca faci asa merg sters ultimul index, DE CE ‼‼
        //
        //                integers.remove(5);
        //            }
//               }
        System.out.println(integers);
        for (int index = 0; index < integers.size();index++){
            if (integers.get(index)==4){
                integers.remove(index);
            }
        }
        System.out.println(integers);
        int intElement = 0;
        for (Integer element : integers){
            if (element==3){
                integers.remove(3);
            }
            System.out.print( intElement++);
            System.out.print(",");
        }
        System.out.println(integers);
    }
}
