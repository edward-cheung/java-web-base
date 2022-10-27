package cn.edcheung.javaWebBase.algorithm;

import java.util.Arrays;

public class TopK {

    public static void main(String[] args) {
        int[] target = {5, 9, 8, 3, 6, 4, 5, 1, 2};
        TopK.quickSort(target, 0, target.length - 1, 5);
        System.out.println("快速排序：" + Arrays.toString(target));
    }

    static void quickSort(int[] target, int low, int high, int k) {
        // quickSort(arr, 0, arr.length -1)
        if (low < high) {
            //每一次划分结束后，唯一确定数组枢纽的位置下标，左边的元素比枢纽值小，右边的元素比枢纽值大
            int pivotIndex = partition(target, low, high);
            int num = high - pivotIndex + 1;
            if (num == k) return;
            if (num < k) {
                quickSort(target, low, pivotIndex - 1, k - num);
            } else {
                quickSort(target, pivotIndex + 1, high, k);
            }
        }
    }

    // 快速排序划分算法
    private static int partition(int[] target, int low, int high) {
        int pivot = target[low]; //将当前表中第一个元素作为枢纽值
        while (low < high) {
            while (low < high && target[high] >= pivot) --high;
            target[low] = target[high];
            while (low < high && target[low] <= pivot) ++low;
            target[high] = target[low];
        }
        target[low] = pivot;
        return low; //返回枢纽值的下标
    }
}
