
import java.util.*;
import java.util.stream.*;

public class MinCostFlowers {

  public static int getMinimumCost(int k, int[] c) {

    // Overview:
    // the Florist is making the first flower that they buy without an upcharge
    // so (0 + 1) + the price of the flower they buy

    // the second flower that person buys will be:
    // (1 + 1) + the price of the flower they buy for c array

    // so it is most beneficial for each person from the group to buy the most expensive
    // flowers first

    // input:
    // k tells how many people are in our group
    // c is a list of flower prices.

    // the group will buy all of the flowers but they will do so in a way that is the cheapest

    // output:
    // return the cheapest cost to buy all of the flowers based on how many ppl are in your group

    // flowers = [1,2,3,4]
    // k = 3 (group of three)

    // (0 + 1) * 2 + (0 + 1) * 3 + (0 + 1) * 4 + (1 + 1) * 1 = 2 + 3 + 4 + 2 = 11

    // the amount of flowers that k can exist are between 1 and 100
    // The amount of people in the group is between 1 and 100
    // the price is between 1 and 10000


    // sort the list in descending order

    // declare int flowersPurchased = 0;
    // declare int minCost = 0;

    // for each flowerPrice in c, starting with index = 0; while index < k
    // minCost += (flowersPurchased + 1) * flowerPrice


    // use the remaining flowerPrices and sort them in ascending order

    // increment flowersPurchased
    // for each flowerPrice in filteredSortedC, starting with index = 0, while index < filteredSortedC.length()

    // minCost += (flowersPurchased + 1) * flowerPrice


    // return minCost


    // todo how to convert an int[] to ArrayList<Integer>
    // c = [1,2,3,4], k = 3
    // c = [1,2,3,4], k = 5


    int flowersPurchased = 0;
    int minCost = 0;
    List<Integer> flowerPrices = new ArrayList<>();

    if (k < c.length) {
      // the flowers purchased will increment and you start with the most expensive first
      // then get the remaining and sort in ascending order
      // remaining flowerPrices and sorted in ascending order


      List<Integer> descFlowerPrices = Arrays.stream(c).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

      for (int i = 0; i < k; i++) {
        minCost += (flowersPurchased + 1) * descFlowerPrices.get(i);
      }

      flowersPurchased++;

      List<Integer> remainingAscFlowerPrices = descFlowerPrices.subList(k, c.length);
      Collections.sort(remainingAscFlowerPrices);

      for (int i = 0; i < remainingAscFlowerPrices.size(); i++) {
        minCost += (flowersPurchased + 1) * remainingAscFlowerPrices.get(i);

        if ((i + 1) % k == 0) {
          flowersPurchased++;
        }
      }

      return minCost;
    } else if (k == c.length) {
      // it doesn't matter what order you buy in all will be bought without an upcharge

      for (int flowerPrice : c) {
        minCost += flowerPrice;
      }

      return minCost;
    } else {
      // you'll want to sort in ascending order and buy until each person from the group of size k has bought a flower
      // if k is greater than n or the number of flowers then
      // I thought that k would always be less than or equal to the number of flowers, n but k can be greater.
      // this still means all flowers will be bought but there is no upcharge

      List<Integer> ascFlowerPrices = Arrays.stream(c).boxed().sorted().collect(Collectors.toList());

      for (int i = 0; i < ascFlowerPrices.size(); i++) {
        minCost += ascFlowerPrices.get(i);
      }


      return minCost;

    }
  }
}
