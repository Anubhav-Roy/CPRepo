package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/spiral-matrix/
 *
 */

public class Q54 {

    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args){
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(mat));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowUp=0,rowDown=matrix.length-1,colLeft=0,colRight = matrix[0].length-1;
        int i=0,j=0;

        result.add(matrix[i][j]);
        int directionIndex=0;

        while(rowDown>=rowUp && colLeft<=colRight){

            i+=dir[directionIndex][0];
            j+=dir[directionIndex][1];
            result.add(matrix[i][j]);

            switch (directionIndex){
                case 0:
                    if(j==colRight) {
                        directionIndex = 1;
                        rowUp+=1;
                    }
                    break;
                case 1:
                    if(i==rowDown) {
                        directionIndex = 2;
                        colRight-=1;
                    }
                    break;
                case 2:
                    if(j==colLeft) {
                        directionIndex = 3;
                        rowDown-=1;
                    }
                    break;
                case 3:
                    if(i==rowUp) {
                        directionIndex = 0;


                        colLeft+=1;

                    }
                    break;
            }

        }

        return result;
    }


}
