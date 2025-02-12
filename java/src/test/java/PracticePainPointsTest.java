import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticePainPointsTest {

  HashSet<Integer> set = new HashSet<>();
  Map<String, Integer> map = new HashMap<>(Map.of("a", 1, "b", 2, "c", 3));
  Map<String, Person> mapObjects = new HashMap<>(
      Map.of(
      "brett", new Person("brett", 38, 'm'),
      "courtney", new Person("courtney", 37, 'f'),
      "josh", new Person("josh", 40, 'm')
      )
  );
  @BeforeEach
  void setUp() {
    set = new HashSet<>(Set.of(1,2,3,4,5));
    map = new HashMap<>(Map.of("a", 1, "b", 2, "c", 3));
  }


  @Test
  public void convertSetToMap() {



    Map newMap = PracticePainPoints.convertHashSetToMap(set);

    assertTrue(newMap instanceof Map);

    assertEquals(5, newMap.size());
    assertEquals(1, newMap.get(1));
    assertEquals(2, newMap.get(2));
    assertEquals(3, newMap.get(3));
    assertEquals(4, newMap.get(4));
    assertEquals(5, newMap.get(5));
  }

  @Test
  public void convertSetToMapPreJava8() {
    Map newMap = PracticePainPoints.convertHashSetToMapPreJava8(set);

    assertTrue(newMap instanceof Map);

    assertEquals(5, newMap.size());
    assertEquals(1, newMap.get(1));
    assertEquals(2, newMap.get(2));
    assertEquals(3, newMap.get(3));
    assertEquals(4, newMap.get(4));
    assertEquals(5, newMap.get(5));
  }

  @Test
  public void convertSetToHashMapPreJava8() {

    HashMap newMap = PracticePainPoints.convertHashSetToHashMapPreJava8(set);

    assertTrue(newMap instanceof Map);

    assertEquals(5, newMap.size());
    assertEquals(1, newMap.get(1));
    assertEquals(2, newMap.get(2));
    assertEquals(3, newMap.get(3));
    assertEquals(4, newMap.get(4));
    assertEquals(5, newMap.get(5));
  }

  @Test
  public void convertSetToHashMap() {

    HashMap newMap = PracticePainPoints.convertHashSettoHashMap(set);

    assertTrue(newMap instanceof Map);

    assertEquals(5, newMap.size());
    assertEquals(1, newMap.get(1));
    assertEquals(2, newMap.get(2));
    assertEquals(3, newMap.get(3));
    assertEquals(4, newMap.get(4));
    assertEquals(5, newMap.get(5));
  }

  @Test
  public void convertMapToSet() {
    Set set = PracticePainPoints.convertMapToSet(map);
    assertTrue(set instanceof HashSet);

    assertEquals(3, set.size());
    assertEquals(true, set.contains(1));
    assertEquals(true, set.contains(2));
    assertEquals(true, set.contains(3));
  }

  @Test
  public void convertMaptoHashMap() {
    HashMap hashMap = PracticePainPoints.convertMapToHashMap(map);
    assertTrue( hashMap instanceof HashMap );
    assertEquals(3, hashMap.size());
    assertEquals(1, hashMap.get("a"));
    assertEquals(2, hashMap.get("b"));
    assertEquals(3, hashMap.get("c"));

  }

  @Test
  public void convertMapToHashSet() {
    HashSet hashSet = PracticePainPoints.convertMapToHashSet(map);

    assertTrue(hashSet instanceof HashSet);
    assertEquals(3, hashSet.size());
    assertTrue(hashSet.contains(1));
    assertTrue(hashSet.contains(2));
    assertTrue(hashSet.contains(3));


  }

  @Test
  public void convertMapToList() {
    List<Integer> ints = PracticePainPoints.convertMapToListInts(map);

    assertTrue(ints instanceof List);
    assertEquals(3, ints.size());
    assertTrue(ints.contains(1));
    assertTrue(ints.contains(2));
    assertTrue(ints.contains(3));
  }

  @Test
  public void convertMapToArrayListIntegers() {
    ArrayList<Integer> ints = PracticePainPoints.convertMapToArrayLists(map);

    assertTrue(ints instanceof ArrayList);
    assertEquals(3, ints.size());
    assertTrue(ints.contains(1));
    assertTrue(ints.contains(2));
    assertTrue(ints.contains(3));
  }

  @Test
  public void convertMapToArrayInt() {
    int[] arrayInt = PracticePainPoints.convertMapToArrayInt(map);

    assertTrue(arrayInt instanceof int[]);
    assertEquals(3, arrayInt.length);
    assertTrue(arrayInt[0] == 1);
    assertTrue(arrayInt[1] == 2);
    assertTrue(arrayInt[2] == 3);
  }

  // cannot use non primitives in array
//  @Test
//  public void convertMapToArrayObjects() {
//
//  }

  @Test
  public void convertMapToArrayListObjects() {
    ArrayList<Person> list = PracticePainPoints.convertMapToArrayObjects(mapObjects);

    assertTrue(list instanceof ArrayList);
    assertEquals(3, list.size());
    assertEquals(list.get(0), mapObjects.get("brett"));
    assertEquals(list.get(1), mapObjects.get("courtney"));
    assertEquals(list.get(2), mapObjects.get("josh"));

  }


  @Test
  public void sortKeysFromMap() {
    List<String> list = PracticePainPoints.sortMapKeys(mapObjects);

    assertTrue(list instanceof ArrayList);
    assertEquals(list.size(), 3);
    assertEquals("brett", list.get(0));
    assertEquals("courtney", list.get(1));
    assertEquals("josh", list.get(2));

  }

  @Test
  public void sortKeysFromHashMap() {}

  @Test
  public void sortValuesFromMap() {}

  @Test
  public void sortValuesFromHashMap() {}

  @Test
  public void sortValuesInSet() {}

  @Test
  public void sortList() {}

  @Test
  public void sortArrayList() {}

  @Test
  public void sortArrayListIntegers() {}



}
