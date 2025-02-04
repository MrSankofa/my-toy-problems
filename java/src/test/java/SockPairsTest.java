import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SockPairsTest {

  @Test
  void counterPairs() {
    List<Integer> input = new ArrayList<>(List.of(1,2,3,1,2));

    assertEquals(SockPairs.counterPairs(input), 2, "correct count of pairs");;

  }



}
