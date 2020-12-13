package com.tyz.sort.core;

import java.util.HashMap;

public class HeapSort {
    public void heapSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;

        for (int i = (len >> 1) - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int len, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, len, largest);
        }
    }
}
