import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueDigitsTest {

  @Test
  void findUniqueNumbers() {

    boolean allTrue = true;

    List<Integer> underTest = UniqueDigits.findUniqueNumbers(List.of(List.of(80, 120), List.of(10, 15)));

    List<Integer> expected = List.of(27, 4);

    for (int i = 0; i < underTest.size(); i++) {
      if(underTest.get(i) != expected.get(i)) {
        allTrue = false;
      }

    }

    assertEquals(true, allTrue);
  }
}
