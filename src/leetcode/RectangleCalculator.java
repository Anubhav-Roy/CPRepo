package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class RectangleCalculator {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[][] rectangles = {{2,3},{3,7},{4,3},{3,7}};

        System.out.println(countGoodRectangles(rectangles));

    }

    public static int countGoodRectangles(int[][] rectangles) {
        int maxLength  = -1;
        int maxLengthCount = 0;

        for(int i =0; i<rectangles.length ; i++){

            int maxSquare = Math.min(rectangles[i][0],rectangles[i][1]);

            if(maxLength< maxSquare){
                maxLength=maxSquare;
                maxLengthCount=1;
            }else if(maxLength== maxSquare){
                maxLengthCount++;
            }

        }
        return maxLengthCount;
    }

}
