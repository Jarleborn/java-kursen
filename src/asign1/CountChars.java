package asign1;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.String;
/**
 * Created by Iamha on 2016-09-05.
 */
public class CountChars {

    public static void main(String path) throws IOException {
         //String path = "C:/Users/Iamha/Programmering/java_courses/src/asign1/text.txt";
        FileReader fReader = new FileReader(path);
        BufferedReader bReader = new BufferedReader(fReader);

        String[] text = new String[3];
        int upper = 0;
        int lower = 0;
        int whitsoace = 0;
        int otherChars  = 0;
        int numbers = 0;

        for (int i = 0; i < 3 ; i++) {
            text[i] = bReader.readLine();
            for (int j = 0; j < text[i].length() ; j++) {
                char theChar = text[i].charAt(j);

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

            System.out.println(text[i]);

        }
        System.out.println("Number of uppercase letters: "+ upper);
        System.out.println("Number of lowercase letters: "+ lower);
        System.out.println("Number of digits: "+ numbers);
        System.out.println("Number of whitspaces: "+ whitsoace);
        System.out.println("Number of other characthers: "+ otherChars);
    }
}
