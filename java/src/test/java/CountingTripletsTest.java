import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountingTripletsTest {

  @Test
  void testBruteForceCountingTriplets() {
    int[] sample = { 1, 2, 2, 4};

    // 0, 1, 3
    // 0, 2, 3
    assertEquals(2, CountingTriplets.countTriplets(sample, 2));
  }

  @Test
  void testCountingTriplets() {
    int[] sample = { 1, 3, 9, 9, 27, 81};

    // 0, 1, 3
    // 0, 2, 3
    assertEquals(6, CountingTriplets.countTriplets(sample, 3));
  }

  @Test
  void testCountingTimeSensitiveTriplets() {
    // Sample small array to verify correctness
    int[] sample = {1, 3, 9, 9, 27, 81};
    assertEquals(6, CountingTriplets.countTriplets(sample, 3));

    // Generate a larger input to test efficiency
    List<Integer> largeInputList = new ArrayList<>();
    int base = 1;
    for (int i = 0; i < 20_000; i++) { // Generate a geometric progression
      largeInputList.add(base);
      base *= 3; // Scale each element by the ratio
    }
    int[] largeInput = largeInputList.stream().mapToInt(i -> i).toArray();

    long startTime = System.nanoTime();
    CountingTriplets.countTriplets(largeInput, 3);
    long endTime = System.nanoTime();

    long durationMs = (endTime - startTime) / 1_000_000;
    System.out.println("Execution Time for Large Input: " + durationMs + " ms");

    // Check that the execution time is reasonable
    assertTrue(durationMs < 1000, "Execution time exceeded limit for large input. It took " + durationMs + " ms");
  }
}
