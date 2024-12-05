import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {

  /**
   * Compares the contents of two files.
   *
   * @param filePath1 The path to the first file.
   * @param filePath2 The path to the second file.
   * @return true if the contents of the two files are identical, false otherwise.
   * @throws IOException if there is an error reading the files.
   *
   * Notes:
   * public static: Method can be called without creating an instance of the class
   * boolean: Returns true if files are identical, false otherwise
   * throws IOException: Indicates that the method might throw an IOException (for file operations)
   */
  public static boolean areFilesIdentical(String filePath1, String filePath2) throws IOException {
    /*
    * try-with-resources: Automatically closes the readers when done
    * BufferedReader: Efficiently reads text from files
    * FileReader: Creates a reader specifically for files
    * Both files are opened simultaneously for comparison
    *
    * */
    try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
         BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

      String line1;
      String line2;

      /*
      * Infinite loop that continues until a return statement is reached
      * readLine(): Reads one line at a time from each file
      * Returns null when end of file is reached
      * Includes all characters up to but not including the line terminator
      *
      * */

      while (true) {
        line1 = reader1.readLine();
        line2 = reader2.readLine();

        // If both lines are null, the files are identical
        if (line1 == null && line2 == null) {
          return true;
        }

        // If one line is null but the other is not, the files are not identical
        if (line1 == null || line2 == null) {
          return false;
        }

        // If the lines are not equal, the files are not identical
        if (!line1.equals(line2)) {
          return false;
        }
      }
    }
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java FileComparator <filePath1> <filePath2>");
      return;
    }

    String filePath1 = args[0];
    String filePath2 = args[1];

    try {
      boolean areIdentical = areFilesIdentical(filePath1, filePath2);
      if (areIdentical) {
        System.out.println("The files are identical.");
      } else {
        System.out.println("The files are not identical.");
      }
    } catch (IOException e) {
      System.err.println("Error reading files: " + e.getMessage());
    }
  }
}