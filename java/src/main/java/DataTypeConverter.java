import java.util.ArrayList;
import java.util.HashMap;

public class DataTypeConverter {

  public static Object convertToType(String dataType, Object data) {

    switch (dataType) {
      case "string": {
        return String.valueOf(data);
      }
      case "number": {
        if ( data instanceof Number) {
          return data;
        }

        try {
          // TODO: need more of these test just for practice. Similar for python and js
          return Double.parseDouble(data.toString());
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Cannot convert \"" + data + "\" to Number.");
        }
      }
      case "boolean": {
        if ( data instanceof Boolean) {
          return data;
        }

        String strData = (String) data;

        if(data instanceof String && strData.toLowerCase() == "true") {
          return Boolean.parseBoolean(strData);
        }

        if(data instanceof String && strData.toLowerCase() == "false") {
          return Boolean.parseBoolean(strData);
        }

        throw new IllegalArgumentException("Cannot convert \"" + data + "\" to Boolean.");
      }
      case "array":
        if (data instanceof ArrayList) {
          return data;
        }
        try {
          return parseArray(data.toString());
        } catch (Exception e) {
          throw new IllegalArgumentException("Cannot convert \"" + data + "\" to Array.");
        }
      case "object":
        if (data instanceof HashMap) {
          return data;
        }
        try {
          return parseObject(data.toString());
        } catch (Exception e) {
          throw new IllegalArgumentException("Cannot convert \"" + data + "\" to Object.");
        }
      default:
        throw new IllegalArgumentException("Unsupported data type: " + dataType);



    }
  }

  // Helper method to parse a JSON array string manually
  /*
  * The parseArray method in your implementation likely does not properly handle empty arrays ("[]").
    When you trim the square brackets ([ ]) in your method, the remaining string is empty. If not handled explicitly, the method might incorrectly treat it as a single element.
  * */

  // Helper method to parse a JSON array string manually
  private static ArrayList<Object> parseArray(String data) throws Exception {
    ArrayList<Object> list = new ArrayList<>();
    if (data.startsWith("[") && data.endsWith("]")) {
      data = data.substring(1, data.length() - 1).trim(); // Remove square brackets and trim
      if (data.isEmpty()) { // Check if the resulting string is empty
        return list; // Return an empty list
      }
      String[] elements = data.split(",");
      for (String element : elements) {
        list.add(element.trim());
      }
      return list;
    }
    throw new IllegalArgumentException("Invalid array format: " + data);
  }

//  private static ArrayList<Object> parseArray(String data) throws Exception {
//    ArrayList<Object> list = new ArrayList<>();
//    if (data.startsWith("[") && data.endsWith("]")) {
//      data = data.substring(1, data.length() - 1); // Remove square brackets
//      String[] elements = data.split(",");
//      for (String element : elements) {
//        list.add(element.trim());
//      }
//      return list;
//    }
//    throw new IllegalArgumentException("Invalid array format: " + data);
//  }

  // Helper method to parse a JSON object string manually
  private static HashMap<String, Object> parseObject(String data) throws Exception {
    HashMap<String, Object> map = new HashMap<>();
    if (data.startsWith("{") && data.endsWith("}")) {
      data = data.substring(1, data.length() - 1); // Remove curly braces
      String[] entries = data.split(",");
      for (String entry : entries) {
        String[] keyValue = entry.split(":");
        if (keyValue.length == 2) {
          String key = keyValue[0].trim().replace("\"", "");
          String value = keyValue[1].trim().replace("\"", "");
          map.put(key, value);
        }
      }
      return map;
    }
    throw new IllegalArgumentException("Invalid object format: " + data);
  }

}
