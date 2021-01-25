package leetcode;

import java.util.Scanner;

/**
 *
 * Link :-
 *
 */

public class Q1437 {

    public static void main(String[] args){
         int[] nums = {0,1,0,1};
        System.out.println(kLengthApart(nums,1));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int i = 0;
        int firstOne=-1;
        int minLen = nums.length;
        while (i < nums.length) {
           if(nums[i]==1){
               if (firstOne != -1) {
                   int len = i - firstOne - 1;
                   if (len < minLen)
                       minLen = len;
               }
               firstOne=i;
           }
           i++;
        }

        if(minLen<k)
            return false;
        else
            return true;
    }

}
