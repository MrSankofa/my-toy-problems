import java.util.HashMap;
import java.util.Map;

public class MakeAnagram {


  public static int makeAnagram(String a, String b) {
    // a word is anagram with another word if you can rearrange the letters to make the other word
    // so if you take two strings, and sort them using the same method, if the two strings equal each other then it's an anagram.

    // return the int number of letter deletions to make it an anagram

    // abc bcd, takes two deletions. because a is not in the other, and d is not in the other

    // thought find the letters and their frequency not in the other word
    // you have made an anagram if all of the letters in one word are in the other word
    // sorting the words and iterating them and counting missing letters seems like an approach

    // aabccf
    // abbccg

    // aMap => a: 2, b: 1, c:2, f:1
    // bMap => a: 1, b: 2, c:2, g:1

    // brute force
    // declare a and b deletion count
    int aDeletionCount = 0;
    int bDeletionCount = 0;

    Map<String, Integer> aMap = new HashMap<>();
    Map<String, Integer> bMap = new HashMap<>();

    // store each letter in a map for string a and string b
    for( String letter: a.split("")) {
      if(aMap.containsKey(letter)) {
        aMap.put(letter, aMap.get(letter) + 1);
      } else {
        aMap.put(letter, 1);
      }
    }

    for( String letter: b.split("")) {
      if(bMap.containsKey(letter)) {
        bMap.put(letter, bMap.get(letter) + 1);
      } else {
        bMap.put(letter, 1);
      }
    }
    // loop through a
    // check if letters from a are not in map b
    // increment a deletion count
    for( String letter: a.split("")) {
      if(!bMap.containsKey(letter)) {
        aDeletionCount++;
      } else {
        if(bMap.get(letter) > 1) {
          bMap.put(letter, bMap.get(letter) - 1);
        } else {
          bMap.remove(letter);
        }

      }
    }

    // loop through b
    // check if letters from b are not in map a
    // increment b deletion count
    for( String letter: b.split("")) {
      if(!aMap.containsKey(letter)) {
        bDeletionCount++;
      } else {
        if(aMap.get(letter) > 1) {
          aMap.put(letter, aMap.get(letter) - 1);
        } else {
          aMap.remove(letter);
        }

      }
    }


    // return a deletion count + b deletion count
    return aDeletionCount + bDeletionCount;


  }
}
