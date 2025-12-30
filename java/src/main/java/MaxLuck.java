import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxLuck {

  // TODO: retry this from scratch
  // TODO: make sure you know how to sort integers and strings in ascending and descending order by heart
  // TODO: use Integer::sum instead of lambda
  public static int maxLuck(int k, List<List<Integer>> contests) {
    // input:
    // array of tuples, where the 1st element of the tuple is the luck
    // 2nd element is the importance.

    // there will only be 100 tuples max and at least 1
    // The amount of contexts she can lose is infinite
    // The luck is between 1 and 10000

    // k is the amount of important contests she can lose
    // n is the number of contests
    // the 1st element in tuple is the luck gained if lost
    // note if won her luck balance will decrease by the luck element amount
    // the 2nd element in tuple determines is important or not

    // output:
    // we need to return the maximum amount of luck


    // question:
    // is there a case where winning a contest is beneficial?
    // the greatest luck value can be negative

    // approach:
    // For all of the important contests find the smallest luck values
    // only lose k of the smallest important contests

    // [ [10, 1]], k = 2 => 10
    // [ [10, 1]], k = 1 => 10
    // [ [10, 1]], k = 0 => -10

    // [[1,1], [1,1], [1,1], [1,1], [100,1]] k = 2
    // win win win win lose, lose => -3 + 1 + 100 => 98

    // lose the most points from the list until the important contest loss number is k.

    // calculate the most luck you can gain by losing

    // create a list of size k,
    // store the great luck value important contests in this list

    // [[100,1], [1,1], [1,1], [1,1], [1,1]] k = 2 => 101 - 3 = 98

    // you lose the greatest luck values and win the smallest luck values.

    // how do I find out what contests to lose and win?

    // we can lose all unimportant contests
    // we can only lose k important contests

    // make a list of unimportant contests
    // make a list of important contests

    // sort the important contests in descending luck value
    // lose the first k elements from that list

    // lose (sum) all of the unimportant contests
    // win all remainaning and deduct this sum from the others


    List<Integer> unimportantLuckValues = new ArrayList<>();
    List<Integer> importantLuckValues = new ArrayList<>();

    // get all unimportant values
    for( List<Integer> contest : contests) {
      if(contest.get(1) == 0) {
        unimportantLuckValues.add(contest.get(0));
      }
    }

    Integer unimportantSum = unimportantLuckValues.stream().reduce(0, (a,b) -> a + b);


    // get all important values
    for( List<Integer> contest : contests) {
      if(contest.get(1) == 1) {
        importantLuckValues.add(contest.get(0));
      }
    }


    // put the greatest luck values first
    Collections.sort(importantLuckValues, Comparator.reverseOrder());

    // only add the first k number of elements from the important list to get the greatest amount of luck.
    int maxLose = Math.min(k, importantLuckValues.size());
    Integer importantSum = importantLuckValues.subList(0, maxLose).stream().reduce(0, (a,b) -> a + b);

    // win the others? do we have to win the others? I think we do. Yes it says after competing in all of the preliminary contests.

    // the others would be the other side port of the sublist

    // watch for array out of bounds errors
    Integer remainingWinsSum = importantLuckValues.subList(maxLose, importantLuckValues.size()).stream().reduce(0, (a,b) -> a + b);


    return unimportantSum + importantSum - remainingWinsSum;
  }
}
