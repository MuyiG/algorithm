package sort;

/**
 * Created by 光 on 2016/11/2.
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i; // 细节：记录min的位置，一次内部循环完毕后再执行数组交换操作
            for (int j = i + 1; j < a.length; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortUtil.exchange(a, i, min);
        }
    }
}
