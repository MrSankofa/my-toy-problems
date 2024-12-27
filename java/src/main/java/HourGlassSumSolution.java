import java.util.List;

public class HourGlassSumSolution {
  /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.

     I: 6x6 array
     O: print Integer, max sum

     constraints: each element is -9 <= x <= 9

     Approach:
     - update the max sum as you go
     - for each coordinate i, j,
        if the hour glass is possible
            sum 7 elements
            currentSum = [i][j] + [i + 1][j] + [i+2][j] + [i + 1][j + 1] + [i + 1][j + 2] + [i + 2][j +2] + [i][j + 2]

        if currentSum > maxSum
            maxSum = currentSum

            Notes make sure you are accessing and thinking about the matrix correctly.
            in a 2d array, the first index gives you a list of rows, the second index element but incrementing the second index gives you the col
     */

  public static int hourglassSum(List<List<Integer>> arr) {
    Integer maxSum = Integer.MIN_VALUE;


    for(int i = 0; i < 6; i++) {
      for(int j = 0; j < 6; j++) {
        Integer currentSum = Integer.MIN_VALUE;
        if( i + 2 < 6 && j +2 < 6) {
          // currentSum = arr.get(i).get(j);
          currentSum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
              + arr.get(i + 1).get(j + 1)
              + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
        }

        if(currentSum > maxSum) {
          maxSum = currentSum;
        }
      }
    }

    return maxSum;
  }

}
