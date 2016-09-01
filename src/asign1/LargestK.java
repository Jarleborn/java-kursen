package asign1;

import java.util.Scanner;
/**
 * Created by Iamha on 2016-08-30.
 */

public class LargestK{
    public static void main(String[] args) {
        System.out.println("Print a number");
        Scanner sc = new Scanner(System.in);
        int numberN = Integer.parseInt(sc.nextLine());
        int numberK = 0;
        int count = 0;
        int counter = 0;
        while (numberK < numberN-2){
            count++;
            counter+=2;
            numberK += counter;
            System.out.println(numberK);
            System.out.println(counter);
        }

    }
}
