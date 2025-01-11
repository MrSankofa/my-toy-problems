import java.util.List;

public class MaxToys {

  public static int maxToys(List<Integer> toybox, int budget) {

    // sort the list in ascending order
    toybox.sort(Integer::compareTo);

    // declare count and sum
    int count = 0;
    int sum = 0;

    // for each price in toybox
    for(int price : toybox) {
      // add price to sum
      sum += price;
      // check if sum <= budget
      if(sum <= budget) {
        count++;
      } else {
        break;
      }
    }

    return count;
  }
}
