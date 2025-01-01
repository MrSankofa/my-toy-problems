import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingTripletsTest {

  @Test
  void testHappyPathCountingTriplets() {
    int[] sample = { 1, 2, 2, 4};

    // 0, 1, 3
    // 0, 2, 3
    assertEquals(2, CountingTriplets.countTriplets(sample, 2));
  }
}
