package leetcode;

import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/rotate-image/
 *
 */

public class Q48 {

    public static void main(String[] args){
//         int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
         int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
         rotate(matrix);
    }

    static public void rotate(int[][] matrix) {
        int[] topLeft = {0,0};
        int[] topRight = {0,matrix[0].length-1};
        int[] bottomLeft = {matrix.length-1,0};
        int[] bottomRight = {matrix.length-1, matrix[0].length-1};

        int i=0,j=matrix[0].length-1;

        while(i<=j){
            for(int k=0;k<(j-i);k++){
                int oldTopL = matrix[topLeft[0]][topLeft[1]];
                matrix[topLeft[0]][topLeft[1]] = matrix[bottomLeft[0]][bottomLeft[1]];
                matrix[bottomLeft[0]][bottomLeft[1]] = matrix[bottomRight[0]][bottomRight[1]];
                matrix[bottomRight[0]][bottomRight[1]] = matrix[topRight[0]][topRight[1]];
                matrix[topRight[0]][topRight[1]] = oldTopL;

                topLeft[1]+=1;
                topRight[0]+=1;
                bottomLeft[0]-=1;
                bottomRight[1]-=1;
            }
            i++;
            j--;


            topLeft[0]=i;
            topLeft[1]=i;

            topRight[0]=i;
            topRight[1] =j;

            bottomLeft[0] = j;
            bottomLeft[1] =i;

            bottomRight[0]=j;
            bottomRight[1]=j;
        }

    }

}
