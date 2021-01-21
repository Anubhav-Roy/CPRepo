package hackerearth;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Link :-https://www.hackerearth.com/challenges/competitive/january-circuits-21/algorithm/tournament-and-ranks-67cd4b7e/
 *
 * 1
 * 4 1
 * 2 1 1 5
 * 2 3
 */

public class ScoreboardQueries {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();
        do{
            String inputLine = scanner.nextLine();
            String[] inputLineSplit = inputLine.trim().split(" ");

            int n = Integer.parseInt(inputLineSplit[0]);
            int q = Integer.parseInt(inputLineSplit[1]);

            String arrInput = scanner.nextLine();
            String[] arrInputSplit = arrInput.trim().split(" ");
            int[] arr = new int[n];
            for(int i =0 ;i < n;i++){
                arr[i] = Integer.parseInt(arrInputSplit[i]);
            }

            String[] updateArr = new String[q];
            for(int i =0 ; i <q ; i++){
                updateArr[i] = scanner.nextLine();
            }

            mainLogic(arr,updateArr);

            testCases--;
        }while(testCases>0);
    }

    public static void mainLogic(int[] scoreArray, String[] updateArr){

        HashMap<Integer,Integer> scoreFreq = new HashMap<>();

        for(int score:scoreArray){
            if(scoreFreq.containsKey(score))
                scoreFreq.put(score,scoreFreq.get(score)+1);
            else
                scoreFreq.put(score,1);
        }

        for(String updateOp:updateArr){
            String[] updateOpSplit = updateOp.split(" ");
            int index = Integer.parseInt(updateOpSplit[0].trim());
            int value = Integer.parseInt(updateOpSplit[1].trim());

            int previousValue = scoreArray[index-1];
            scoreArray[index-1]=value;

            int previousFreq= scoreFreq.get(previousValue);
            if(previousFreq==1)
                scoreFreq.remove(previousValue);
            else
                scoreFreq.put(previousValue,scoreFreq.get(previousValue)-1);

            if(scoreFreq.containsKey(value))
                scoreFreq.put(value,scoreFreq.get(value)+1);
            else
                scoreFreq.put(value,1);

            System.out.println(scoreFreq.keySet().size()+1);

        }
    }

}
/**
 1
 3 5
 1 2 3
 1 2
 3 2
 1 5
 2 4
 3 4
 */