package ro.java.ctrln.collections;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class TraversingAggregateOperation {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        integers.forEach(integer -> System.out.print(integer)); // forEach o expresie cu Lambda
        System.out.println(";");
        integers.forEach(System.out::print); // acelasi lucru ↑ doar cu method reference☻
        System.out.println(";");

        integers.stream().forEach(integer -> System.out.print(integer));// forEach cu stream si lambda
        System.out.println(";");
        integers.stream().forEach(System.out::print);// forEach cu stream si method reference
        System.out.println(";");

        integers.stream().filter(inte -> inte%2==0).forEach(integer -> System.out.print(integer));//afisam numerele pare
        System.out.println(";");
        integers.stream().filter(inte -> inte%2==0).forEach(System.out::print);//afisam numerele pare,method reference

    }
}
