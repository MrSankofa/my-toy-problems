public class CountingTriplets {

  public static int countTriplets(int[] arr, int r) {
    int count = 0;

    for( int i = 0; i < arr.length - 2; i++ ) {

      for( int j = i + 1; j < arr.length - 1; j++ ) {

        for( int k = j + 1; k < arr.length; k++ ) {
          if( arr[i] * r == arr[j] && arr[j] * r == arr[k] ) {
            count++;
          }
        }
      }

    }

    return count;
  }
}
