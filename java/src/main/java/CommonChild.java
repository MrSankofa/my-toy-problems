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
}
