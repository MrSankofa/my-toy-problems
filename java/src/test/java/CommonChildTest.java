import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonChildTest {


  @Test
  @DisplayName("Should find correct longest common string in case: non skipping letters")
  public void findLongestCommonStringNonSkippingLetters() {

    assertEquals(2, CommonChild.commonChild("ABC", "BCD"));
  }

  @Test
  @DisplayName("Should return 0 for no matching substrings")
  public void shouldWorkForMoreComplexExample() {

    assertEquals(0, CommonChild.commonChild("SH", "BCD"));
  }

  @Test
  @DisplayName("First Try Method should work for basic example")
  public void firstTryMethodShouldWorkForBasicExample() {
    assertEquals(2, CommonChild.firstTry("ABC", "BCD"));
  }

  @Test
  @DisplayName("First Try Method should work for basic example")
  public void firstTryMethodShouldWillNotWorkForReverseExample() {
    assertTrue(2 != CommonChild.firstTry("SHINCHAN", "NOHARAAA"));
  }

}
