package asign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by hampus on 2016-09-22.
 */
public class WordCount1Main {

    public static void main(String[] args){

        try {
            String directory = "/home/hampus/Programmering/java_courses/src/asign5/text.txt";
            //String directory = args[0];
            File f = new File(directory);

            if(f.isFile()){
                Scanner scanner = new Scanner(f);
                int wordCount = 0;
                while(scanner.hasNextLine()) {
                    String tmpLine = scanner.nextLine();
                        String[] words = tmpLine.split(" ");
                        for(String word : words){
                            if(!word.isEmpty()){
                                wordCount++;
                                System.out.println(word);
                            }

                            //INga dubleter bre!!!!!!!s
                        }
                }

                scanner.close();
                System.out.println(wordCount);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
