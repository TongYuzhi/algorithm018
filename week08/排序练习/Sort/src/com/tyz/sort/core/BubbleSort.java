package com.tyz.sort.core;

public class BubbleSort {

    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isChanged = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
        }
    }
}
