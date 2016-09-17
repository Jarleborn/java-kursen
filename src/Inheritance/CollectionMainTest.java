package Inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hampus on 2016-09-17.
 */
public class CollectionMainTest  {

        @Test
        public void testAdd(){

            System.out.println("Creating lists");
            ArrayIntList list1 = createList(25);
            ArrayIntList list2 = createList(10000);
            System.out.println("Creating lists size after add");

            list1.add(8);
            list2.add(8);
            assertEquals(list1.size(), 26);
            assertEquals(list2.size(), 10001);

            System.out.println("Check if empty");

            assertFalse(list1.isEmpty());
            assertFalse(list2.isEmpty());


        }

        @Test
        public void testAddAt(){
            System.out.println("Creating lists one with vale 25 and one with value 10000");
            ArrayIntList list1 = createList(25);
            ArrayIntList list2 = createList(10000);

            System.out.println("Testing to add 5 at index five in both lists");
            list1.addAt(5, 5);
            list2.addAt(5, 5);


            assertEquals(26, list1.size());
            assertEquals(10001, list2.size());

            System.out.println("Trying to ad 5 at an index put of bound");

            try{
                list1.addAt(5, 100);
            }
            catch (IndexOutOfBoundsException e){
                assertTrue(true);
            }


        }

        @Test
        public void testRemove(){
            ArrayIntList list = createList(5);
            System.out.println("Create list with length of 5");

            System.out.println("test to remove element at position 1");

            list.remove(1);

            assertEquals(4, list.size());

            System.out.println("Testing to remove at non existing index");

            list.remove(8);
            assertNotEquals(7, list.size());
        }

        @Test
        public void testGet(){
            ArrayIntList list = createList(5);
            System.out.println("Create list with length of 5");
            System.out.println("Testing to get value at index 4");

            int res = list.get(4);
            assertEquals(4, res);

            System.out.println("testing to get value at nonecsitning index");
            try {
                int res2 = list.get(8);
            } catch (IndexOutOfBoundsException e) {
                assertTrue(true);
            }

        }

        @Test
        public void testIndexOf(){
            System.out.println("Create list with values between 1 -5");
            ArrayIntList list = createList(5);
            System.out.println("Getting index och number 3");
            int res = list.indexOf(3);
            assertEquals(3, res);

            System.out.println("Getting index och number 6");
            int res2 = list.indexOf(6);
            assertEquals(-1, res2);
        }



        //Test Stack

        @Test
        public void testPush(){
            ArrayIntStack stack = createStack(5);
            System.out.println("Create stack");
            stack.push(4);

            assertEquals(6, stack.size());
            System.out.println("Adding Number and checking size");

            System.out.println("Checking if empty");
            assertFalse(stack.isEmpty());
        }

        @Test
        public void testPop(){
            System.out.println("create stack with values beetween 1 - 5");
            ArrayIntStack stack = createStack(5);
            System.out.println("Test pop");
            stack.pop();
            assertEquals(4, stack.size());

            try {
                System.out.println("test to pop it more than the size");
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();

                assertEquals(-1, stack.size());
            } catch (IndexOutOfBoundsException e) {
                assertTrue(true);
            }

        }

        @Test
        public void testPeek(){
            System.out.println("create stack with values beetween 0 - 4");
            ArrayIntStack stack = createStack(5);

            assertEquals(4, stack.peek());
        }



        public ArrayIntList createList(int theSize){

            ArrayIntList theList = new ArrayIntList();

            for (int i = 0; i < theSize ; i++) {
                theList.add(i);
            }

            return theList;
        }

    public ArrayIntStack createStack(int theSize){

        ArrayIntStack theStack = new ArrayIntStack();

        for (int i = 0; i < theSize ; i++) {
            theStack.push(i);
        }

        return theStack;
    }
    }

