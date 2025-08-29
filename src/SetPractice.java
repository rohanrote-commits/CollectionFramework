import java.util.*;

public class SetPractice {

    public static void main(String[] args) {



        HashMap<String,String> map = new HashMap<>();

        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Mango");
        hashSet.add("Apple"); // Duplicate ignored
        hashSet.add(null); // One null allowed
        Object obj = hashSet.toArray();



        System.out.println("HashSet: " + hashSet);


        //LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Dog");
        linkedHashSet.add("Cat");
        linkedHashSet.add("Elephant");






        System.out.println("LinkedHashSet: " + linkedHashSet);

        //TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);

        System.out.println("TreeSet (Natural Order): " + treeSet);

        // Custom comparator (reverse order)
        Set<Integer> reverseTreeSet = new TreeSet<>(Comparator.reverseOrder());
        reverseTreeSet.addAll(treeSet);
        System.out.println("TreeSet (Reverse Order): " + reverseTreeSet);



    }
}
