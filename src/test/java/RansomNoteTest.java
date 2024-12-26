import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RansomNoteTest {

  @Test
  void testHappyOneOfEach() {
    String[] magArray = {"give", "me", "one", "grand", "today", "night"};
    String[] noteArray = {"give", "one", "grand", "today"};
    assertEquals("Yes", RansomNote.checkMagazines(magArray, noteArray));
  }

  @Test
  void testHappyMultipleOfEach() {
    String[] magArray = {"two", "times", "three", "is", "not", "four"};
    String[] noteArray = {"two", "times", "two", "is", "four"};
    assertEquals("No", RansomNote.checkMagazines(magArray, noteArray));
  }

  @Test
  void testMissingWord() {
    String[] magArray = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
    String[] noteArray = {"ive", "got", "some", "coconuts"};
    assertEquals("No", RansomNote.checkMagazines(magArray, noteArray));
  }

  @Test
  void testPerformance() {
    String[] magArray = new String[1000000];
    String[] noteArray = new String[500000];

    // Populate magazine and note with repeated words
    for (int i = 0; i < magArray.length; i++) {
      magArray[i] = "word" + (i % 1000); // Use unique words every 1000 repetitions
    }
    for (int i = 0; i < noteArray.length; i++) {
      noteArray[i] = "word" + (i % 1000);
    }

    long startTime = System.nanoTime();
    String result = RansomNote.checkMagazines(magArray, noteArray);
    long endTime = System.nanoTime();

    long durationMs = (endTime - startTime) / 1_000_000;

    System.out.println("Execution Time: " + durationMs + " ms");

    assertEquals("Yes", result);
    assertTrue(durationMs < 100, "Execution time exceeded time limit: 100ms");
  }
}
