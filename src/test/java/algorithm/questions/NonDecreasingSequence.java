package algorithm.questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 给定n个数，分别为 A1,....An
 * 对于Ai，要么不变，要么减一，可否使其变为非递减序列
 */

public class NonDecreasingSequence {


    static Stream<Arguments> cases() {
        return Stream.of(
                arguments(new int[]{3, 2, 3}, true),
                arguments(new int[]{1, 2, 3}, true),
                arguments(new int[]{3, 4, 3}, true),
                arguments(new int[]{5, 4, 4, 3}, false),
                arguments(new int[]{5, 4, 3}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void test(int[] arr, boolean res) {
        Assertions.assertEquals(res, solution(arr));

    }

    public static boolean solution(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && --arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
