package asign1;

import java.util.Scanner;
import java.lang.String;

/**
 * Created by Iamha on 2016-08-30.
 */
public class Backwards {
    public static void main(String[] args) {
        System.out.println("Print a sentence");
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = sc.nextLine();
        sb.append(str);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
