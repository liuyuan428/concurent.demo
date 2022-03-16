package sort;

public class InsertSort implements Sort {


    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1 && less(a, j, j - 1); j--) {
                exch(a, j, j - 1);
            }
        }
    }

}
