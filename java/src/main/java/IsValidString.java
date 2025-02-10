import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsValidString {
  public static String myIsValidString(String s) {
    // input: is a string
    // letters in string are btwn a-z lowercase
    // string is btwn 1 and 100000

    // return is a string YES or NO

    // abc => YES
    // abcc => YES
    // abbcc => NO

    // create a letter frequency map

    // declare a int last frequency from the first index in the map values
    // declare a int nonMatchingCount = 0
    // iterate through the map values starting at 1
    // if lastFrequency !== currentFrequency
    // increment nonMatchingCount

    // if nonMatchCount > 1
    // return NO

    // return yes
    String[] letters = s.split("");

    Map<String, Integer> freqMap = new HashMap<String, Integer>();

    for( String letter: letters) {
      freqMap.put(letter, freqMap.getOrDefault(letter, 0) + 1);
    }

    ArrayList<Integer> freqValues = new ArrayList<>(freqMap.values());

    // Collections.sort(freqValues);

    int lastFrequency = freqValues.get(0);
    int notMatchingCount = 0;

    for(int i = 1; i < freqValues.size(); i++) {
      int currentFrequency = freqValues.get(i);
      if(lastFrequency != currentFrequency) {
        notMatchingCount++;
      }

      if(notMatchingCount > 1) {
        return "NO";
      }
    }

    return "YES";


  }

  public static String isValid(String s) {
    // input: is a string
    // letters in string are btwn a-z lowercase
    // string is btwn 1 and 100000

    // return is a string YES or NO

    // abc => YES
    // abcc => YES
    // abbcc => NO

    // create a letter frequency map

    String[] letters = s.split("");

    Map<String, Integer> freqMap = new HashMap<String, Integer>();

    for( String letter: letters) {
      freqMap.put(letter, freqMap.getOrDefault(letter, 0) + 1);
    }

    // create a count Map
    Map<Integer, Integer> countMap = new HashMap<>();

    // for each freqCount(value) in the freqMap
    // add the freqCount as a key in the countMap and initialize with 1
    // or get the freqCount value from the CountMap and update it by adding 1

    for( int freqCount: freqMap.values()) {
      countMap.put(freqCount, countMap.getOrDefault(freqCount, 0) + 1);
    }

    // A count map is good because there should only ever be max two frequencies.

    if(countMap.size() > 2) {
      return "NO";
    }

    if(countMap.size() == 1) {
      return "YES";
    }

    // when there are only two frequencies, then there are only two cases in which we can get a YES
    // case 1: one frequency happens once, i.e. countMap 1:1 (this allows us to delete that index) then only one frequency will exist
    // e.g. aabbccd or aaabbbcccd or aaabcccddd, etc

    if(countMap.get(1) != null && countMap.get(1) == 1) {
      return "YES";
    }

    // case 2: the higher frequency count is only 1 and 1 minus the frequency count gets you the lower frequency
    // e.g. aaabbbcccc but not aaabbbcc
    // aaabbbcc would not work because if we remove 1 b then not all of the counts are the same
    // Not working (aaabbbcc) freq a: 3, b:3, c:2 => count 3:2, 2:1
    // Working (aaabbbcccc) freq a:3, b:3, c:4 => count 3:2, 4:1
    // Not working (aaabbbccccc) frequency a:3, b:3, c:5 => count 3:2, 5:1
    // if we remove 1 c => aaabbbcccc so all of the frequency counts are not the same still

    // so it's only when the higher frequency is 1 and the higher frequency is 1 + lowerFrequency
    // it doesn't work with the higher frequency > 1

    // ArrayList<Integer> countList = new ArrayList<>( countMap.values());

    List<Integer> countList = countMap.keySet().stream().map(
        keyStr -> Integer.valueOf(keyStr)
    ).sorted((i1, i2) -> Integer.compare(i1, i2)).collect(Collectors.toList());

    int highestFrequency = countList.get(1);
    int lowerFrequency = countList.get(0);

    if(highestFrequency - lowerFrequency == 1 && countMap.get(highestFrequency) == 1) {
      return "YES";
    }

    return "NO";


  }
}
