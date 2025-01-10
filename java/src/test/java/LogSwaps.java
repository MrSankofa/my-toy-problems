public class LogSwaps {

  public static String logSwaps(int[] a) {

    int swaps = 0;
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < a.length - i - 1; j++) {
        if(a[j] > a[j+1]) {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
          swaps++;
        }
      }
    }

    return String.format("Array is sorted in %d swaps.\n", swaps) +
        String.format("First Element: %d \n", a[0]) +
        String.format("Last Element: %d\n", a[a.length - 1]);
  }
}
