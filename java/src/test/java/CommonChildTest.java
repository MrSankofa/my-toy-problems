import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonChildTest {


  @Test
  @DisplayName("Should find correct longest common string in case: non skipping letters")
  public void findLongestCommonStringNonSkippingLetters() {

    assertEquals(2, CommonChild.commonChild("ABC", "BCD"));
  }

}
