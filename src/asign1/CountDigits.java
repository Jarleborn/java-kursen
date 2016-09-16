package asign1;

import java.util.Scanner;
import java.lang.Integer;

/**
 * Created by Iamha on 2016-09-01.
 */
public class CountDigits {
    public static void main (String[] args)throws NumberFormatException {
        int summer = 0;
        int zeros = 0;
        int odd = 0;
        int eaven = 0;
        try {
            System.out.println("Print a didgit");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            summer = 0;
            zeros = 0;
            odd = 0;
            eaven = 0;

            int parsed = Integer.parseInt(str);
            while(parsed > 0){
                int actionValue = parsed%10;
                parsed = parsed / 10;
                //System.out.println(parsed);
                //System.out.println(actionValue);
                summer += actionValue;
                if (actionValue == 0){
                    zeros++;

                }else if(actionValue % 2 == 0){
                    eaven++;
                }else{
                    odd++;
                }
            }

            System.out.println(zeros + " Zeros");
            System.out.println(odd + " odds");
            System.out.println(eaven+ " not odd");
            System.out.println("And the sum is " + summer);
        } catch (NumberFormatException e) {
            System.out.println("You have to input a number");
        }




    }
}
