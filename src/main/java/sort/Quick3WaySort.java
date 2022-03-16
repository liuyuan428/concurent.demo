package sort;

public class Quick3WaySort implements Sort {
    @Override
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }
// 2 1 3 2 2 4 2
    private void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo;
        int i = lt + 1;
        int gt = hi;

        while (i <= gt) {
            if (less(a, i, lt)) exch(a, i++, lt++);
            else if (more(a, i, lt)) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
