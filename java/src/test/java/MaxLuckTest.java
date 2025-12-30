import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxLuckTest {

  @Test
  void maxLuck() {
    List<List<Integer>> underTest = new ArrayList<>();

    underTest.add(List.of(1, 1));
    underTest.add(List.of(1, 1));

    assertEquals(2, MaxLuck.maxLuck(2, underTest));
  }
}
