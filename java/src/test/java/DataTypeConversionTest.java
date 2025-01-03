import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class DataTypeConversionTest {

  @Test
  void testConvertToString() throws Exception {
    assertEquals("123", DataTypeConverter.convertToType("string", 123));
    assertEquals("true", DataTypeConverter.convertToType("string", true));
    assertEquals("null", DataTypeConverter.convertToType("string", null));
  }

  @Test
  void testConvertToNumber() {
    assertDoesNotThrow(() -> assertEquals(123.0, DataTypeConverter.convertToType("number", "123")));
    assertThrows(IllegalArgumentException.class, () -> DataTypeConverter.convertToType("number", "abc"));
  }

  @Test
  void testConvertToBoolean() {
    assertDoesNotThrow(() -> assertEquals(true, DataTypeConverter.convertToType("boolean", "true")));
    assertDoesNotThrow(() -> assertEquals(false, DataTypeConverter.convertToType("boolean", "false")));
    assertThrows(IllegalArgumentException.class, () -> DataTypeConverter.convertToType("boolean", "abc"));
  }

  @Test
  void testConvertToArray() throws Exception {
    // Test with a valid JSON-like array string
    ArrayList<Object> expectedArray = new ArrayList<>(Arrays.asList("1", "2", "3"));
    assertEquals(expectedArray, DataTypeConverter.convertToType("array", "[1, 2, 3]"));

    // Test with an actual ArrayList input
    ArrayList<Object> actualArray = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
    assertEquals(actualArray, DataTypeConverter.convertToType("array", actualArray));

    // Test with a malformed array string
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
        DataTypeConverter.convertToType("array", "not an array"));
    assertEquals("Cannot convert \"not an array\" to Array.", exception.getMessage());

    // Test with an empty array string
//    ArrayList<Object> emptyArray = new ArrayList<>();
//    assertEquals(emptyArray, DataTypeConverter.convertToType("array", "[]"));
    ArrayList<Object> emptyArray = new ArrayList<>();
    assertIterableEquals(emptyArray, (ArrayList<Object>) DataTypeConverter.convertToType("array", "[]"));
  }

  @Test
  void testConvertToObject() throws Exception {
    Map<String, Object> expected = Map.of("key", "value");
    assertEquals(expected, DataTypeConverter.convertToType("object", "{\"key\":\"value\"}"));
    assertThrows(IllegalArgumentException.class, () -> DataTypeConverter.convertToType("object", "not an object"));
  }

  @Test
  void testUnsupportedDataType() {
    assertThrows(IllegalArgumentException.class, () -> DataTypeConverter.convertToType("unsupportedType", "123"));
  }
}