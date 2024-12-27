import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoStringsTest {

  @Test
  void testHappyPath() {
    String s1 = "hello";
    String s2 = "world";
    assertEquals("YES", TwoStrings.twoStrings(s1, s2));
  }

  @Test
  void testHappyMissingPath() {
    String s1 = "bat";
    String s2 = "door";
    assertEquals("NO", TwoStrings.twoStrings(s1, s2));
  }

  @Test
  void testPerformanceTwoStrings() {
    // Generate large input strings
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    // Populate s1 with 1 million characters (repeated "abc")
    for (int i = 0; i < 1_000_000; i++) {
      s1.append((char) ('a' + (i % 3))); // Cycles through 'a', 'b', 'c'
    }

    // Populate s2 with a match at the end
    for (int i = 0; i < 999_999; i++) {
      s2.append((char) ('x' + (i % 3))); // Cycles through 'x', 'y', 'z'
    }
    s2.append('a'); // Ensure there is a match with `s1`

    // Measure execution time
    long startTime = System.nanoTime();
    String result = TwoStrings.twoStrings(s1.toString(), s2.toString());
    long endTime = System.nanoTime();

    long durationMs = (endTime - startTime) / 1_000_000; // Convert to milliseconds

    // Output execution time for debugging
    System.out.println("Execution Time: " + durationMs + " ms");

    // Assertions
    assertEquals("YES", result); // There should be a match
    assertTrue(durationMs < 1000, "Execution time exceeded limit: 1000ms. It took " + durationMs + " ms");
  }

  @Test
  void testNoCommonSubstringPerformance() {
    // Generate large input strings
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    // Populate s1 with 1 million characters (repeated "abc")
    for (int i = 0; i < 1_000_000; i++) {
      s1.append((char) ('a' + (i % 3))); // Cycles through 'a', 'b', 'c'
    }

    // Populate s2 with completely non-overlapping characters
    for (int i = 0; i < 1_000_000; i++) {
      s2.append((char) ('x' + (i % 3))); // Cycles through 'x', 'y', 'z'
    }

    // Measure execution time
    long startTime = System.nanoTime();
    String result = TwoStrings.twoStrings(s1.toString(), s2.toString());
    long endTime = System.nanoTime();

    long durationMs = (endTime - startTime) / 1_000_000; // Convert to milliseconds

    // Output execution time for debugging
    System.out.println("Execution Time: " + durationMs + " ms");

    // Assertions
    assertEquals("NO", result); // There should be no match
    assertTrue(durationMs < 1000, "Execution time exceeded limit: 1000ms. It took " + durationMs + " ms");
  }
}
