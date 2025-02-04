import java.util.List;

public class InversionCount {

  public static long InversionCount(List<Integer> a) {

    long inversionCount = 0;

    for (int i = 1; i < a.size() - 1; i++) {
      for (int j = i + 1; j < a.size(); j++) {
        if (a.get(i) > a.get(j)) {
          int temp = a.get(j);
          a.set(j, a.get(i));
          a.set(i, temp);

          inversionCount++;

        }
      }
    }

    return inversionCount;
  }
}
