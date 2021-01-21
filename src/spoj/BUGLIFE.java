package spoj;

/**
 *
 * https://www.spoj.com/PARIS01/problems/BUGLIFE/
 *
 * Professor Hopper is researching the sexual behavior of a rare species of bugs.
 * He assumes that they feature two different genders and that they only interact with bugs
 * of the opposite gender. In his experiment, individual bugs and their interactions were
 * easy to identify, because numbers were printed on their backs.
 *
 * Given a list of bug interactions, decide whether the experiment supports his assumption
 * of two genders with no homosexual bugs or if it contains some bug interactions
 * that falsify it.
 *
 *
 * Input:
 * 2
 * 3 3
 * 1 2
 * 2 3
 * 1 3
 * 4 2
 * 1 2
 * 3 4
 *
 * Output:
 * Scenario #1:
 * Suspicious bugs found!
 * Scenario #2:
 * No suspicious bugs found!
 *
 *
 * 1
 * 4 2
 * 1 3
 * 2 4
 */

import java.util.HashMap;
import java.util.Scanner;

public class BUGLIFE {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        int counter=1;
        scanner.nextLine();
        do{
            String inputLine = scanner.nextLine();
            String[] inputLineSplit = inputLine.trim().split(" ");

            int numberOfBugs =Integer.parseInt(inputLineSplit[0]);
            int numberOfInteractions =Integer.parseInt(inputLineSplit[1]);

            String[] interactions = new String[numberOfInteractions];

            for(int i =0;i<numberOfInteractions;i++)
                interactions[i]=scanner.nextLine();

            System.out.println("Scenario #"+counter+":");
            bugInteractions(numberOfBugs,interactions);

            testCases--;
        }while(testCases>0);
    }

    public static void bugInteractions(int numberOfBugs,String[] interactions){

        HashMap<Integer,Boolean> males = new HashMap<>();
        HashMap<Integer,Boolean> females = new HashMap<>();

        for(String interaction : interactions){
             String[] interactionSplit = interaction.trim().split(" ");
             int firstBug = Integer.parseInt(interactionSplit[0]);
             int secondBug = Integer.parseInt(interactionSplit[1]);

             if(males.containsKey(firstBug)){
                 //Then the second bug has to be a female
                 //Check if the second bug is in the male list.
                 boolean secondBugIsMale = males.containsKey(secondBug);

                 if(secondBugIsMale){
                     //This is an heterosexual interaction
                     System.out.println("Suspicious bugs found!");
                     return;
                 }else{
                     //Enter the second bug into the female list
                     females.put(secondBug,true);
                 }
             }else if(females.containsKey(firstBug)){
                 //Then the second bug has to be a male
                 //Check if the second bug is in the female list.
                 boolean secondBugIsFemale = females.containsKey(secondBug);

                 if(secondBugIsFemale){
                     //This is an heterosexual interaction
                     System.out.println("Suspicious bugs found!");
                     return;
                 }else{
                     //Enter the second bug into the male list
                     males.put(secondBug,true);
                 }
             }else if(males.containsKey(secondBug)){
                 //Then the first bug has to be a female
                 //Check if the first bug is in the male list.
                 boolean firstBugIsMale = males.containsKey(firstBug);

                 if(firstBugIsMale){
                     //This is an heterosexual interaction
                     System.out.println("Suspicious bugs found!");
                     return;
                 }else{
                     //Enter the second bug into the female list
                     females.put(firstBug,true);
                 }
             }else if(females.containsKey(secondBug)){
                 //Then the first bug has to be a male
                 //Check if the first bug is in the female list.
                 boolean firstBugIsFemale = females.containsKey(firstBug);

                 if(firstBugIsFemale){
                     //This is an heterosexual interaction
                     System.out.println("Suspicious bugs found!");
                     return;
                 }else{
                     //Enter the second bug into the male list
                     males.put(firstBug,true);
                 }
             }else{
                 //Both are unrecorded bugs
                 //Randomnly register the bugs
                 males.put(firstBug,true);
                 females.put(secondBug,true);
             }
        }

        System.out.println("No suspicious bugs found!");
    }


}
