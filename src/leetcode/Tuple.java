package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class Tuple {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int[] nums = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192};

        System.out.println(tupleSameProduct(nums));
    }

    static HashMap<Integer,Integer> facts = new HashMap<>();
    public static  int tupleSameProduct(int[] nums) {

        int sum=0;
        HashMap<Integer,Integer> productCount = new HashMap<>();

        for(int i= 0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                int product = nums[i] * nums[j];

                if(productCount.containsKey(product)){
                    int count = productCount.get(product);
                    count++;
                    productCount.put(product,count);
                }else
                    productCount.put(product,1);
            }
        }

        for(Integer key : productCount.keySet()){
            if(productCount.get(key)==1)
                continue;
            System.out.println("Factorial "+productCount.get(key)+" is "+factorial(productCount.get(key)));
            System.out.println("Key "+key);
            sum += factorial(productCount.get(key))*4;
            System.out.println("Sum "+sum);
        }

        return sum;
    }

    static int factorial(int number){
        if(number==1)
            return 0;
        if(facts.containsKey(number))
            return facts.get(number);

        int factorial=1;

        for(int i=number;i>=1;i--){
            factorial*=i;
        }
        facts.put(number,factorial);

        return factorial;
    }


}
