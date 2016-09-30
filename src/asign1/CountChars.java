package asign1;


import java.io.*;
import java.lang.String;
import java.util.Scanner;

/**
 * Created by Iamha on 2016-09-05.
 */
public class CountChars {

    public static void main(String[] args)  {
        try {
            System.out.println("bajskorv");
            //FileReader fReader = null;
            String path = "/home/hampus/Programmering/java_courses/src/asign1/text.txt";
            //String path = args[0];
            //fReader = new FileReader(path);
            Scanner fileScan = new Scanner(path);


            //BufferedReader bReader = new BufferedReader(fReader);
            //System.out.println(bReader);
            int arrSize = 0;
            System.out.println(fileScan.hasNext());
            while (fileScan.hasNext()){

                if(arrSize % 100000 == 0){
                    System.out.println(arrSize);
                }
                arrSize++;
            }
            System.out.println(arrSize);
            String[] text = new String[arrSize];
            System.out.println(text);
            int upper = 0;
            int lower = 0;
            int whitsoace = 0;
            int otherChars  = 0;
            int numbers = 0;
            int pos = 0;
            System.out.println(upper + ", " + lower + ", " + whitsoace + ", " + otherChars + ", " + numbers + ", " + pos);
            while (fileScan.hasNext()) {
                text[pos] = fileScan.next();
                for (int j = 0; j < text[pos].length() ; j++) {
                    char theChar = text[pos].charAt(j);

                    if(Character.isUpperCase(theChar)){
                        upper++;
                    }
                    else if(Character.isLowerCase(theChar)){
                        lower++;
                    }
                    else if(Character.isDigit(theChar)){
                        numbers++;
                    }
                    else if(Character.isWhitespace(theChar)){
                        whitsoace++;
                    }
                    else{
                        otherChars++;
                    }

                }


                System.out.println(text[pos]);
                pos++;
            }

            System.out.println("Number of uppercase letters: "+ upper);
            System.out.println("Number of lowercase letters: "+ lower);
            System.out.println("Number of digits: "+ numbers);
            System.out.println("Number of whitspaces: "+ whitsoace);
            System.out.println("Number of other characthers: "+ otherChars);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
