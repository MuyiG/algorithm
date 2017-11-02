package sort;

import java.util.Random;

/**
 * Created by 光 on 2016/11/2.
 */
public class SortUtil {
    private static Random random = new Random(System.currentTimeMillis());

    public static boolean less(Comparable a, Comparable b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] a, int x, int y) {
        if (a == null || x < 0 || x > a.length || y < 0 || y > a.length) {
            throw new IllegalArgumentException();
        }
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void shuffle(Comparable[] a) {
        if (a == null) throw new NullPointerException("argument array is null");
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n-i);     // between i and n-1
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
