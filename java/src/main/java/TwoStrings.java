import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
  public static void main(String[] args) {

  }

  public static String twoStrings(String s1, String s2) {
    // create a map of letter string count for s1
    String[] s1Letters = s1.split("");
    String[] s1Letters2 = s2.split("");

    Map<String, Integer> s1Mapped = new HashMap<>();

    for( String letter : s1Letters ) {
      s1Mapped.merge(letter, 1, Integer::sum);
    }

    for( String letter : s1Letters2 ) {
      if( s1Mapped.containsKey(letter) ) {
        return "YES";
      }
    }

    return "NO";

  }
}
