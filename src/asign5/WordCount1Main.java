package asign5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by hampus on 2016-09-22.
 */
public class WordCount1Main {
    private static HashSet<Word> _hashSet = new HashSet<>();
    private static TreeSet<Word> _treeSet = new TreeSet<>();

    public static void main(String[] args){
            String directory = "/home/hampus/Programmering/java_courses/src/asign5/text.txt";
            File f = new File(directory);
            if(f.isFile()){
                readWords(f);
            }
    }

    public static void readWords(File f){
        try {
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()) {
                String tmpLine = scanner.nextLine();
                String[] words = tmpLine.split(" ");
                for(String word : words){
                    Word w = new Word(word.toLowerCase());
                    _hashSet.add(w);
                    _treeSet.add(w);
                }
            }
            scanner.close();
            System.out.println(_treeSet.size());
            System.out.println(_hashSet.size());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
