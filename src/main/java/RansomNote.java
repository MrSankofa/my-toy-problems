import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {
  public static void main(String[] args) {
    String[] magArray = {"give", "me", "one", "grand", "today", "night"};
    String[] noteArray = {"give", "one", "grand", "today"};
    RansomNote.checkMagazines(magArray, noteArray);
  }

  public static String checkMagazines(String[] magazines, String[] notes ) {

    // create a word map count for the magazine and notes

    Map<String, Integer> noteMap = new HashMap<>();
    Map<String, Integer> magazineMap = new HashMap<>();


    for(String word: magazines) {
      if( magazineMap.containsKey(word) ) {
        magazineMap.put(word, magazineMap.get(word) + 1);
      } else {
        magazineMap.put(word, 1);
      }
    }

    for(String word: notes) {
      if( noteMap.containsKey(word) ) {
        noteMap.put(word, noteMap.get(word) + 1);
      } else {
        noteMap.put(word, 1);
      }
    }

//    magazineMap = Arrays.stream(magazines).collect(Collectors.toMap( word -> word, word -> 1));
//    noteMap = Arrays.stream(magazines).collect(Collectors.toMap( word -> word, word -> 1));

    // loop through the note Map to check if the note word is in the magazine and if you have enough of them
    for(Map.Entry<String, Integer> entry: noteMap.entrySet()) {
      if( magazineMap.containsKey(entry.getKey()) && magazineMap.get(entry.getKey()) >= entry.getValue()) {

      } else {
        return "No";
      }
    }

    return "Yes";
      // if the word is not in there or you don't have enough
        // print No


    // print yes



  }
}