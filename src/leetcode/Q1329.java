package leetcode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * Link :- https://leetcode.com/problems/sort-the-matrix-diagonally/
 *
 */

public class Q1329 {

    public static void main(String[] args){
        int[][] matrix = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        diagonalSort(matrix);
    }

    public static int[][] diagonalSort(int[][] mat) {
        if(mat[0].length==1)
            return mat;

        int[][] result = new int[mat.length][mat[0].length];

        int pointerI=0,pointerJ=0;

        for(int i=0;i<mat[0].length;i++){
            pointerI=i;
            pointerJ=0;

            ArrayList<Integer> arr = new ArrayList<>();

            while(pointerI<mat[0].length && pointerI<mat.length
                    && pointerJ< mat[0].length && pointerJ< mat.length){
                arr.add(mat[pointerI][pointerJ]);

                pointerI+=1;
                pointerJ+=1;
            }

            arr.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer-t1;
                }
            });

            pointerI=i;
            pointerJ=0;
            while(pointerI<mat[0].length && pointerI<mat.length
                    && pointerJ< mat[0].length && pointerJ< mat.length){
                result[pointerI][pointerJ]=arr.get(pointerJ);
                pointerI++;
                pointerJ++;
            }
        }

        for(int i=1;i<mat[0].length;i++){
            pointerI=0;
            pointerJ=i;

            ArrayList<Integer> arr = new ArrayList<>();

            while(pointerI<mat[0].length && pointerI<mat.length
                    && pointerJ< mat[0].length){
                arr.add(mat[pointerI][pointerJ]);

                pointerI+=1;
                pointerJ+=1;
            }

            arr.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer-t1;
                }
            });

            pointerI=0;
            pointerJ=i;
            while(pointerI<mat[0].length && pointerI<mat.length
                    && pointerJ< mat[0].length){
                result[pointerI][pointerJ]=arr.get(pointerI);
                pointerI++;
                pointerJ++;
            }
        }


        return result;
    }

}
