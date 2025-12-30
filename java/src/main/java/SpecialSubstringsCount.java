import java.util.*;

public class SpecialSubstringsCount {
  private static class Pair {
    char c;
    int count;

    public Pair(char c, int count) {
      this.c = c;
      this.count = count;
    }
  }

  public static long specialSubstrings(String s) {
    // a string of lowercase letters, there always be 1-1 million letters
    // return the count of substrings that fit these criteria in a long

    // build a list of groups (letter, count)

    List<Pair> groups = new ArrayList<>();

    int count = 0;

    // initialize the current letter to the first letter in the string.
    char currentLetter = s.charAt(0);

    for( int i = 0; i < s.length(); i++) {
      if ( s.charAt(i) == currentLetter) {
        count++;
      } else {
        // when letter changes, add the finished group to the list.
        groups.add(new Pair(currentLetter, count));
        currentLetter = s.charAt(i);
        count = 1;
      }
    }

    // add the final group after the loop.
    groups.add(new Pair(currentLetter, count));

    long ans = 0;

    // for second pass: count all substrings within each group. for a group
    // of count letters, the number of substrings is count * (count + 1) / 2

    for( Pair p : groups) {
      ans += (long) p.count * (p.count + 1) / 2;
    }

    for( int i = 1; i < groups.size() - 1; i++) {
      if( groups.get(i).count == 1 &&
          groups.get(i - 1).c == groups.get(i + 1).c
      ) {
        ans += Math.min(groups.get(i - 1).count, groups.get(i + 1).count);
      }
    }

    return ans;
  }

  public static long specialSubstringsOrderDoesNotMatter(String s) {
    // a string of lowercase letters, there always be 1-1 million letters
    // return the count of substrings that fit this criteria in a long

    // case 1: all single letters count monopoly
    // case 2: all duplicate permutations count with no other letters oo, ooo
    // case 3: all even duplicates with another letter in between count omo, ono, opo, olo, oyo

    // declare a int specSubstrCount = 0;
    int case1Count = 0;
    int case2Count = 0;
    int case3Count = 0;
    // I want a frequency map.
    Map<String, Integer> freqMap = new HashMap<>();
    // this gives me the unique letters from the keySet
    // this gives me duplicates and even duplicates

    for( String letter: s.split("")) {
      freqMap.put(letter, freqMap.getOrDefault(letter, 0) + 1);
    }

    // test1: abcbaba
    // a:3, b:3, c:1

    ArrayList<String> uniqueLetters = new ArrayList<>(freqMap.keySet());

    // [a, b, c]

    // ex. mississippi
    // m: 1, i:4, s:4, p:2
    // case 1: 11
    case1Count = s.length();
    // case 2: ii, iii, iiii, ss, sss, ssss, pp => 7
    // find the letters with frequencies >= 2
    // sum each one of those frequencies as their frequency - 1
    // TODO: is there a reduce method in Java?

    // case1Count test1 => 7


    Optional<Integer> case2Sum = freqMap.values().stream()
        .filter(v -> v > 2).reduce((cv, accumulator) -> accumulator + (cv - 1));

    if(case2Sum.isPresent()) {
      case2Count = case2Sum.get();
    }

    // case2Count test1 =>  2 + 2 => 4 => aa, aaa, bb, bbb

    // case 3: i has two sets, s has two sets, p has one set,
    // i => from uniqueLetters.size() - 1 => 3 * 2 since there are two sets
    // s => from uniqueLetters.size() - 1 => 3 * 2 since there are two sets
    // p => from uniqueLetters.size() - 1 => 3 * 1 since there is only 1 set
    // 6+6+3 => 15
    // 11 + 7 + 15 => 33


    // determine the number of sets each duplicate letter has
    // declare setFrequencyMap
    Map<String, Integer> setFreqMap = new HashMap<>();

    freqMap.forEach((k, v) -> {
      // a letter has a set if you get its frequency / 2
      // e.g. Math.floor(frequency / 2) 4 / 2 =2, 3 / 2 = 1, 2  / 2 = 1,
      if(v >= 2) {
        setFreqMap.put(k, Math.floorDiv(v, 2));
      }
    });

    // setFreqMap test1 => a:1, b:1

    // for each key, value in setFreqMap
    // sum the (uniqueLetters.size() - 1) * number of sets (value)
    Optional<Integer> case3Sum = setFreqMap.values()
        .stream().reduce((cv, acc) -> acc + ((uniqueLetters.size() - 1) * cv));

    // test1 => 2 * 1 + 2 * 1 => aba, aca, bab, bcb

    if(case3Sum.isPresent()) {
      case3Count = case3Sum.get();
    }


    // convert the int to a long before returning
    return Long.valueOf(case1Count + case2Count + case3Count);
  }
}
