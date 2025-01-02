import java.util.ArrayList;
import java.util.List;

public class SubstringGenerator {
  public static List<String> generateSubstrings(String str) {

    ArrayList<String> substrings = new ArrayList<>();

    for(int i = 0; i < str.length(); i++) {
      String sub = "";

      for(int j = i; j < str.length(); j++) {
        sub += str.charAt(j);
        substrings.add(sub);
      }
    }

    return substrings;
  }
}
