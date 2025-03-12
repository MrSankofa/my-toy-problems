import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {


  public static int sockMerchant(int n, List<Integer> ar) {

    // n is between 1 and 100
    // elements are between 1 and 100, and there are no gaps

    // return an int that represents the number of pairs

    // sockMerchant(5, [1,2,3,1,2]) => 2 pairs
    // sockMerchant(9, [10 20 20 10 10 30 50 10 20]) => 3 pairs, two 10s and one 20

    // Declare a hashmap to store the sock type and count, as kv respectively

    Map<Integer, Integer> sockTypeMap = new HashMap<Integer, Integer>();
    int pairCount = 0;

    // For each sockType in list Ar
    for( Integer sockType : ar) {
      // initialize or update the hashMap with the type and count
      if ( sockTypeMap.containsKey(sockType) ) {
        sockTypeMap.put(sockType, sockTypeMap.get(sockType) + 1);
      } else {
        sockTypeMap.put(sockType, 1);
      }
    }

    for( Integer value : sockTypeMap.values()) {
      pairCount += Math.floorDiv(value, 2);
    }
    // for each value pair in the map
    // Math.Floor( value / 2) and add it to the pair count

    // return the pair count

    return pairCount;

  }

  public static int secondPassApproach(int n, List<Integer> ar){
    // input:
    // n is the number socks or elements in the array, 1 <= n <= 100 we can do n^2 time complexity
    // ar is a list of intergers where the ints represent a color and there can be 100 different colors

    // output:
    // we need to output the interger number of pairs
    // 10, 10, 10, 10 is two pairs
    // 10, 10, 10, 10, 20, 20 is three pairs
    // 10, 20, 10, 10, 30, 50, 10, 20 is still three pairs just mixed up

    // I am thinking a greedy algorithm to get all the information we need in a linear fashion

    // declare pair to store unique colorInts and the frequency that it shows

    // for each colorInt in ar
    // store the colorInt in the map and update the frequence

    // declare totalPairs int

    // for each value in map
    // update the totalPairs value / 2 in java does / 2 on an int truncate the decimal?

    // return totalPairs

    HashMap<Integer, Integer> colorFreqMap = new HashMap<>();

    // given: [10, 20, 10, 10, 30, 50, 10, 20]
    for( Integer color : ar) {
      colorFreqMap.put(color, colorFreqMap.getOrDefault(color, 0) + 1);
      //
    }

    int totalPairs = 0;

    for( Integer freq: colorFreqMap.values()) {
      totalPairs += freq / 2;
    }

    return totalPairs;
  }
}
