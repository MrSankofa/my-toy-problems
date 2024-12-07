import java.util.*;
import java.lang.Integer;

public class Briber {

  public static void minimumBribes(List<Integer> q) {
    Integer previous = 1;
    Boolean quit = false;
    Integer index = 0;
    Integer briber = 0;
    Map<Integer, Integer> map = new HashMap<>();

    if(q.size() <= 1){
      System.err.println("0");
      return;
    }

    while(!quit || index < q.size()) {
      if(!previous.equals(q.get(index) -1)){
        briber = q.get(index);
        map.put(briber, index);
        quit = true;
      }
      index++;
    }

    if(map.get(briber) < 2) {
      System.out.println(briber);
    } else {
      System.err.println("Too chaotic");
    }

  }

  public static void main(String[] args) {
    Briber.minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
  }
}
