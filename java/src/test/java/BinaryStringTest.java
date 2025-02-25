import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryStringTest {

  @Test
  void getSubstringCount() {

    assertEquals(3, BinaryString.getSubstringCount("011001"));
  }
}
