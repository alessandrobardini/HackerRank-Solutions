import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        if(s.length()==0)
            System.out.println("0");
        else if(s.length()>400000){
            System.out.println("");
        }
        else{
        String arr[] = s.split("[!,?._'@\\s]+");
        System.out.println(arr.length);
        for(String i: arr){
            System.out.println(i);
        }
        }
        scan.close();
    }
}

