package asign1;

/**
 * Created by Iamha on 2016-09-01.
 */

import java.util.Scanner;


public class Diamond {
    public static void main(String[] args) throws NumberFormatException{
        System.out.println("Enter an odd number");
        try {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();


            int number = Integer.parseInt(str);

            if ( number %2 != 0) {
                for (int i = 0; i < number ; i++) {
                    if(i % 2 != 0){
                        for(int k = 0; k < (number-i)/2; k++){
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {

                            System.out.print("*");
                        }
                        System.out.println(" ");

                    }
                }

                for (int i = 0; i < number ; i++) {
                    System.out.print("*");
                }
                System.out.println(" ");
                for (int i = number-1; i < number && i > 0; i-=1) {
                    if(i % 2 != 0){
                        for(int k = 0; k < (number-i)/2; k++){
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");

                    }
                }
            }else {
                System.out.println("No no no that's not an odd number!!");
            }
        } catch (NumberFormatException e) {
            System.out.print("EY! That's not eaven a number");
        }
    }
}
