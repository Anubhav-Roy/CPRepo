package hackerearth;

import java.util.Scanner;

/**
 *
 * Link :- https://www.hackerearth.com/challenges/competitive/january-circuits-21/algorithm/chessboard-2-8f06e380/
 *
 */

public class ChessBoard {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();
        do{
            String firstKing = scanner.nextLine();
            String secondKing = scanner.nextLine();

            mainLogic(firstKing,secondKing);

            testCases--;
        }while(testCases>0);
    }

    public static void mainLogic(String firstKing, String secondKing){

        String[] firstKingSplit = firstKing.trim().split(" ");
        String[] secondKingSplit = secondKing.trim().split(" ");

        int firstKingX = Integer.parseInt(firstKingSplit[0]);
        int firstKingY = Integer.parseInt(firstKingSplit[1]);

        int secondKingX = Integer.parseInt(secondKingSplit[0]);
        int secondKingY = Integer.parseInt(secondKingSplit[1]);

        if(secondKingY==firstKingY && secondKingX == firstKingX) {
            System.out.println("SECOND");
            return;
        }

        boolean inKillRange = (Math.abs(firstKingX-secondKingX)<=1 &&
                Math.abs(firstKingY-secondKingY)<=1);

        if(inKillRange){
            System.out.println("FIRST");
            return;
        }

        System.out.println("DRAW");
    }

    public static boolean isCornered(int x,int y){
        boolean status=false;

        if(x==1 && y==1)
            status=true;
        else if(x==8 && y==1)
            status=true;
        else if(x==1 && y==8)
            status=true;
        else if(x==8 && y==8)
            status=true;

        return status;
    }

}
