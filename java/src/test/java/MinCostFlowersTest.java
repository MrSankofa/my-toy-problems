import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostFlowersTest {

  @Test
  void getMinimumCost() {
    int underTest = MinCostFlowers.getMinimumCost(2, new int[]{1,2,3,4});

    assertEquals(13, underTest);
  }
}
