package asign5;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collector;

/**
 * Created by hampus on 2016-09-21.
 */
public class IdentyfyWordsMain {

    public static void main(String[] args){
        try {
            String directory = "/home/hampus/Programmering/java_courses/src/asign5/HistoryOfProgramming.txt";
            //String directory = args[0];
            File f = new File(directory);

            if(f.isFile()){
                System.out.print("Text" + "\n"+ "====" + "\n");
                Scanner scanner = new Scanner(f);
                String stringToSave = "";
                String wholeString = "";
                while(scanner.hasNextLine()) {
                    String tmpLine = scanner.nextLine();
                    System.out.println(tmpLine);
                    for (int i = 0; i < tmpLine.length() ; i++) {
                        Character tmp = tmpLine.charAt(i);

                        if(Character.isLetter(tmp)){
                            stringToSave+= tmp;
                        }
                        if(tmp == ' ' ){
                            stringToSave+= tmp;
                        }
                    }
                    //System.out.println(stringToSave);
                    wholeString += stringToSave;
                    wholeString += "\n";
                    stringToSave ="";

                }
                System.out.println("\n");
                scanner.close();
                writeToFile(wholeString);
                System.out.print("Sequence of words" + "\n"+ "=================" + "\n");
                System.out.println(wholeString);
                wholeString = "";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void writeToFile(String stringToSave){
        try {
            Writer output = new BufferedWriter(new FileWriter("/home/hampus/Programmering/java_courses/src/asign5/text.txt", false));
            output.append(stringToSave);

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
