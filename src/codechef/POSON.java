package codechef;

import java.util.Scanner;

public class POSON {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        int counter=1;
        scanner.nextLine();
        do{
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            mainLogic(a,b);

            testCases--;
        }while(testCases>0);
    }

    public static void mainLogic(String a,String b){
        if(a.length()!=b.length()){
            System.out.println("No");
            return;
        }

        int onesInA = 0,onesInB=0,difference =0;

        for(int i =0 ; i< a.length();i++){
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);

            if(aChar=='a')
                onesInA += 1;

            if(bChar=='a')
                onesInB += 1;

            if(aChar!=bChar)
                difference+= 1;
        }

        if(onesInA!=onesInB){
            System.out.println("No");
            return;
        }else{
            System.out.println("Yes "+difference/2);
        }

    }

}
