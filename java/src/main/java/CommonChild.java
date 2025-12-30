public class CommonChild {
  public static int commonChild(String s1, String s2) {

    // strings s1 and s2 can be any length each
    // there length is between 1 and 5000
    // return the length of the LCS

    int dp[][] = new int[s1.length() + 1][s2.length() + 1]; // java automatically initializes int arrays to 0;

    // we want to iterate through the array, s1 first, s2 second, starting with 1.
    // check if the characters match
      // if yes, add one to what it use to be
      // if no, use the biggest from comparing the previous x and y elements

    // return the last value from the dp array that has the LCS length


    for(int i = 1; i <= s1.length(); i++) { // review gotcha why this starts at 1. We start where the strings start in a dpArray, the 0 indices represent the empty strings so we don't need to check those.
      for(int j = 1; j <= s2.length(); j++) {
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {  // Review gotcha what this is representing. since i and j start at 1, we need to - 1 to get the all of the characters from the string. If we didn't then we would be missing checks for the first character.
          dp[i][j] = dp[i - 1][j - 1] + 1; // update the current element to be what the previous match used to be?
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // if the letters don't match use the LCS length from either the last x element or y element
        }
      }
    }

    return dp[s1.length()][s2.length()];
  }

  public static int firstTry(String s1, String s2) {
    // where are return the length of the max common string
    // a common string is one where it can be derived by deleting one or more letters
    // which would make the two strings equal.
    // letters cannot be rearranged
    // the letters are all capital A -Z

    // find common letters between the strings
    // as long as the order is not changed however many common letters there are
    // is the max common child string.

    // AA
    // BB

    // A
    // B | B
    // x
    // A
    // B | B
    // x
    // return 0

    // HARRY
    // SALLY

    // H
    // S | A | L | L | Y
    // x
    // A
    // S | A | L | L | Y
    // 1 => A concatenate to child string
    // R
    // S | A | L | L | Y
    // x
    // R
    // S | A | L | L | Y
    // x
    // Y
    // S | A | L | L | Y
    // 2 => Y

    // return length of concenteated child string


    // ABCDEF
    // FBDAMN

    // A
    // F | B | D | A | M | N
    // 1 => A basically means you have to find something in come with the substring
    // after A in the second string

    // choosing s1. split the string into its letters
    // for each letter in S1
    // create a string when it finds an equal letter in s2

    // repeat with the unshifted slice of the string 1 index over
    // i.e. first iteration "ABCDEF" "FBDAMN" On2 => "A" it should only consider substring after the matching character
    // second iteration "BCDEF" "FBDAMN" On2 => "BD"
    // third iteration "CDEF" "FBDAMN" On2 => "D"
    // fourth iteration "DEF" "FBDAMN" On2 => "D"
    // fifth iteration "EF" "FBDAMN" On2 => "F"
    // sixth iteration "F" "FBDAMN" On2 => "F"

    // store the final iteration strings in a variable. Update it if the latest string is greater in length than the current value.

    // return the length of the iteration string

    // create a loop that shrinks the first string 1 char at a time starting at 0
    // create a loop that uses the shrunken string and iterates through each char
    // create a loop that iterates through the second string's chars

    // ABCD
    // CDBA

    // ABCD =>
    // A
    // C | D | B | A
    // A, 3

    // BCD
    // B
    // C | D | B | A
    // B, 2


    int maxIterations = s1.length();
    String maxCommonString = "";
    String[] s2Letters = s2.split("");

    for(int outerLoopCount = 0; outerLoopCount < maxIterations; outerLoopCount++) {

      String shrukenString = s1.substring(outerLoopCount);
      String iterationString = "";
      int onlyConsiderAfterIndex = -1;
      for( String s1Letter : shrukenString.split("")) {

        for( int index = 0; index < s2Letters.length; index++) {
          String s2Letter = s2Letters[index];

          if(s1Letter.equals(s2Letter) && index > onlyConsiderAfterIndex) {

            if(iterationString.length() == 0) {
              onlyConsiderAfterIndex = index;
            }
            iterationString += s1Letter;
          }
        }
      }

      if(iterationString.length() > maxCommonString.length()) {
        maxCommonString = iterationString;
      }


    }

    return maxCommonString.length();
  }
}
