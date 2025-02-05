import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeAnagramTest {

  @Test
  void makeAnagram() {
    assertEquals(2, MakeAnagram.makeAnagram("abc", "bcd"));
  }
}
