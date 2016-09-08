package asign1;


import java.io.*;

/**
 * Created by hampus on 2016-09-08.
 */
public class CountJava {
    public static void main(String[] args){
        File folder = new File("/home/hampus/Programmering/java_courses/src/asign1/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

}
