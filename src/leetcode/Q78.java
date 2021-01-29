package leetcode;

import java.util.*;

/**
 *
 * Link :-
 *
 */

public class Q78 {

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> arr= new ArrayList<>();
        subs(nums,arr,result);
        return result;
    }

    public static void subs(int[] num,List<Integer> arr,List<List<Integer>> results){


        if(num.length==1){

            List<Integer> newArr = new ArrayList<>();
            newArr.addAll(arr);
            results.add(newArr);

            List<Integer> newArr1 = new ArrayList<>();
            newArr1.addAll(arr);
            newArr1.add(num[0]);
            results.add(newArr1);
            return;
        }

        int firstElement = num[0];
        int[] subArr = Arrays.copyOfRange(num,1,num.length);

        List<Integer> newArr = new ArrayList<>();
        newArr.addAll(arr);
        subs(subArr,newArr,results);

        List<Integer> newArr1 = new ArrayList<>();
        newArr1.addAll(arr);
        newArr1.add(firstElement);
        subs(subArr,newArr1,results);
    }

}
