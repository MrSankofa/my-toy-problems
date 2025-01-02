import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateSubstringsTest {
  @Test
  void testGenerateSubstringsBasic() {
    String input = "abc";
    List<String> expected = List.of("a", "ab", "abc", "b", "bc", "c");
    List<String> result = SubstringGenerator.generateSubstrings(input);
    assertEquals(expected, result);
  }

  @Test
  void testGenerateSubstringsEmptyString() {
    String input = "";
    List<String> expected = List.of();
    List<String> result = SubstringGenerator.generateSubstrings(input);
    assertEquals(expected, result);
  }

  @Test
  void testGenerateSubstringsSingleCharacter() {
    String input = "a";
    List<String> expected = List.of("a");
    List<String> result = SubstringGenerator.generateSubstrings(input);
    assertEquals(expected, result);
  }

  @Test
  void testGenerateSubstringsDuplicateCharacters() {
    String input = "aa";
    List<String> expected = List.of("a", "aa", "a");
    List<String> result = SubstringGenerator.generateSubstrings(input);
    assertEquals(expected, result);
  }

  @Test
  void testGenerateSubstringsLongerString() {
    String input = "abcd";
    List<String> expected = List.of("a", "ab", "abc", "abcd", "b", "bc", "bcd", "c", "cd", "d");
    List<String> result = SubstringGenerator.generateSubstrings(input);
    assertEquals(expected, result);
  }
}
