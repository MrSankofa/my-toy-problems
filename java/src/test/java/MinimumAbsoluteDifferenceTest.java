import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumAbsoluteDifferenceTest {

  @Test
  void minimumAbsoluteDifference() {

    assertEquals(2, MinimumAbsoluteDifference.minimumAbsoluteDifference(List.of(-2, 2, 4)));
  }
}
