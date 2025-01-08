import java.util.HashMap;

public class CountingTriplets {

  public static int countTripletsBruteForce(int[] arr, int r) {
    int count = 0;

    for( int i = 0; i < arr.length - 2; i++ ) {

      for( int j = i + 1; j < arr.length - 1; j++ ) {

        for( int k = j + 1; k < arr.length; k++ ) {
          if( arr[i] * r == arr[j] && arr[j] * r == arr[k] ) {
            count++;
          }
        }
      }

    }

    return count;
  }

  /*
  * arr = [1,2,2,4] r = 2
  *
  * 1
  * 3rd No
  * 2nd No
  * 2ndProgress = {2: 1}
  *
  * 2
  * 3rd No
  * 2nd yes
  * 3rd = { 4: 1 + 1} => { 4: 2}
  * 2nd = {2: 1, 4: 2}
  *
  * 2
  * 3rd No
  * 2nd yes
  * 3rd = { 4: 3}
  * 2nd = { 4: 3, 2: 1}
  *
  *
  *
  * */

  public static int countTriplets(int[] arr, int r) {
    HashMap<Integer, Integer> secondProgression = new HashMap<>();
    HashMap<Integer, Integer> thirdProgression = new HashMap<>();

    int count = 0;
    for( int currentElement : arr) {

      if(thirdProgression.containsKey(currentElement)) {
        count += thirdProgression.get(currentElement);
      }

      if( secondProgression.containsKey(currentElement) ) {
        thirdProgression.put(currentElement * r, thirdProgression.getOrDefault(currentElement * r, 0) + secondProgression.get(currentElement));
      }

      secondProgression.put(currentElement * r, secondProgression.getOrDefault(currentElement * r, 0) + 1);
    }

    return count;
  }
}
