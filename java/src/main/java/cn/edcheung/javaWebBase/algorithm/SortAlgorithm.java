package cn.edcheung.javaWebBase.algorithm;

import java.util.Arrays;

/**
 * SortAlgorithm 排序
 *
 * @author Edward Cheung
 * 2019/5/14
 */
class SortAlgorithm {

    public static void main(String[] args) {
        // 排序
        int[] target = {5, 9, 8, 3, 6, 4, 5, 1, 2};
        SortAlgorithm.selectSort(target);
        System.out.println("选择排序：" + Arrays.toString(target));
        SortAlgorithm.bubbleSort(target);
        System.out.println("冒泡排序：" + Arrays.toString(target));
        SortAlgorithm.insertSort(target);
        System.out.println("插入排序：" + Arrays.toString(target));
        SortAlgorithm.quickSort(target, 0, target.length - 1);
        System.out.println("快速排序：" + Arrays.toString(target));
    }

    // 选择排序
    static void selectSort(int[] target) {
        int maxIndex = target.length - 1; //数组的最大下标
        for (int i = 0; i < maxIndex; i++) {
            int min = i; //存放当前外循环最小元素的数组下标，初始值为当前外循环i的值
            for (int j = i + 1; j <= maxIndex; j++) {
                if (target[j] < target[min]) min = j;
            }
            if (min != i) swap(target, min, i);
        }
    }

    // 冒泡排序
    static void bubbleSort(int[] target) {
        int maxIndex = target.length - 1; //数组的最大下标
        for (int i = 0; i < maxIndex; i++) {
            boolean flag = true; //如果这一趟循环未交换元素，表明当前数组已有序
            for (int j = 0; j < maxIndex - i; j++) {
                //每一趟循环将数组最大的元素排在最后
                if (target[j] > target[j + 1]) {
                    swap(target, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    // 插入排序
    static void insertSort(int[] target) {
        for (int i = 1; i < target.length; i++)
            //每一趟循环结束后，数组前i个元素是有序的
            for (int j = i; j > 0; j--)
                if (target[j] < target[j - 1]) swap(target, j, j - 1);
    }

    // 快速排序
    static void quickSort(int[] target, int low, int high) {
        // quickSort(arr, 0, arr.length -1)
        if (low < high) {
            //每一次划分结束后，唯一确定数组枢纽的位置，左边的元素比枢纽值小，右边的元素比枢纽值大
            int pivotPos = partition(target, low, high);
            quickSort(target, low, pivotPos - 1);
            quickSort(target, pivotPos + 1, high);
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

    // 交换数组元素顺序
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
