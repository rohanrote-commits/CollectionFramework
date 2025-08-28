import java.util.*;
import java.util.stream.Collectors;

public class queuePractice {








    public static void main(String[] args) {


        Queue<String> linkedQueue = new LinkedList();
        linkedQueue.offer("A");
        linkedQueue.add("B"); // if full returns false
        linkedQueue.offer("C");
        linkedQueue.offer("D"); // if full returns false
        System.out.println(linkedQueue);
        System.out.println("Peek : " +linkedQueue.peek()); //returns first if not present returns null
        System.out.println("Poll: "+linkedQueue.poll()); // removes and return first element
        System.out.println(linkedQueue.remove());//of not present returns exception
        System.out.println(linkedQueue.element()); //returns first element if not present gives exception
        System.out.println(linkedQueue);


        //ArraDeque(Fastest for data operations)
        Queue<Integer> linkedQueue2 = new ArrayDeque();
        linkedQueue2.offer(1);
        linkedQueue2.offer(2);
        linkedQueue2.add(3);
        linkedQueue2.add(4);
        linkedQueue2.offer(5);
        linkedQueue2.add(6);


        //Priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Integer o1, Integer o2) -> o2.compareTo(o1));
        priorityQueue.offer(132);
        priorityQueue.offer(21);
        priorityQueue.offer(43);
        priorityQueue.offer(499);


        System.out.println("Priority Queue :" +priorityQueue);

     PriorityQueue<Integer> priorityQueue1 = priorityQueue.stream().sorted((Integer o1, Integer o2) -> o1.compareTo(o2)).collect(Collectors.toCollection(PriorityQueue::new));


    }
}
