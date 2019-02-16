package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 蓄水池抽样算法，参考：https://www.jianshu.com/p/7a9ea6ece2af
 * 蓄水池抽样的O(N)时间复杂度，O(m)空间复杂度令其适用于对流数据、大数据集的等概率抽样。比如一个大文本数据，随机输出其中的几行。
 */
public class ReservoirSampling {

    /**
     * 算法核心
     *
     * @param dataStream 用有限的数组来模拟一个很大的数据流，遍历完成前其size未知
     * @param sampleSize 需要抽样的个数
     */
    public static int[] sample(int[] dataStream, int sampleSize) {
        int[] result = new int[sampleSize];
        Random random = new Random();
        for (int i = 0; i < dataStream.length; i++) {
            if (i < sampleSize) {
                result[i] = dataStream[i];
            } else {
                int r = random.nextInt(i + 1);
                if (r < sampleSize) {
                    result[r] = dataStream[i];
                }
            }
        }
        return result;
    }

    private static void test() {
        int dateStreamSize = 100, sampleSize = 10;
        int[] dataStream = new int[dateStreamSize];
        for (int i = 0; i < dateStreamSize; i++) {
            dataStream[i] = i;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            int[] sample = sample(dataStream, sampleSize);
            for (int temp : sample) {
                countMap.merge(temp, 1, (a, b) -> a + b);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void testRandom() {
        Random random = new Random();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            int temp = random.nextInt(100);
            countMap.merge(temp, 1, (a, b) -> a + b);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        test();
//        testRandom();
    }
}
