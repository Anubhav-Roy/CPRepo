package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Link :- https://leetcode.com/problems/letter-case-permutation/
 *
 */

public class Q784 {
    public static void main(String[] args){
        String S = "3z4";
        System.out.println(letterCasePermutation(S));
    }



    static public List<String> letterCasePermutation(String S) {
        List<String> results= new ArrayList<>();

        permutations("",S,results);

        return results;
    }

    static private void permutations(String word, String s, List<String> results){

        while(s.length()>1){

            char c = s.charAt(0);

            if(Character.isAlphabetic(c)){
                String newWord = word;
                if(Character.isUpperCase(c)) {
                    newWord += String.valueOf(Character.toLowerCase(c));
                }
                else {
                    newWord += String.valueOf(Character.toUpperCase(c));
                }
                permutations(newWord,s.substring(1), results);
            }

            word += c;
            s = s.substring(1);
        }

        if(s.length()==1)
        {
            char c= s.charAt(0);
            if(Character.isAlphabetic(c)){
                String oldWord = word;
                if(Character.isUpperCase(c)) {
                    word += String.valueOf(Character.toLowerCase(c));
                }
                else {
                    word += String.valueOf(Character.toUpperCase(c));
                }
                results.add(oldWord+c);
            }else{
                word += c;
            }
            results.add(word);
        }
    }

}
