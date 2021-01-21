package leetcode;

import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/reverse-words-in-a-string/
 *
 */

public class Q151 {

    public static void main(String[] args){

        System.out.println(reverseWords("  Bob    Loves  Alice   "));
    }

    public static String reverseWords(String s) {
        s= s.trim()+" ";

        String result="";
        String word = "";
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);

            if(c==' '){
                if(word.equals(""))
                    continue;
                else{
                    result = word + " "+ result;
                    word="";
                }

            }else
                word += c;
        }

        return result;
    }

}
