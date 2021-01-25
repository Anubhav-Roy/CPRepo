package leetcode;

import java.util.Scanner;

/**
 *
 * Link :-
 *
 */

public class Q238 {

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }

    public static int[] productExceptSelf(int[] nums) {
        if(nums.length <=1)
            return nums;
        int[] res = new int[nums.length];
        res[0] = 1;
        res[1] = nums[0];
        int hold = nums[0]*nums[1];
        for(int i = 2; i < nums.length;i++){
            res[i] = hold;
            hold*=nums[i];
        }
        hold = nums[nums.length-1];
        for(int i = res.length-2;i >=0;i--){
            res[i]*=hold;
            hold*=nums[i];
        }
        return res;
    }

}
