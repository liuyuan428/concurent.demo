package sort;

public interface Sort {

    default boolean less(int[] a,int i ,int j){
        return a[i] < a[j];
    }

    default boolean more(int[] a,int i ,int j){
        return a[i] > a[j];
    }

    default void exch(int[] a,int i ,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void sort(int[] a);

}
