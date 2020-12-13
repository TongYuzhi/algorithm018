package com.tyz.sort.core;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = ((right - left) >> 1) + left;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int[] merged = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            merged[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) merged[k++] = nums[i++];
        while (j <= right) merged[k++] = nums[j++];

        System.arraycopy(merged, 0, nums, left, merged.length);
    }
}
