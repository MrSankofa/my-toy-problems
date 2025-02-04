import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversionCountTest {

  @Test
  public void shouldFindCorrectCount() {


    assertEquals(4, InversionCount.InversionCount(new ArrayList<Integer>(List.of(2,1,3,1,2))));
  }

  @Test
  public void shouldFindZeroCount() {
    assertEquals(0, InversionCount.InversionCount(new ArrayList<Integer>(List.of(1,1,1,2,2))));
  }
}
