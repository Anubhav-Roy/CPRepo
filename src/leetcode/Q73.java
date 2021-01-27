package leetcode;

import java.util.Scanner;

/**
 *
 * Link :- https://leetcode.com/problems/set-matrix-zeroes/
 *
 */

public class Q73 {

    public static void main(String[] args){
//       int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
//       int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
       int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

       setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {


        boolean firstRowZero=false;
        boolean firstColumnZero= false;

        for(int i = 0;i< matrix.length;i++){
            if(matrix[i][0]==0)
                firstColumnZero=true;
        }

        for(int i = 0;i< matrix[0].length;i++){
            if(matrix[0][i]==0)
                firstRowZero=true;
        }

        for(int i = 1 ;i < matrix.length;i++){
            for(int j=1;  j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }


        for(int i =1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j = 1; j<matrix.length;j++)
                    matrix[j][i]=0;
            }
        }

        for(int i =1;i<matrix.length;i++){
             if(matrix[i][0]==0){
                 for(int j = 1; j<matrix[0].length;j++)
                     matrix[i][j]=0;
             }
        }

        if(matrix[0][0]==0){
            for(int i =0;i< matrix[0].length;i++)
                matrix[0][i]=0;

            for(int i =0;i< matrix.length;i++)
                matrix[i][0]=0;
        }

        if( firstColumnZero){
            for(int i =0;i< matrix.length;i++)
                matrix[i][0]=0;
        }

        if(firstRowZero){
            for(int i =0;i< matrix[0].length;i++)
                matrix[0][i]=0;
        }

        System.out.println("df");
    }

}
