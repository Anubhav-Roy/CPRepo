package hackerearth;

/**
 *
 * Link :- https://www.hackerearth.com/challenges/competitive/january-circuits-21/algorithm/make-them-equal-ac0bab4a/
 *
 * Test Case
 * 3
 * 4
 * abc?
 * abc?
 * 4
 * aab?
 * a?aa
 * 5
 * aaa?a
 * bbbb?
 *
 */

import java.util.HashMap;
import java.util.Scanner;

public class ReplaceString {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

//        mainLogic(4,"abc?","abc?");
        int testCases = scanner.nextInt();

        scanner.nextLine();
        do{
            String inputLine = scanner.nextLine();
            int length= Integer.parseInt(inputLine);

            String a = scanner.nextLine();
            String b = scanner.nextLine();

            mainLogic(length,a,b);

            testCases--;
        }while(testCases>0);
    }

    public static void mainLogic(int length, String a, String b){

        HashMap<Character,Integer> aChars = new HashMap<>();
        HashMap<Character,Integer> bChars = new HashMap<>();

        if(a.length()!=b.length()){
            System.out.println("NO");
            return;
        }

        for(int i=0; i < a.length();i++){
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);

            if(aChars.containsKey(aChar)){
                int count = aChars.get(aChar);
                aChars.put(aChar,count+1);
            }else
                aChars.put(aChar,1);


            if(bChars.containsKey(bChar)){
                int count = bChars.get(bChar);
                bChars.put(bChar,count+1);
            }else
                bChars.put(bChar,1);
        }

        int difference=0;
        for(Character key : aChars.keySet()){
            int aCharFreq = aChars.get(key);
            int bCharFreq = (bChars.containsKey(key))? bChars.get(key):0;

            difference += Math.abs(aCharFreq-bCharFreq);

            if(difference>2){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

}
