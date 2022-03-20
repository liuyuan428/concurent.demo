package algorithm.questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


/**
 * 给定一个有序数组
 * 在数组中找到目标值的起始和终止下标,不存在返回 [-1,-1]。
 * 时间复杂度为 o(lg(n))
 * 例子：arr: [1,3,4,5,6,6,6,7] , target: 6
 * return: [4,6]
 */
public class GetTargetIdxInArr {


    static Stream<Arguments> cases() {
        return Stream.of(
                arguments(new int[]{1, 5, 6, 6, 6, 7}, 9, new int[]{-1, -1}),
                arguments(new int[]{1, 5, 6, 6, 6, 7}, 6, new int[]{2, 4}),
                arguments(new int[]{1, 5, 6, 6, 6, 7}, 5, new int[]{1, 1}),
                arguments(new int[]{1, 5, 6, 6, 6, 7}, 7, new int[]{5, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void test(int[] arr, int target, int[] res) {
        Assertions.assertArrayEquals( res,directSearch(arr, target));
    }

    /**
     * 比较多次使用二分法 和 使用使用一次二分法再前后遍历的速度差异
     * 1
     * 443
     */
    @Test
    public void bigArrTest() {
        int[] arr = new int[1000000000];
        Arrays.fill(arr, 10);
        long start = System.currentTimeMillis();
        Assertions.assertArrayEquals(new int[]{0, arr.length - 1},search(arr, 10));
        System.out.println( System.currentTimeMillis() -start);

        start = System.currentTimeMillis();
        Assertions.assertArrayEquals(new int[]{0, arr.length - 1},directSearch(arr, 10));
        System.out.println( System.currentTimeMillis() -start);
    }

    public static int[] search(int[] arr, int target) {
        int lt = 0;
        int[] res = new int[]{-1, -1};

        while (lt < arr.length) {
            int idx = binarySearch(arr, lt, arr.length - 1, target);
            if (idx == -1) {
                break;
            } else {
                res[1] = idx;
                lt = idx + 1;
            }
        }
        int gt = arr.length - 1;
        while (gt >= 0) {
            int idx = binarySearch(arr, 0, gt, target);
            if (idx == -1) {
                break;
            } else {
                res[0] = idx;
                gt = idx - 1;
            }
        }


        return res;
    }

    public static int[] directSearch(int[] arr, int target) {
        int lt = 0;
        int[] res = new int[]{-1, -1};


        int idx = binarySearch(arr, lt, arr.length - 1, target);
        if (idx == -1) {
            return res;
        }

        res[0] = idx;
        res[1] = idx;
        while (res[0] > 0 && arr[res[0] - 1] == target) {
            res[0]--;
        }

        while (res[1] < arr.length - 1 && arr[res[1] + 1] == target) {
            res[1]++;
        }
        return res;

    }

    public static int binarySearch(int[] arr, int lo, int hi, int target) {

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (target > arr[mid]) {
                lo = mid + 1;
            } else if (target < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
