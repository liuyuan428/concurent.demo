import org.junit.jupiter.api.Test;
import sort.*;

import java.util.Arrays;


public class SortTests {
    final static int[] cases = new int[]{10,9,8,7,6,5,1,45};

    @Test
    public void test() {
        Sort sort = new MergeSort();
        sort.sort(cases);
        System.out.println(Arrays.toString(cases));
    }
}
