import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxToysTest {

  @Test
  public void shouldFind3Toys() {
    assertEquals(MaxToys.maxToys(Arrays.asList(1,2,3,4), 7), 3);
  }

  @Test
  public void shouldHandleLargeInput() {

    int sampleSize = 1000000;
    List<Integer> sampleList = new ArrayList<>(sampleSize);

    for(int i = 0; i < sampleSize; i++) {
      sampleList.add(1);
    }

    long start = System.currentTimeMillis();
    int result = MaxToys.maxToys(sampleList, sampleSize);
    long end = System.currentTimeMillis();

    long elapsed = end - start;

    System.out.println("Execution time: " + elapsed + " ms");

    assertEquals(result, sampleSize);
    assertTrue(elapsed < 100);
  }
}
