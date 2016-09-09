package asign1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by hampus on 2016-09-08.
 */
public class CountJava {
    public static void main(String[] args){
        try {
            //String directory = "/home/hampus/Programmering/java_courses/src/asign1/";
            String directory = args[0];
            System.out.println("Läser från " + directory);
            File folder = new File(directory);
            fileLister(folder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void fileLister (File folder) throws FileNotFoundException{
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                int lines = 0;
                System.out.print("File " + file.getName());
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()) {
                    scanner.nextLine();
                    lines++;
                }
                scanner.close();
                System.out.println("- " +lines+ " rader");
            }
            else{
                if(file.isDirectory()){
                    fileLister(file);
                }
            }
        }
    }



}
