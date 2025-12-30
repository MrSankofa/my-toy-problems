import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class firstNonRepeatingCharacterTest {

  @Test
  void firstNonRepeatingCharacter() {

    assertEquals(1, firstNonRepeatingCharacter.firstNonRepeatingCharacter("abcdcaf"));
  }
}
