package com.tyz.sort.core;

public class ShellSort {

    public void shellSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;

        for (int gap = len >> 1; gap > 0; gap = gap >> 1) {
            for (int index = gap; index < len; index++) {
                insertionSort(nums, gap, index);
            }
        }
    }

    private void insertionSort(int[] nums, int gap, int i) {
        int value = nums[i];
        int j;

        for (j = i - gap; j >= 0 && nums[j] > value; j -= gap) {
            nums[j + gap] = nums[j];
        }
        nums[j + gap] = value;
    }
}
