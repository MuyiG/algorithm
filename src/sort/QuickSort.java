package sort;


/**
 * Created by 光 on 2016/12/16.
 */
public class QuickSort {
    public static void sort(Comparable[] a) {
        SortUtil.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[lo];
        int i = lo, j = hi + 1; // 初始值有讲究，配合后面的++i、--j使用
        while (true) {
            while (++i < hi && a[i].compareTo(pivot) < 0); // ++i还是i++? < hi还是 <= hi < 0还是 <= 0?
            while (--j > lo && a[j].compareTo(pivot) > 0); // > lo 还是 > lo +1?
            if (i >= j) {
                SortUtil.exchange(a, lo, j);
                return j;
            }
            SortUtil.exchange(a, i, j);
        }
    }

}
