import java.util.List;

public class MinimumAbsoluteDifference {
  public static int minimumAbsoluteDifference(List<Integer> arr) {

    int minDiff = Integer.MAX_VALUE;

    for (int i = 1; i < arr.size(); i++) {
      minDiff = Math.min(minDiff, Math.abs(arr.get(i) - arr.get(i - 1)));
    }

    return minDiff;
  }
}
