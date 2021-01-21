package hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Link :- https://www.hackerearth.com/challenges/competitive/january-circuits-21/algorithm/make-them-equal-too-89585e71/
 *
 */

public class MakeStringsEqual {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();
        do{
            String inputLine = scanner.nextLine();

            String a = scanner.nextLine();
            String b = scanner.nextLine();

            mainLogic(a,b);

            testCases--;
        }while(testCases>0);
    }

    public static void mainLogic(String a, String b){

        if(a.length()!=b.length()){
            System.out.println("NO");
            return;
        }

        for(int i =0;i< a.length()-2;i++){
            char aChar = a.charAt(i);

            int firstOccurence = b.indexOf(aChar,i);

            int positionToBeMoved = (firstOccurence-i);

            if(positionToBeMoved==0 && a.equals(b)){
                System.out.println("YES");
                return;
            }else{

                if(positionToBeMoved%2!=0) {
                    String lastTwoCharsOfA = a.substring(a.length() - 2);
                    String flippedLastTwoCharsOfA = String.valueOf(lastTwoCharsOfA.charAt(1)) + String.valueOf(lastTwoCharsOfA.charAt(0));

                    a=a.substring(0,a.length() - 2)+flippedLastTwoCharsOfA;
                }

                String bPrefix = b.substring(0,i);
                String bFirst = b.substring(i,firstOccurence);
                String bSecond = b.substring(firstOccurence+1);

                b= bPrefix+aChar+bFirst+bSecond;

                if(a.equals(b)){
                    System.out.println("YES");
                    return;
                }
            }

        }

        System.out.println("NO");

    }

}
