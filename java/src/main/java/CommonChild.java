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


    for(int i = 1; i <= s1.length(); i++) {
      for(int j = 1; j <= s2.length(); j++) {
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[s1.length()][s2.length()];
  }
}
