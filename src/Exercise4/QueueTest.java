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
        Queue q = makeQueue(88);
        assertEquals(88, q.size());
    }

    @Test
    public void isEmpty() throws Exception {
        Queue q = makeQueue(0);
        assertTrue(q.isEmpty());
        Queue q2 = makeQueue(20);
        assertFalse(q2.isEmpty());
    }

    @Test
    public void enqueue() throws Exception {
        Queue q = new Queue<>();
        assertTrue(q.isEmpty());
            for (int i = 0; i < 10000; i++) {
                q.enqueue(i);
            }
        assertEquals(10000, q.size());
        assertEquals(0, q.first());
    }

    @Test
    public void dequeue() throws Exception {
        Queue q = makeQueue(10);
        q.dequeue();
        assertEquals(9, q.size());
        try {
            for (int i = 0; i < 10 ; i++) {
                q.dequeue();
            }
            assertEquals(-1, q.size());
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
        assertTrue(q.isEmpty());
    }

    @Test
    public void first() throws Exception {
        Queue q = makeQueue(10);
        assertEquals(0, q.first());

        Queue emptyQ = makeQueue(0);
        try {
            emptyQ.first();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void last() throws Exception {
        Queue q = makeQueue(10);
        assertEquals(9, q.last());

        Queue emptyQ = makeQueue(0);
        try {
            emptyQ.first();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void iterator() throws Exception {
        Queue q = makeQueue(333);
        assertTrue(q.iterator().hasNext());
        assertEquals(0, q.iterator().next());

        int[] test = new int[333];
        for (int i = 0; i < test.length ; i++) {
            test[i] = i;
        }
        assertTrue(q.size() == test.length);
        for (int i = 0; i < 333; i++) {
            assertEquals(q.first(), test[i]);
            q.dequeue();
        }

        assertFalse(q.iterator().hasNext());

        try{
            q.iterator().next();
        }
        catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }


    }

    public Queue makeQueue(int size) {
        Queue queue = new Queue<>();
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        return queue;
    }
}