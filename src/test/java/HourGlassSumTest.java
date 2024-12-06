import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class HourGlassSumTest {

  @Test
  void testZeroSum() {
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < 6; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < 6; j++) {
        row.add(0);
      }
      list.add(row);
    }

    Integer sum = HourGlassSum.hourglassSum(list);

    assertEquals(0, sum);
  }

  @Test
  void testCase0() {
    List<List<Integer>> matrix = new ArrayList<>();

    // Create each row manually
    List<Integer> row1 = new ArrayList<>();
    row1.add(1); row1.add(1); row1.add(1); row1.add(0); row1.add(0); row1.add(0);
    matrix.add(row1);

    List<Integer> row2 = new ArrayList<>();
    row2.add(0); row2.add(1); row2.add(0); row2.add(0); row2.add(0); row2.add(0);
    matrix.add(row2);

    List<Integer> row3 = new ArrayList<>();
    row3.add(1); row3.add(1); row3.add(1); row3.add(0); row3.add(0); row3.add(0);
    matrix.add(row3);

    List<Integer> row4 = new ArrayList<>();
    row4.add(0); row4.add(0); row4.add(2); row4.add(4); row4.add(4); row4.add(0);
    matrix.add(row4);

    List<Integer> row5 = new ArrayList<>();
    row5.add(0); row5.add(0); row5.add(0); row5.add(2); row5.add(0); row5.add(0);
    matrix.add(row5);

    List<Integer> row6 = new ArrayList<>();
    row6.add(0); row6.add(0); row6.add(1); row6.add(2); row6.add(4); row6.add(0);
    matrix.add(row6);

    assertEquals(19, HourGlassSum.hourglassSum(matrix));
  }

  @Test
  void testCase1() {
    List<List<Integer>> matrix = new ArrayList<>();

    // Create each row manually
    List<Integer> row1 = new ArrayList<>();
    row1.add(1); row1.add(1); row1.add(1); row1.add(0); row1.add(0); row1.add(0);
    matrix.add(row1);

    List<Integer> row2 = new ArrayList<>();
    row2.add(0); row2.add(1); row2.add(0); row2.add(0); row2.add(0); row2.add(0);
    matrix.add(row2);

    List<Integer> row3 = new ArrayList<>();
    row3.add(1); row3.add(1); row3.add(1); row3.add(0); row3.add(0); row3.add(0);
    matrix.add(row3);

    List<Integer> row4 = new ArrayList<>();
    row4.add(0); row4.add(9); row4.add(2); row4.add(-4); row4.add(-4); row4.add(0);
    matrix.add(row4);

    List<Integer> row5 = new ArrayList<>();
    row5.add(0); row5.add(0); row5.add(0); row5.add(-2); row5.add(0); row5.add(0);
    matrix.add(row5);

    List<Integer> row6 = new ArrayList<>();
    row6.add(0); row6.add(0); row6.add(-1); row6.add(-2); row6.add(-4); row6.add(0);
    matrix.add(row6);

    assertEquals(13, HourGlassSum.hourglassSum(matrix));
  }
}
