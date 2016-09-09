package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class ArraysMain {
    public static void main(String[] args) {
        Arrays arrays = new Arrays();
        int[] testArray = {1,2,3,4,5};
        int[] testArray2 = {1,1,1,1,1};
        int[] subArray = {6,5,4};
        int testNumber = 2;
        int testNumber2 = 3;


        System.out.println("\nTesting method: \"sum\"\n");
        System.out.println("Sum of all values in array: " + Arrays.sum(testArray));
        System.out.println("\n");


        System.out.println("\nTesting method: \"toString\"\n");
        System.out.println("Values in array: " + Arrays.toString(testArray));
        System.out.println("\n");


        System.out.println("\nTesting method: \"addN\"\n");
        System.out.println("Testnumber: " + testNumber);
        System.out.println("Old values: " + Arrays.toString(testArray));
        System.out.println("New values after addition: " + Arrays.toString(Arrays.addN(testArray, testNumber)));
        System.out.println("\n");


        System.out.println("\nTesting method: \"reverse\"\n");
        System.out.println("Original array: " + Arrays.toString(testArray));
        System.out.println("Reversed array: " + Arrays.toString(Arrays.reverse(testArray)));
         

        
        System.out.println("\nTesting method: \"replaceAll\"\n");
        System.out.println("Old number: " + testNumber2);
        System.out.println("New number: " + testNumber);
        System.out.println("Original array: " + Arrays.toString(testArray));
        Arrays.replaceAll(testArray, testNumber2, testNumber);
        System.out.println("Array after replacement: " + Arrays.toString(testArray));
        System.out.println("\n");


        System.out.println("\nTesting method: \"sort\"\n");
        System.out.println("Original array: " + Arrays.toString(testArray));
        System.out.println("Array after sorting: " + Arrays.toString(Arrays.sort(testArray)));
        System.out.println("\n");


        System.out.println("\nTesting method: \"hasSubsequence\"\n");
        System.out.println("Original array: " + Arrays.toString(testArray));
        System.out.println("Subsequence array: " + Arrays.toString(subArray));
        System.out.println("Answer from hasSubsequence: " + Arrays.hasSubsequence(testArray, subArray));
        System.out.println("\n");


        System.out.println("\nTesting method: \"absDif\"\n");
        System.out.println("First array: " + Arrays.toString(testArray));
        System.out.println("Second array: " + Arrays.toString(testArray2));
        System.out.println("Difference in values between arrays: " + Arrays.toString(Arrays.absDif(testArray, testArray2)));
        System.out.println("\n");
    }

}
