public class AlternatingCharacters {

  /*
  *
  * You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

      Your task is to find the minimum number of required deletions.

      Example

      Remove an  at positions  and  to make  in  deletions.

      Function Description

      Complete the alternatingCharacters function in the editor below.

      alternatingCharacters has the following parameter(s):

      string s: a string
      Returns

      int: the minimum number of deletions required
      Input Format

      The first line contains an integer , the number of queries.
      The next  lines each contain a string  to analyze.

      Constraints

      Each string  will consist only of characters  and .
      Sample Input

      5
      AAAA
      BBBBB
      ABABABAB
      BABABA
      AAABBB
      Sample Output

      3
      4
      0
      0
      4
      Explanation

      The characters marked red are the ones that can be deleted so that the string does not have matching adjacent characters.
  *
  * */

  public static int alternatingCharacters(String s) {
    // strings will only consist of A and B
    // you don't actually have to delete anything just count the number of times
    // accurate a letter repeats and return that int

    // AAAA => 3 - A -> lastLetter = A | A increment count | A when it changes to another letter update lastLetter and change if it is different

    // BBBBB => 4

    // ABABABAB => 0

    // BABABA => 0

    // AAABBB => 4

    // declare a lastLetter String variable initialize it for the first letter in the string
    // declare a int deleteCount variable

    // split the string and loop through it starting at index 1 cont. til the end
    // check if the current letter is equivalent to the lastLetter
    // increment deleteCount
    // else
    // update lastLetter to current letter

    // return deleteCount

    String[] inputStr = s.split("");

    String lastLetter = inputStr[0];

    int deleteCount = 0;

    for(int i = 1; i < s.length(); i++) {
      String currentLetter = String.valueOf(s.charAt(i));

      if(currentLetter.equals(lastLetter)) {
        deleteCount++;
      } else {
        lastLetter = currentLetter;
      }
    }

    return deleteCount;
  }
}
