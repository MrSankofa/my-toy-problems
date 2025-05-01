import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class firstNonRepeatingCharacter {

  public static int firstNonRepeatingCharacter(String str) {
    // input:
    // lowercase english-alphabet letters in string

    // output:
    // int, representing the index of the first non repeating letter or -1 to indicate not found

    // results/Notes:
    // get a mapCount of the letter frequency
    // create a subset of letters that only show once

    // iterate through the list again, checking if the letter is in the subset
    // return that index

    // if you reach this point return -1

    // Examples
    // string = "abcdcaf"

  /*
    a: 2
    b: 1
    c: 2
    d: 1
    f: 1

    subset:

    { b, d, f}

    for each letter in "abcdcaf" starting at index = 0
        // if letter in subset
          // return index

    return -1

  */

    String[] chars = str.split("");

    Map<String, Integer> letterCount = new HashMap<>();

    Set<String> nonRepeatingChars = new HashSet<>();

    for (String letter: chars) {
      letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
    }

    for (String letter: chars) {
      if (letterCount.get(letter) == 1 ) {
        nonRepeatingChars.add(letter);
      }
    }

    for( int i = 0; i < chars.length; i++) {
      String letter = chars[i];
      if(nonRepeatingChars.contains(letter)) {
        return i;
      }
    }

    return -1;
  }
}
