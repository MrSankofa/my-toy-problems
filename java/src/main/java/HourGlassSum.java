import java.util.ArrayList;
import java.util.List;

public class HourGlassSum {
  /*
   Given a  2D Array, :

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
An hourglass in  is a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
There are  hourglasses in . An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum. The array will always be .

Example


-9 -9 -9  1 1 1
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
The  hourglass sums are:

-63, -34, -9, 12,
-10,   0, 28, 23,
-27, -11, -2, 10,
  9,  17, 25, 18
The highest hourglass sum is  from the hourglass beginning at row , column :

0 4 3
  1
8 6 6
Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Function Description

Complete the function hourglassSum in the editor below.

hourglassSum has the following parameter(s):

int arr[6][6]: an array of integers
Returns

int: the maximum hourglass sum
Input Format

Each of the  lines of inputs  contains  space-separated integers .

Constraints

Output Format

Print the largest (maximum) hourglass sum found in .

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

 contains the following hourglasses:

image

The hourglass with the maximum sum () is:

2 4 4
  2
1 2 4
 */

  /*
   * Complete the 'hourglassSum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  public static int hourglassSum(List<List<Integer>> arr) {

    // input:
    // 2d list of ints, it will always be 6 x 6
    // the ints will always be between -9 and 9

    // goal:
    // calc the sum of the hour glass configuration
    // there are 16 of them in a 6 x 6 arr
    // return the max sum out of all 16


    // output
    // return the max sum out of 16 hour glass configurations

        /*
        [
            [1, 1, 1, 0, 0, 0],
            [0, 1, 0, 0, 0, 0],
            [1, 1, 1, 0, 0, 0],
            [0, 0, 2, 4, 4, 0],
            [0, 0, 0, 2, 0, 0],
            [0, 0, 1, 2, 4, 0],
        ]

        first one
        [0][0],[0][1],[0][2],
        [1][1],
        [1][0],[1][1],[1][2],

        last one in first row
        [0][3],[0][4],[0][5],
        [1][4],
        [1][3],[1][4],[1][5],

        first one in last row
        [3][0],[3][1],[3][2],
        [3+1][1],
        [3+ 2][0],[3 + 2][1],[3+2][2],

        second one in last row
        [3][1],[3][2],[3][3],
        [3+1][1],
        [3+ 2][0],[3 + 2][1],[3+2][2],

        last one in last row
        [3][3],[3][3 + 1],[3][3+2],
        [3+1][3+1],
        [3+ 2][3],[3 + 2][3+ 1],[3+2][3+ 2],

        first one in last row, row =3, col = 0
        [row][col],[row][col + 1],[row][col + 2],
        [row+1][col+ 1],
        [row+ 2][col],[row + 2][col+ 1],[row +2][col + 2],

        second one in last row
        [3][1],[3][2],[3][3],
        [3+1][1],
        [3+ 2][0],[3 + 2][1],[3+2][2],

        last one in last row
        [3][3],[3][3 + 1],[3][3+2],
        [3+1][3+1],
        [3+ 2][3],[3 + 2][3+ 1],[3+2][3+ 2],

        you can only go up to in index j= 3
        // you can only go down to index i = 3

        I get 12, where are the other 4? I had a 5 x 5 by mistake first
        a 6 x6 gives you 4 sums for 4 rows giving you 16.

        declare maxSum = 0
        for each row in arr, where row <= 3
            for each col in arr, where col <= 3
                sum the hour glass
                hourglassSum = [row][col]+[row][col + 1]+[row][col + 2]+[row+1][col+ 1]+[row+ 2][col]+[row + 2][col+ 1]+[row +2][col + 2];
                maxSum = Math.max(maxSum, hourglassSum);



        */

    int maxSum = Integer.MIN_VALUE;

    for(int row = 0; row <= 3; row++) {
      for(int col = 0; col <=3; col++) {
        int hourglassSum =
            arr.get(row).get(col) + arr.get(row).get(col + 1) + arr.get(row).get(col+ 2) + arr.get(row+1).get(col+1)+
                arr.get(row+2).get(col)+arr.get(row +2).get(col+1)+arr.get(row+2).get(col+2);

        maxSum = Math.max(maxSum, hourglassSum);
      }
    }

    return maxSum;


  }


}
