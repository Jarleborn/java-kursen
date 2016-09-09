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
        while (numberK + count <= numberN){
            numberK +=2;
            count+=numberK;
            if(count > numberN){
                numberK -=2;
                break;
            }


        }
        System.out.println("Your number: " + numberN);
        System.out.println("The K number : " + numberK);
    }
}
