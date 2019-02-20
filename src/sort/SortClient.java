package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by 光 on 2016/11/2.
 */
public class SortClient {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input/sort/toBeSorted.txt"))));
        String temp;

        while ((temp = bufferedReader.readLine()) != null) {
            String[] tempStrArr = temp.split(" ");
            Integer[] a = new Integer[tempStrArr.length];
            for (int i = 0; i < tempStrArr.length; i++) {
                a[i] = Integer.valueOf(tempStrArr[i]);
            }
            QuickSort.sort(a);
            if (!SortUtil.isSorted(a)) {
                System.out.println("Sort failed! before: " + temp + " , after:" + printIntegerArray(a));
            }
        }
    }

    private static String printIntegerArray(Integer[] a) {
        String result = "";
        for (Integer i : a) {
            result += (i + " ");
        }
        return result;
    }
}
