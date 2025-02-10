import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MakeAnagramTest {

  @Test
  void makeAnagram() {
    assertEquals(2, MakeAnagram.makeAnagram("abc", "bcd"));
  }

  @Test
  void testPerformance_largeInput() {
    // Generate large random strings (1 million characters)
    String largeA = generateRandomString(1_000_000);
    String largeB = generateRandomString(1_000_000);

    // Assert that the method runs within a reasonable time (e.g., 500ms)
    assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
      MakeAnagram.makeAnagram(largeA, largeB);
    });
  }

  @Test
  void testPerformance_extremeCase() {
    // Edge case: large strings with only one different character
    String largeA = "a".repeat(500_000) + "b".repeat(500_000);
    String largeB = "b".repeat(500_000) + "c".repeat(500_000);

    // Should still run in linear time (under 500ms)
    assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
      MakeAnagram.makeAnagram(largeA, largeB);
    });
  }

  // Helper method to generate a random string of given length
  private String generateRandomString(int length) {
    Random random = new Random();
    return IntStream.range(0, length)
        .mapToObj(i -> String.valueOf((char) ('a' + random.nextInt(26))))
        .collect(Collectors.joining());
  }
}
