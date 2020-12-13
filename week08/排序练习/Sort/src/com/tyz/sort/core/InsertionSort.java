package com.tyz.sort.core;

public class InsertionSort {

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int value = nums[i];
            for (; j >= 0 && nums[j] > value; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = value;
        }
    }
}
