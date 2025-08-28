import sun.plugin.javascript.navig.Array;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();

        //common practice data
//        List<String> name = new ArrayList<>(("A","B","C","D","B"));
        List<String> names = new ArrayList<>(Arrays.asList("A","B","C","D","B"));


    arrayList.add("One");
    arrayList.add("Two");
    arrayList.add("Three");
        System.out.println("Size of arrayList: " + arrayList.size());

    arrayList.add(3,"Four");
        System.out.println("Size of arrayList: " + arrayList.size());
        System.out.println(arrayList);


      //get and set
        System.out.println(arrayList.get(3));
        System.out.println(arrayList.contains("One"));
        System.out.println(arrayList.contains("Two"));
        arrayList.remove("One");
        arrayList.remove(2);
        arrayList.set(0,"UpdatedOne");
        System.out.println(arrayList);



        //remove methods
        arrayList.remove("Three");
        System.out.println(arrayList);
        arrayList.addAll(arrayList);
        System.out.println(arrayList);
        arrayList.remove("UpdatedOne");
        System.out.println(arrayList);
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        System.out.println(arrayList);
        arrayList.addAll(list);
        System.out.println(arrayList);
        List<String> list2 = new ArrayList<>();
        list2.add("One");
        list2.add("Three");
        arrayList.removeAll(list2);
        System.out.println(arrayList);

        arrayList.add("three");

        //search method
        System.out.println(arrayList.containsAll(list2));
        System.out.println(arrayList.contains("Two"));
        System.out.println(arrayList.indexOf("UpdatedOne"));
        System.out.println(arrayList.lastIndexOf("Two"));

        System.out.println(arrayList);
        List<String> subList = arrayList.subList(1,3);
        System.out.println(subList);



        //Interation
        System.out.println("Iterators : ");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");

        }

        System.out.println();

     //list iterator
        ListIterator<String> listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println(
        );
        while (listIterator.hasPrevious()) {


            System.out.print(listIterator.previous() + " ");

        }
        System.out.println();


     //Sorting list
        Collections.sort(names);
        System.out.println(names);
        Collections.sort(names,Collections.reverseOrder());
        System.out.println(names);

//        Collections.sort(names,new sortDesc());
        names.sort(Comparator.comparing(String::length));
        System.out.println(names);

        List<Student>  studentList = new ArrayList<>();
        studentList.add(new Student("A",88));
        studentList.add(new Student("B",22));
        studentList.add(new Student("C",222));
        studentList.add(new Student("D",40));
        studentList.add(new Student("E",50));

        System.out.println("Original Student list : ");
        studentList.forEach(student ->
                System.out.println("Age :" + student.age + " Name : " + student.name)
        );
        System.out.println("Sorting by age Student list desc: ");

        studentList.sort((Student s1, Student s2) ->{
           return (s2.age - s1.age);
        });

        Collections.sort(studentList,(student1,student2)-> {
            return (student1.age - student2.age);

        });
        studentList.forEach(student ->
                System.out.println("Age :" + student.age + " Name : " + student.name)
        );


        // sorting according to name
        studentList.sort(new SortByAge());

        studentList.forEach(student ->
                System.out.println("Age :" + student.age + " Name : " + student.name)
        );


        List<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(2);
        numbers.add(31);
        numbers.add(43);
        numbers.add(533);

        //Using comparator(by writing custom comparator in sort function)
        numbers.sort((i,j) -> {
            return i-j;
        });
        System.out.println(numbers);


        //using object of comparator class
        Collections.sort(numbers,new SortDescending());
        System.out.println(numbers);


        //ways to sort
        //using custom comparator in the  sort function of the collection
        studentList.sort((Student s1, Student s2) -> {
            return -(s1.age - s2.age);
        });

        //using comparator interface
        studentList.sort(new SortByAge());
        Collections.sort(studentList,(Student s1, Student s2) -> {
            return s1.age - s2.age;
        });


        //using comparable
        studentList.sort(Student::compareTo);


      //LinkedList special methods
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.add("One");
        linkedList1.add("Two");
        linkedList1.add("Three");
        linkedList1.addFirst("Four");
        linkedList1.addLast("Five");
        System.out.println(linkedList1);

        linkedList1.removeLast();
        System.out.println(linkedList1);
        System.out.println("PeekFirst : " + linkedList1.peekFirst());
        System.out.println("PeekLast : " + linkedList1.peekLast());




    }

}

class SortDescending implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        //we have assumed that the array is sorted
        //now we will returtn the positive value to get descending order
        //this means that the value at right is bigger than value at left

        return o2 - o1;
    }
}


class SortByName implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        return o1.length() -o2.length(); //ascending

    }

}
class SortByAge implements Comparator<Student> {

    @Override
    public int compare(Student o1,Student o2) {

//        return o1.age -o2.age; //ascending(returns negative)
        return o2.age-o1.age;

        //descending because o2 is greater than o1

    }
}

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //sort according to name
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);   //ascending
    }


}