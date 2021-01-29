
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Link :-
 *
 */

public class Template {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();
        do{
            String inputLine = scanner.nextLine();

            mainLogic();

            testCases--;
        }while(testCases>0);
    }

    static public void mainLogic(){


    }

}
