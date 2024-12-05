import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d

     I: List of intergers, and number of rotations
     O: rotated list
     */

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    d = d % a.size();

    List<Integer> list = new ArrayList<>(a);

    for(int times = 0; times < d; times++){
      list = rotOnce(list);
    }

    return list;

  }

  public static List<Integer> rotOnce(List<Integer> a) {
    List<Integer> list = new ArrayList<>();

    if(a.size() > 0) {
      Integer first = a.get(0);

      for( int index = 1; index < a.size(); index++) {
        list.add(a.get(index));
      }

      list.add(first);

      return list;
    }

    return list;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int d = Integer.parseInt(firstMultipleInput[1]);

    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.rotLeft(a, d);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining(" "))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
