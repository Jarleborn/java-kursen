package asign1;

/**
 * Created by hampus on 2016-09-07.
 */
public class Histogram {
    public static void main(String[] args) {

        int[] numbers = {8,7,3,4,5,80,95,100,200,180,60,65,64,54,50,40,43,43,36,23,38,27,33,22,89,76,87,78};

        int max10 = 0;
        int max20 = 0;
        int max30 = 0;
        int max40 = 0;
        int max50 = 0;
        int max60 = 0;
        int max70 = 0;
        int max80 = 0;
        int max90 = 0;
        int max100 = 0;
        int max200 = 0;

        for (int i = 0; i < numbers.length ; i++) {
            if(numbers[i] < 10){
                max10++;
            }
            else if(numbers[i] < 20 && numbers[i] > 10){
                max20++;
            }
            else if(numbers[i] < 30 && numbers[i] > 20){
                max30++;
            }
            else if(numbers[i] < 40 && numbers[i] > 30){
                max40++;
            }
            else if(numbers[i] < 50 && numbers[i] > 40){
                max50++;
            }
            else if(numbers[i] < 60 && numbers[i] > 50){
                max60++;
            }
            else if(numbers[i] < 70 && numbers[i] > 60){
                max70++;
            }
            else if(numbers[i] < 80 && numbers[i] > 70){
                max80++;
            }
            else if(numbers[i] < 90 && numbers[i] > 80){
                max90++;
            }
            else if(numbers[i] < 100 && numbers[i] > 90){
                max100++;
            }
            else if(numbers[i] < 200 && numbers[i] > 100){
                max200++;
            }
        }

        int under100count = max10 + max20 + max30 + max40 + max50 + max60 + max70 + max80 + max90 + max100;

        System.out.println("Reading from an array named numbers");
        System.out.println("Number of numbers between 1 - 100 is: " + under100count );
        System.out.println("Number of numbers between 101 - 200 is: " + max200 );

        System.out.println("Histogram");

        System.out.print("1 - 10 |");
        for (int i = 0; i < max10 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("11 - 20 |");
        for (int i = 0; i < max20 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("21 - 30 |");
        for (int i = 0; i < max30 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("31 - 40 |");
        for (int i = 0; i < max40 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("41 - 50 |");
        for (int i = 0; i < max50 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");


        System.out.print("51 - 60 |");
        for (int i = 0; i < max60 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("61 - 70 |");
        for (int i = 0; i < max70 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("71 - 80 |");
        for (int i = 0; i < max80 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("81 - 90 |");
        for (int i = 0; i < max90 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("91 - 100 |");
        for (int i = 0; i < max100 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("101 - 200 |");
        for (int i = 0; i < max200 ; i++) {
            System.out.print("*");
        }
        System.out.println(" ");
    }
}
