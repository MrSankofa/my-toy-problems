import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfListTest {


  @Test
  void shouldGet10FromEasyProblem() {

    assertEquals(10, SumOfList.sumOfList(List.of(1,2,3,4)));
  }
}
