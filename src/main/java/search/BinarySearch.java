package search;

public class BinarySearch {


    public static int doSearch(int[] arr, int target) {
        return doSearch(arr, 0, arr.length - 1, target);
    }

    public static int doSearch(int[] arr, int lo, int hi, int target) {
        while(lo<=hi){
            int mid = (lo + hi) >>> 1;
            if (target>arr[mid]) {
                lo = mid +1;
            }else if(target < arr[mid]){
                hi = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
