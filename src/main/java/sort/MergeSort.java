package sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, 0, a.length - 1, aux);

    }

    public void sort(int[] a, int lo, int hi, int[] aux) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        sort(a, lo, mid, aux);
        sort(a, mid + 1, hi, aux);
        merge(a, lo, mid, hi, aux);
    }

    public void merge(int[] a, int lo, int mid, int hi, int[] aux) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux, i, j))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }
}
