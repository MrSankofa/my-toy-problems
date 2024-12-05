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
   */
  public static boolean areFilesIdentical(String filePath1, String filePath2) throws IOException {
    try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
         BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

      String line1;
      String line2;

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