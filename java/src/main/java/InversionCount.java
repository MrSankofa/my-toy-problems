import java.util.List;

public class InversionCount {

  public static long InversionCount(List<Integer> arr) {

    int n = arr.size();
    Integer[] temp = new Integer[n];

    return mergeSortAndCount(arr, temp, 0, n-1);
  }

  // Recursive merge sort function
  private static long mergeSortAndCount(List<Integer> arr, Integer[] temp, int left, int right) {
    long inversionCount = 0;

    if (left < right) {
      int mid = (left + right) / 2;

      // Count inversions in left subarray
      inversionCount += mergeSortAndCount(arr, temp, left, mid);

      // Count inversions in right subarray
      inversionCount += mergeSortAndCount(arr, temp, mid + 1, right);

      // Count cross-inversions during merge
      inversionCount += mergeAndCount(arr, temp, left, mid, right);
    }

    return inversionCount;
  }

  // Merge function to count and sort
  private static long mergeAndCount(List<Integer> arr, Integer[] temp, int left, int mid, int right) {
    int i = left;       // Left subarray pointer
    int j = mid + 1;    // Right subarray pointer
    int k = left;       // Temp array pointer
    long inversionCount = 0;

    // Merge while counting inversions
    while (i <= mid && j <= right) {
      if (arr.get(i) <= arr.get(j)) {
        temp[k++] = arr.get(i++);
      } else {
        temp[k++] = arr.get(j++);
        // Count inversions: all remaining elements in left subarray are greater
        inversionCount += (mid - i + 1);
      }
    }

    // Copy remaining elements from left subarray
    while (i <= mid) {
      temp[k++] = arr.get(i++);
    }

    // Copy remaining elements from right subarray
    while (j <= right) {
      temp[k++] = arr.get(j++);
    }

    // Copy merged elements back to the original list
    for (i = left; i <= right; i++) {
      arr.set(i, temp[i]);
    }

    return inversionCount;
  }
}
