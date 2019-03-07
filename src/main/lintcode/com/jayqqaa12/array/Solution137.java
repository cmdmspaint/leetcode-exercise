package com.jayqqaa12.array;

import java.util.Arrays;

/***
 * 找出唯一不重复的数 （重复数会重复3次）
 * <p>
 * 难度 2星
 */
public class Solution137 {

    /**
     * 同 no.136
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {

            if ((i + 1) >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return 0;
    }


    /**
     * 思路2
     * <p>
     * 位操作
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {


        int a = 0, b = 0;

        for (int i = 0; i < nums.length; i +=1) {

            a = (a ^ nums[i]) & ~b;
            b = (a ^ nums[i]) & ~a;

        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution137().singleNumber(new int[]{1,1,1,2,2,2,3,3,3,4,5,5,5,6,6,6}));
        System.out.println(new Solution137().singleNumber(new int[]{1,2,2,2,3,3,3,5,5,5,6,6,6}));
    }
}