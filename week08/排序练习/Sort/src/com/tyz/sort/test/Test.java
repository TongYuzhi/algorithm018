package com.tyz.sort.test;

import com.tyz.sort.core.*;

public class Test {

    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 3, 2, 1, 0};

//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.bubbleSort(nums);

//        DirectSwapSort directSwapSort = new DirectSwapSort();
//        directSwapSort.directSwapSort(nums);

//        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.insertionSort(nums);

//        SelectSort selectSort = new SelectSort();
//        selectSort.selectSort(nums);

//        MergeSort mergeSort = new MergeSort();
//        mergeSort.mergeSort(nums);

//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(nums);

//        ShellSort shellSort = new ShellSort();
//        shellSort.shellSort(nums);

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
