import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isValidStringTest {

  @Test
  void isValidString() {
    assertEquals("YES", IsValidString.myIsValidString("abc"));
  }
//
//  @Test
//  void isValidString2() throws IOException, URISyntaxException {
//    // Assumes "hugeInput.txt" is located in src/test/resources/
//
//
//    assertEquals("YES", IsValidString.isValidString("hugeString"));
//  }

  @Test
  void optimalIsValidString() { assertEquals("YES", IsValidString.isValid("aaabbbcccc"));}
}
