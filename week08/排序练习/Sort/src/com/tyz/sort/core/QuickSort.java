package com.tyz.sort.core;

public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        int j = start;

        for (; j < end; j++) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        return i;
    }

}
