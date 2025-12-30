import java.util.Collections;
import java.util.List;

/*
*
* The absolute difference is the positive difference between two values  and , is written |a - b | or | b - a |  and they are equal.
*
* If a = 3 and b = 2. | 3 - 2| = | 2 - 3 | = 1.
*
* Given an array of integers, find the minimum absolute difference between any two elements in the array.

Example arr = [ -2 , 2 , 4 ]

There are 3  pairs of numbers: [-2, 2], [-2, 4] and [2, 4] The absolute differences for these pairs are
* |(-2) -2| = 4. |(-2) -4 | = 6,  and |2- 4| 2 . The minimum absolute difference is 2.

Function Description

Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

int arr[n]: an array of integers
Returns

int: the minimum absolute difference found
Input Format

The first line contains a single integer , the size of .
The second line contains  space-separated integers, .

Constraints
*
* 2 <= n <= 10&5
* -10^9 <= arr[i] <= 10^9

Sample Input 0

3
3 -7 0
Sample Output 0

3
Explanation 0

The first line of input is the number of array elements. The array,  There are three pairs to test: , , and . The absolute differences are:

Remember that the order of values in the subtraction does not influence the result. The smallest of these absolute differences is .

Sample Input 1

10
-59 -36 -13 1 -53 -92 -2 -96 -54 75
Sample Output 1

1
Explanation 1

The smallest absolute difference is .

Sample Input 2

5
1 -3 71 68 17
Sample Output 2

3
Explanation 2

The minimum absolute difference is .
* */

public class MinimumAbsoluteDifference {
  public static int minimumAbsoluteDifference(List<Integer> arr) {
    // input:
    // the array will always have at least 2 elements to 100k
    // the elements in the list range from -1 tril to 1 tril

    // output:
    // return an int of the smallest difference found in the list

    // what situation would set up the list to find the smallest difference?
    // what if you create two list from the same array?
    // one sorted ascending and the other descending
    // have one loop starting at index 0 to find the smallest difference between
    // the first few elements? Or do you need to go through all of them?

    // [-6, -4, -2, 0, 2, 4, 6]
    // [6, 4, 2, 0, -2, -4, -6]

    // near the middle of the list would be where the difference is the smallest
    // but that's only if the list is balanced

    // [-2, 101, 102, 103, 104]
    // [104, 103, 102, 101, -2]

    // looks like even if it is not balanced it's always in the middle

    // [-10, 10, 20, 25, 26, 27]
    // [27, 26, 25, 20, 10, -10]

    // if it is even round to the index nearest to the floor and find the difference
    // of the two in the middle. all of the elements outside of this range will have a greater difference guaranteed

    // if it is odd find the difference of the middle element

//    List<Integer> ascending = arr.stream().sorted().collect(Collectors.toList());
//    List<Integer> descending = ascending.subList(0, ascending.size());
//    Collections.reverse(descending);

    // how do you find the middle of a list?
    // if the list has an even length, like 4 => 0, 1,2, 3
    // 4/2 = 2 - 1
    // (array.size() / 2) - 1 is the lower middle index
    // (array.size() / 2) is the upper middle index

    // if the list is an odd length, like 5 => 0,1,2,3,4
    // Math.floor(array.size() / 2) => Math.floor(5 / 2) => Math.floor(2.5) => 2

    int minDiff = Integer.MAX_VALUE;

    for (int i = 1; i < arr.size(); i++) {
      minDiff = Math.min(minDiff, Math.abs(arr.get(i) - arr.get(i - 1)));
    }

    return minDiff;
  }

  public static int minAbsDiffII(List<Integer> arr) {

    // Input: a list of integers
    // range of each element (-1 billion to 1 billion)
    // size of list at least 2 up to 10,000

    // Output: integer
    // that int represents the smallest difference between all of the elements
    // should have emphasized that this needs to be the absolute min difference


    // Examples:
    // we probably need a nested to loop to get all combiniations
    // a single loop would not compare all of the numbers would it?

    // Ah, a single loop would not compare all of the numbers but we don't need all
    // combinations. if we sort the list in specific order the closets differences
    // will always be next to each other

    // smallest difference 1
    // [9, 4, 0, 1000, -34, -392, 3]
    // if this array was not sorted the smalles difference would be 4
    // sorted
    // [-392, -34, 0, 3, 4, 9, 1000]
    // sorted compairing elements next to each toher we get 1

    // Psuedocode:

    // declare and init minDiff with max int value
    // sort the list in ascending order.

    // starting at index 1, for each element in sortedList, until end of list
    // if Abs(elem0 - elem1) < minDiff
    // update minDiff

    // return minDiff

    int minDiff = Integer.MAX_VALUE;

    Collections.sort(arr);

    for(int i = 1; i < arr.size(); i++) {
      minDiff = Math.min(minDiff, Math.abs(arr.get(i - 1) - arr.get(i)));
    }

    // issues/gotchas:
    // Math.abs will always return a positive. This problem is always looking for
    // positive values

    return minDiff;
  }
}
