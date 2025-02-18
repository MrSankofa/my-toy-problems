import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticePainPointsTest {

  HashSet<Integer> set = new HashSet<>();
  HashSet<Integer> unordered = new HashSet<>();
  HashSet<String> stringSet = new HashSet<>();
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
    stringSet = new HashSet<>(Set.of("Apricot","apple","Acorn","banana","Carrot"));
    unordered = new HashSet<>(Set.of(3,5,1,4,2));
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
  public void sortKeysFromHashMap() {
    List<String> list = PracticePainPoints.sortMapKeys(map);
    assertTrue(list instanceof ArrayList);
    assertEquals(3, list.size());
    assertEquals("a", list.get(0));
    assertEquals("b", list.get(1));
    assertEquals("c", list.get(2));

  }

  @Test
  public void sortValuesFromMap() {
    List<Integer> list = PracticePainPoints.sortMapToListInts(map);

    assertTrue(list instanceof ArrayList);
    assertEquals(3, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
  }

  @Test
  public void sortValuesFromHashMap() {
    List<Integer> list = PracticePainPoints.sortValuesFromHashMap(map);

    assertTrue(list instanceof ArrayList);
    assertEquals(3, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));

  }

  @Test
  public void sortValuesInSet() {
    List<Integer> list = PracticePainPoints.sortValuesFromSet(set);
    assertTrue(list instanceof ArrayList);
    assertEquals(5, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(4, list.get(3));
    assertEquals(5, list.get(4));
  }

  @Test
  public void sortList() {
    List<Person> list = PracticePainPoints.sortPersonsFromMap(mapObjects);
    assertTrue(list instanceof ArrayList);
    assertEquals(3, list.size());
    assertTrue(list.get(0).name.toLowerCase() == "courtney");
    assertTrue(list.get(1).name.toLowerCase() == "brett");
    assertTrue(list.get(2).name.toLowerCase() == "josh");
  }

  @Test
  public void sortArrayListInReverse() {
    List<Person> list = PracticePainPoints.sortPersonsFromMap(mapObjects);
    assertEquals(3, list.size());
    Collections.reverse(list);
    assertEquals("courtney", list.get(2).name.toLowerCase());
    assertEquals("brett", list.get(1).name.toLowerCase());
    assertEquals("josh", list.get(0).name.toLowerCase());
  }

  @Test
  public void sortArrayListIntegersLexicographicalOrderStream() {
    List<Integer> list = set.stream().sorted().collect(Collectors.toList());

    assertTrue(list instanceof ArrayList);
    assertEquals(5, list.size());
    assertEquals(1, list.get(0));
    assertEquals(2, list.get(1));
    assertEquals(3, list.get(2));
    assertEquals(4, list.get(3));
    assertEquals(5, list.get(4));

  }

  @Test
  public void sortArrayListStringLexicographicalOrderStream() {
    List<String> list = stringSet.stream().sorted().collect(Collectors.toList());

    assertTrue(list instanceof ArrayList);
    assertEquals(5, list.size());
    assertEquals("Acorn", list.get(0));
    assertEquals("Apricot", list.get(1));
    assertEquals("Carrot", list.get(2));
    assertEquals("apple", list.get(3));
    assertEquals("banana", list.get(4));
  }

  @Test
  public void sortArrayListStringAlphabeticallyStream() {
    List<String> list = stringSet.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());

    assertTrue(list instanceof ArrayList);
    assertEquals(5, list.size());
    assertEquals("Acorn", list.get(0));
    assertEquals("apple", list.get(1));
    assertEquals("Apricot", list.get(2));
    assertEquals("banana", list.get(3));
    assertEquals("Carrot", list.get(4));
  }

  @Test
  public void testSortReverseLexicographically() {
    List<String> list = stringSet.stream().sorted().collect(Collectors.toList());

    assertTrue(list instanceof ArrayList);
    assertEquals(5, list.size());
    assertEquals("Acorn", list.get(0));
    assertEquals("Apricot", list.get(1));
    assertEquals("Carrot", list.get(2));
    assertEquals("apple", list.get(3));
    assertEquals("banana", list.get(4));

  }

  @Test
  public void sortStringByShortestLengthFirst() {
    List<String> list = stringSet.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).collect(Collectors.toList());

    assertTrue(list instanceof ArrayList);
    assertEquals(5, list.size());
    assertEquals("Acorn", list.get(0));
    assertEquals("apple", list.get(1));
    assertEquals("Carrot", list.get(2));
    assertEquals("banana", list.get(3));
    assertEquals("Apricot", list.get(4));


  }

  @Test
  public void sortStringByLongestLengthFirst() {
    List<String> list = stringSet.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed()).collect(Collectors.toList());

    assertEquals(5, list.size());
    assertEquals("Acorn", list.get(4));
    assertEquals("apple", list.get(3));
    assertEquals("Carrot", list.get(2));
    assertEquals("banana", list.get(1));
    assertEquals("Apricot", list.get(0));
  }


  // TODO: int array to arrayList<Integer>



}
