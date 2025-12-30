import java.util.List;

public class SumOfList {

  public static int sumOfList(List<Integer> arr) {

    int result = arr.stream().reduce(0, (x, y) -> x + y);

    return result;
  }
}
