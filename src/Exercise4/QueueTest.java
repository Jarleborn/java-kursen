package Exercise4;

import Inheritance.ArrayIntList;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by hampus on 2016-09-20.
 */
public class QueueTest {
    @Test
    public void size() throws Exception {

        //Put in 88 elements to queue then checking if the size is 88
        Queue q = makeQueue(88);
        assertEquals(88, q.size());
    }

    @Test
    public void isEmpty() throws Exception {

        //Fist check if isEmptyi is true on a empty queue
        Queue q = makeQueue(0);
        assertTrue(q.isEmpty());
        //THen check if isEmptyi is flase on a nonempty queue
        Queue q2 = makeQueue(20);
        assertFalse(q2.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        Queue q = new Queue<>();
        //Trying isEmpty again on an empty queue
        assertTrue(q.isEmpty());

        //trying to add 10000 elements to queue
            for (int i = 0; i < 10000; i++) {
                q.enqueue(i);
            }

        //Checking size
        assertEquals(10000, q.size());
        //testing first
        assertEquals(0, q.first());
    }

    @Test
    public void dequeue() throws Exception {
        Queue q = makeQueue(10);
        //testing to make a queue of size 10 and then dequeue it , and thene we check if its size 9
        q.dequeue();
        assertEquals(9, q.size());
        try {
            for (int i = 0; i < 10 ; i++) {
                q.dequeue();
            }
            assertEquals(-1, q.size());
        } catch (IndexOutOfBoundsException e) {
            //Checking if it trows exception if we dequeue out of index
            assertTrue(true);
        }
        //Checking if its empty after the dequeue session
        assertTrue(q.isEmpty());
    }

    @Test
    public void first() throws Exception {

        //checcking first on filed queue
        Queue q = makeQueue(10);
        assertEquals(0, q.first());

        Queue emptyQ = makeQueue(0);
        //Checking first on empty queue
        try {
            emptyQ.first();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void last() throws Exception {

        //Checking last on filled queue
        Queue q = makeQueue(10);
        assertEquals(9, q.last());
        //Checking last on empty queue
        Queue emptyQ = makeQueue(0);
        try {
            emptyQ.first();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void iterator() throws Exception {

        //checking if iterator has next when its filled
        //Then checking if its starts with 0 as i should
        Queue q = makeQueue(333);
        assertTrue(q.iterator().hasNext());
        assertEquals(0, q.iterator().next());

        int[] test = new int[333];
        for (int i = 0; i < test.length ; i++) {
            test[i] = i;
        }
        //Checking if size is right
        assertTrue(q.size() == test.length);

        for (int i = 0; i < 333; i++) {
            assertEquals(q.first(), test[i]);
            q.dequeue();
        }

        //checking if hasNext when completly dequed
        assertFalse(q.iterator().hasNext());

        try{
            q.iterator().next();
        }
        catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }


    }

    //Method for making queue as for test porpuse
    public Queue makeQueue(int size) {
        Queue queue = new Queue<>();
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        return queue;
    }
}