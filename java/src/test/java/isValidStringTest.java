import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class isValidStringTest {

  @Test
  void isValidString() {
    assertEquals("YES", IsValidString.isValidString("abc"));
  }
//
//  @Test
//  void isValidString2() throws IOException, URISyntaxException {
//    // Assumes "hugeInput.txt" is located in src/test/resources/
//
//
//    assertEquals("YES", IsValidString.isValidString("hugeString"));
//  }
}
