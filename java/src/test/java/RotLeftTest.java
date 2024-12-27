import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class RotLeftTest {

  @Test
  @Disabled("This test is skipped because it is not meant to be implemented.")
  void testRotLeft() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> expected = Arrays.asList(5, 1, 2, 3, 4);
    assertEquals(expected, RotLeft.rotLeft(input, 4));
  }

  @Test
  @Disabled("This test is skipped because it is not meant to be implemented.")
  void testRotLeftWithZeroRotation() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(input, RotLeft.rotLeft(input, 0));
  }

  @Test
  @Disabled("This test is skipped because it is not meant to be implemented.")
  void testRotLeftWithFullRotation() {
    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(input, RotLeft.rotLeft(input, 5));
  }
}