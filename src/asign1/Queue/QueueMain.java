package asign1.Queue;

import java.util.Iterator;

/**
 * Created by hampus on 2016-09-10.
 */
public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        int amountOfElements = 15;
        int testValue1 = 6;
        int testValue2 = 3;

        for(int i = 0; i < amountOfElements; i++) {
            queue.enqueue(i);
        }

        Iterator<Object> iterator = queue.iterator();
        System.out.println("\nValues in queue: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }

        System.out.println("\nSize of queue: " + queue.size());
        System.out.println("\nFirst value in queue: " + queue.first());
        System.out.println("\nLast value in queue: " + queue.last());
        System.out.println("\nTrying the  \"dequeue\" method \nResponse value: " + queue.dequeue());
        System.out.println("\nFirst value is now: " + queue.first());
        System.out.println("\nLast value is now: " + queue.last());
        System.out.println("\nTrying the \"contains\" method \n...with the value of '4' - Found object: " + queue.contains(testValue1));
        System.out.println("\n...with the value of '3' -  Found object: " + queue.contains(testValue2));
        System.out.println("\nTrying to \"dequeue\" until the queue is empty\n");
        while(!queue.isEmpty()){
            System.out.println("\nDequeue response (value): " + queue.dequeue());
            System.out.println("Queue size after dequeue: " + queue.size() );
        }
        System.out.println("\nTrying the \"isEmpty\" method\nAnswer (True/False): " + queue.isEmpty());
    }
}
