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

  int[] intArr = {5,4,3,2,1,6,7,8,9,10};
  String[] stringArr = {"f", "e", "d", "a", "b", "c"};
  String[] lexicoGraphically = {"f", "e", "d", "a", "b", "c","F", "E", "D", "A", "B", "C"};
  String practice = "practice";


  @BeforeEach
  void setUp() {
    set = new HashSet<>(Set.of(1,2,3,4,5));
    stringSet = new HashSet<>(Set.of("Apricot","apple","Acorn","banana","Carrot"));
    unordered = new HashSet<>(Set.of(3,5,1,4,2));
    map = new HashMap<>(Map.of("a", 1, "b", 2, "c", 3));
    intArr = new int[]{5, 4, 3, 2, 1, 6, 7, 8, 9, 10};
    stringArr = new String[]{"f", "e", "d", "a", "b", "c"};
    lexicoGraphically = new String[]{"f", "e", "d", "a", "b", "c", "F", "E", "D", "A", "B", "C"};
    practice = "practice";
  }


  @Test
  public void convertSetToMap() {


    // you just have to stream and initialize the map
    Map newMap = PracticePainPoints.convertHashSetToMap(set);

    // comment out and retry


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

    // without stream you would need to use an iterator
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

    // still use an iterator
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

    // use a stream on the set to populate the map with kv being the element from the set
    // use forEach
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
    // Map has values or keys that are in a list. then you can stream from that
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
    // values, keys or entriys

//    List<Integer> ints = PracticePainPoints.convertMapToListInts(map);
    List<Integer> ints = map.values().stream().collect(Collectors.toList());

    assertTrue(ints instanceof List);
    assertEquals(3, ints.size());
    assertTrue(ints.contains(1));
    assertTrue(ints.contains(2));
    assertTrue(ints.contains(3));
  }

  @Test
  public void convertMapToArrayListIntegers() {
    // manually iterate through map to get Arraylist
    ArrayList<Integer> ints = PracticePainPoints.convertMapToArrayLists(map);

    assertTrue(ints instanceof ArrayList);
    assertEquals(3, ints.size());
    assertTrue(ints.contains(1));
    assertTrue(ints.contains(2));
    assertTrue(ints.contains(3));
  }

  @Test
  public void convertMapToArrayInt() {
    // manually just have to initialize the array to be the size of the entries list
    // you can use forEach on map, or entry from stream, then use getKey and getValue on the entry
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
    // manual
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

//    List<Integer> list = map.values().stream().collect(Collectors.toList());

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
  @Test
  public void convertIntArrayToArrayList() {

    List<Integer> underTest;

    // other ways:
    // underTest = IntStream.of(intArr).boxed().collect(Collectors.toList());
    // List<Integer> underTest = List.of(Arrays.stream(intArr).boxed().toArray(Integer[]::new));
    /*
    * List<Integer> underTest = new ArrayList<>();
      for (int num : intArr) {
          underTest.add(num);
      }
      *
      * Your original approach is efficient and idiomatic in modern Java (Java 8+).
      * If immutability is needed, List.of() is an option.
      * Otherwise, Arrays.stream(intArr).boxed().collect(Collectors.toList())
      * is the best choice for a modifiable list.

    * */
    underTest = Arrays.stream(intArr).boxed().collect(Collectors.toList());

    assertTrue(underTest instanceof List);
    assertEquals(10, underTest.size());
    assertEquals(5, underTest.get(0));
    assertEquals(4, underTest.get(1));
    assertEquals(3, underTest.get(2));
    assertEquals(2, underTest.get(3));
    assertEquals(1, underTest.get(4));

  }

  @Test
  public void sortListOfIntegersUsingCollection() {
    List<Integer> underTest = Arrays.stream(intArr).boxed().collect(Collectors.toList());

    assertTrue(underTest instanceof List);

    // other ways:
    // underTest.sort(Integer::compareTo); // Ascending order
    // List<Integer> sortedList = underTest.stream()
    //                                    .sorted()
    //                                    .collect(Collectors.toList());
    // int[] sortedArr = underTest.stream().mapToInt(Integer::intValue).toArray();
    //Arrays.sort(sortedArr);
    // underTest.sort((a,b) -> { return a - b; }
    Collections.sort(underTest);

    assertEquals(10, underTest.size());
    assertEquals(1, underTest.get(0));
    assertEquals(2, underTest.get(1));
    assertEquals(3, underTest.get(2));
    assertEquals(4, underTest.get(3));
    assertEquals(5, underTest.get(4));
    assertEquals(6, underTest.get(5));
    assertEquals(7, underTest.get(6));
    assertEquals(8, underTest.get(7));
    assertEquals(9, underTest.get(8));
    assertEquals(10, underTest.get(9));

  }

  @Test
  public void sortListOfIntegersUsingStream() {
    List<Integer> underTest = Arrays.stream(intArr).boxed().collect(Collectors.toList());

    assertTrue(underTest instanceof List);

    //    underTest = underTest.stream().sorted().collect(Collectors.toList());
//    underTest.sort((a, b) -> {
//      return a - b;
//    });

    assertEquals(10, underTest.size());
    assertEquals(1, underTest.get(0));
    assertEquals(2, underTest.get(1));
    assertEquals(3, underTest.get(2));
    assertEquals(4, underTest.get(3));
    assertEquals(5, underTest.get(4));
    assertEquals(6, underTest.get(5));
    assertEquals(7, underTest.get(6));
    assertEquals(8, underTest.get(7));
    assertEquals(9, underTest.get(8));
    assertEquals(10, underTest.get(9));

  }

  @Test
  public void sortListOfIntegersUsingStreamReverse() {
    List<Integer> underTest = Arrays.stream(intArr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    assertTrue(underTest instanceof List);


    assertEquals(10, underTest.size());
    assertEquals(10, underTest.get(0));
    assertEquals(9, underTest.get(1));
    assertEquals(8, underTest.get(2));
    assertEquals(7, underTest.get(3));
    assertEquals(6, underTest.get(4));
    assertEquals(5, underTest.get(5));
    assertEquals(4, underTest.get(6));
    assertEquals(3, underTest.get(7));
    assertEquals(2, underTest.get(8));
    assertEquals(1, underTest.get(9));

  }

  @Test
  public void sortListOfIntegersUsingCollectionReverse() {
    List<Integer> underTest = Arrays.stream(intArr).boxed().collect(Collectors.toList());

    assertTrue(underTest instanceof List);

    Collections.sort(underTest, Comparator.reverseOrder());

    assertEquals(10, underTest.size());
    assertEquals(10, underTest.get(0));
    assertEquals(9, underTest.get(1));
    assertEquals(8, underTest.get(2));
    assertEquals(7, underTest.get(3));
    assertEquals(6, underTest.get(4));
    assertEquals(5, underTest.get(5));
    assertEquals(4, underTest.get(6));
    assertEquals(3, underTest.get(7));
    assertEquals(2, underTest.get(8));
    assertEquals(1, underTest.get(9));


  }

  //

  @Test
  public void convertStringArrayToArrayList() {
    List<String> underTest = Arrays.stream(stringArr).collect(Collectors.toList());

    assertTrue(underTest instanceof List);
    assertEquals(6, underTest.size());
    assertEquals("f", underTest.get(0));
    assertEquals("e", underTest.get(1));
    assertEquals("d", underTest.get(2));
    assertEquals("a", underTest.get(3));
    assertEquals("b", underTest.get(4));
    assertEquals("c", underTest.get(5));


  }

  @Test
  public void sortListOfStringsUsingCollection() {
    List<String> underTest = Arrays.stream(stringArr).collect(Collectors.toList());

    Collections.sort(underTest);

    assertTrue(underTest instanceof List);
    assertEquals(6, underTest.size());
    assertEquals("a", underTest.get(0));
    assertEquals("b", underTest.get(1));
    assertEquals("c", underTest.get(2));
    assertEquals("d", underTest.get(3));
    assertEquals("e", underTest.get(4));
    assertEquals("f", underTest.get(5));


  }

  @Test
  public void sortListOfStringsUsingStream() {
    List<String> underTest = Arrays.stream(stringArr).sorted().collect(Collectors.toList());

    assertTrue(underTest instanceof List);
    assertEquals(6, underTest.size());
    assertEquals("a", underTest.get(0));
    assertEquals("b", underTest.get(1));
    assertEquals("c", underTest.get(2));
    assertEquals("d", underTest.get(3));
    assertEquals("e", underTest.get(4));
    assertEquals("f", underTest.get(5));

  }

  @Test
  public void sortListOfStringsUsingStreamReverse() {
    List<String> underTest = Arrays.stream(stringArr).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    assertEquals(6, underTest.size());
    assertEquals("f", underTest.get(0));
    assertEquals("e", underTest.get(1));
    assertEquals("d", underTest.get(2));
    assertEquals("c", underTest.get(3));
    assertEquals("b", underTest.get(4));
    assertEquals("a", underTest.get(5));


  }

  @Test
  public void sortListOfStringsUsingCollectionReverse() {
    List<String> underTest = Arrays.asList(stringArr);
//    List<String> underTest = Arrays.stream(stringArr).collect(Collectors.toList());

    Collections.sort(underTest, Comparator.reverseOrder());

    assertEquals(6, underTest.size());
    assertEquals("f", underTest.get(0));
    assertEquals("e", underTest.get(1));
    assertEquals("d", underTest.get(2));
    assertEquals("c", underTest.get(3));
    assertEquals("b", underTest.get(4));
    assertEquals("a", underTest.get(5));

  }

  @Test
  public void useReduceOnListOfIntegers() {
    List<Integer> underTest = Arrays.stream(intArr).boxed().collect(Collectors.toList());

    assertEquals(55, underTest.stream().reduce(0, Integer::sum));
    assertEquals(55, underTest.stream().reduce(0, (cv, acc) -> {
      return cv + acc;
    }));


  }






}
