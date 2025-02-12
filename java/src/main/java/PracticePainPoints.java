import java.util.*;

public class PracticePainPoints {

  public static Map convertHashSetToMap(HashSet set) {

    Map map = new HashMap();

   set.stream().forEach(x -> map.put(x, x));

    return map;
  }

  public static Map convertHashSetToMapPreJava8(HashSet set) {

    Map map = new HashMap();

    Iterator it = set.iterator();

    while(it.hasNext()) {
      Object o = it.next();

      map.put(o, o);
    }

    return map;
  }

  public static HashMap convertHashSetToHashMapPreJava8(HashSet set) {

    HashMap map = new HashMap();

    Iterator it = set.iterator();

    while(it.hasNext()) {
      Object o = it.next();

      map.put(o, o);
    }

    return map;
  }

  public static HashMap convertHashSettoHashMap(HashSet set) {
    HashMap map = new HashMap();

    set.stream().forEach(x -> map.put(x, x));

    return map;
  }

  public static Set convertMapToSet(Map map) {
    Set set = new HashSet();

    map.values().stream().forEach(x -> set.add(x));

    return set;
  }

  public static HashMap convertMapToHashMap(Map map) {
    HashMap hashMap = new HashMap();

    map.forEach((k, v) -> hashMap.put(k, v));

    return hashMap;
  }

  public static HashSet convertMapToHashSet(Map map) {
    HashSet hashSet = new HashSet();
    map.values().stream().forEach(v -> hashSet.add(v));
    map.forEach((ignored, v) -> hashSet.add(v));
    return hashSet;
  }

  public static List<Integer> convertMapToListInts(Map map) {

    List<Integer> list = new ArrayList();

    map.forEach((ignored, v) -> list.add((Integer) v));

    return list;
  }

  public static ArrayList<Integer> convertMapToArrayLists(Map map) {

    ArrayList<Integer> list = new ArrayList();

    map.forEach((ignored, v) -> list.add((Integer) v));

    return list;
  }

  public static int[] convertMapToArrayInt(Map map) {
    int[] array = new int[map.size()];

    map.forEach((ignored, v) -> array[(Integer) v - 1] = ((Integer) v));

    return array;
  }

  public static <T> ArrayList<T> convertMapToArrayObjects(Map<String, T> map) {
    ArrayList<T> list = new ArrayList();
    List<String> keys = new ArrayList<>(map.keySet());

    Collections.sort(keys);

    for(String key : keys) {
      list.add(map.get(key));
    }

    return list;
  }

  public static <T> ArrayList<String> sortMapKeys(Map<String, T> map) {
    ArrayList<String> keys = new ArrayList<>(map.keySet());
    Collections.sort(keys);
    return keys;
  }

  public static List<Integer> sortMapToListInts(Map<String, Integer> map) {
    List<Integer> list = new ArrayList();

    map.forEach((ignored, v) -> list.add(v));

    return list;
  }

  public static List<String> sortMapToListStrings(Map<String, Integer> map) {
    List<String> list = new ArrayList<>(map.keySet());
    Collections.sort(list);

    return list;
  }




}
