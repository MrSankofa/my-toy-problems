import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogSwapsTest {

  @Test
  void Test0Swaps() {
    int[] a = {1, 2, 3};
    assertEquals("Array is sorted in 0 swaps.\nFirst Element: 1 \nLast Element: 3\n", LogSwaps.logSwaps(a));
  }

  @Test
  void TestReverseOrderSwaps() {
    int[] a = {3, 2, 1};
    assertEquals("Array is sorted in 3 swaps.\nFirst Element: 1 \nLast Element: 3\n", LogSwaps.logSwaps(a));
  }

  @Test
  void TestNegativesOrderSwaps() {
    int[] a = {3, 2, 1, -1, -3, -5};
    assertEquals("Array is sorted in 15 swaps.\nFirst Element: -5 \nLast Element: 3\n", LogSwaps.logSwaps(a));
  }
}
