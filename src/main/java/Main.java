

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(getMaxSum(nums));
        System.out.println(getMaxSumAnd(nums));
    }
    public static int getMaxSum(int[] nums){
        int max = nums[0];
        int pre = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; i++) {
            int cur = nums[i];
            if(cur + pre > cur){
                pre += cur;
            }else {
                pre = cur;
            }
            if(pre >max){
                max = pre;
            }
        }
        return max;
    }

    public static int getMaxSumAnd(int[] nums){
        int max = nums[0];
        int pre = nums[0];
        int length = nums.length;
        int maxIndex = 0;
        Integer[][] records = new Integer[length][length];
        records[0][0] = nums[0];
        for (int i = 1; i < length; i++) {
            int cur = nums[i];
            if(cur + pre > cur){
                pre += cur;
                records[i] = Arrays.copyOf(records[i-1],length);
                records[i][i] = cur;
            }else {
                records[i] = new Integer[length];
                records[i][i] = cur;
                pre = cur;
            }
            if(pre >max){
                maxIndex = i;
                max = pre;
            }
        }
        System.out.println(Arrays.toString(records[maxIndex]));
        return max;
    }

}