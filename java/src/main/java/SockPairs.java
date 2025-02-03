import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockPairs {

  public static Integer counterPairs(List<Integer> ar) {

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
}
