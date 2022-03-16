package sort;

public class ShellSort implements Sort {

    @Override
    public void sort(int[] a) {
        int h = 1;
        while (h * 3 + 1 < a.length) {
            h = h * 3 + 1;
        }
        while (h>=1){
            for (int i = h; i < a.length; i += h) {
                for (int j = i; j >= h && less(a, j, j - h); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
