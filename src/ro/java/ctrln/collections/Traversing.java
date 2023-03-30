package ro.java.ctrln.collections;


import java.util.*;

public class Traversing {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList("First", "Second", "Third"));

        System.out.print("Elementele listei list sunt: ");
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();

        SortedSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 4, 5, 2, 3, 6));
        System.out.print("Elementele listei integers sunt: ");
        for (Integer element : integers) {
            System.out.print(element + " ");

        }
        System.out.println();


        Queue<String> queue = new LinkedList<>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        queue.add("Four");
        System.out.print("Elementele din Queue sunt: ");
        for (String element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();

        System.out.print("Elementele din Deque: ");
        Deque<String> deque = new LinkedList<String>(Arrays.asList("Unu","Doi","Trei","Patru"));
        for (String element : deque) {
            System.out.print(element + " ");
        }
        System.out.println();

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1,"First Element");
        hashMap.put(2,"Second Element");
        hashMap.put(3,"Third Element");
        hashMap.put(4,"Fourth Element");
        hashMap.put(null,"null Element");

        System.out.println("Entry-urile din HashMap:");
        for (Map.Entry<Integer,String> entry : hashMap.entrySet()){
            System.out.println("\t" + entry.getKey() + "->" + entry.getValue());
        }

    }

}