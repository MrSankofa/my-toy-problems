import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class RotLeftTest {

  @Test
  void testRotLeft() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> expected = Arrays.asList(5, 1, 2, 3, 4);
    assertEquals(expected, RotLeft.rotLeft(input, 4));
  }

  @Test
  void testRotLeftWithZeroRotation() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(input, RotLeft.rotLeft(input, 0));
  }

  @Test
  void testRotLeftWithFullRotation() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(input, RotLeft.rotLeft(input, 5));
  }
}