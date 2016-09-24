package asign5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by hampus on 2016-09-24.
 */
public class WordCount2Main {

    public static void main(String[] args){
        HashWordSet _hashSet = new HashWordSet();
        TreeWordSet _treeSet = new TreeWordSet();

        String directory = "/home/hampus/Programmering/java_courses/src/asign5/text.txt";
        File f = new File(directory);


        if(f.isFile()){
            try{
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

            //String tmp = _treeSet.toString();
            System.out.println(_treeSet.size() + " Treesize");
            System.out.println(_hashSet.size() + " Haschsize");

            Iterator treeIterator = _treeSet.iterator();
            Iterator hashIterator = _hashSet.iterator();

            while (treeIterator.hasNext()){
                System.out.println(treeIterator.next());
            }

                System.out.println("\n \n \n");
               while (hashIterator.hasNext()){
                   System.out.println(hashIterator.next());
               }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }
    }
}
