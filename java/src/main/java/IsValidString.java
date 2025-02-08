import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IsValidString {
  public static String isValidString(String s) {
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
}
