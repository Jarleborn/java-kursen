package asign1;

/**
 * Created by Iamha on 2016-09-05.
 */
public class Arrays {


    public static int sum(int[] arr){
        int summer = 0;
        for (int i = 0; i < arr.length ; i++) {
            summer += arr[i];
        }
        return summer;

    }
    public static String toString(int[] arr){
        String theString = "";
        for (int i = 0; i < arr.length ; i++) {
            theString += arr[i];
        }

        return theString;
    }
    public static int[] addN(int[] arr, int n){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] += n;

        }
        return arr;
    }
    public static int[] reverse(int[] arr){
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int place = arr.length - i -1;

            reversed[i] = arr[place];
        }

        return reversed;
    }

    public static void replaceAll(int[] arr, int old, int nw){
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == old){
                arr[i] = nw;

            }
        }

    }

    public static int[] sort(int[] arr){

        int[] sorted = new int[arr.length];
        boolean flick = true;
        int holder;
        for (int i = 0; i < arr.length ; i++) {
            sorted[i] = arr[i];
        }

        while(flick){
            flick = false;
            for (int i = 0; i < sorted.length ; i++) {

                if(i > 0) {
                    if (sorted[i] < sorted[i - 1]) {
                        holder = sorted[i];
                        sorted[i] = sorted[i - 1];
                        sorted[i - 1] = holder;
                        flick = true;
                    }
                }
            }
        }

        return sorted;
    }

    public static boolean hasSubsequence(int[] arr, int[] sub){
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == sub[0]){
                for (int j = 0; j < sub.length; j++) {
                    if(i + j >= arr.length){
                        break;
                    }
                    if(arr[i + j] == sub[j]){
                        count++;
                        if(count == sub.length){
                            return true;
                        }

                    }
                }
            }
        }

        return false;
    }


    public static int[] absDif(int[] arr1,int[] arr2){
        int[] diffArray = new int[arr1.length];
        if(arr1.length == arr2.length){
            for(int i = 0; i < arr1.length; i++){
                diffArray[i] = Math.abs(arr1[i] - arr2[i]);
            }
            return diffArray;
        }
        else{
            System.out.print("The two arrays must be the same size!");
            return null;
        }
    }

}
