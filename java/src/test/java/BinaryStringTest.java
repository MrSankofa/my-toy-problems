import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
*
* A binary string is a string consisting only of 0s and 1s. A substring is a contiguous group of characters within a string.
*
* Given a binary string, find the number of substrings that contain an equal number of 0s and 1s and all the 0s and 1s
* are grouped together. Note that duplicate substrings are also counted in the answer. For example, 0011 has two
* overlapping substrings that meet the criteria: 0011 and 01
*
* example
* s = "011001"
*
* the substrings 01, 10, 1100, and 01 have equal numbers of 0s and 1s with all 0s and 1s grouped consecutively.
* Hence, the answer is 4. Note that the substring 0110 has an equal number of 0s and 1s but is not counted because
* not all 0s and 1s are grouped together.
*
* Function Description
* Complete the function getSubstringCount in the editor below.
*
* getSubstringCount has the following parameters
*
* s: a binary string
*
* returns
*
* int: the number of substrings that meet the criteria
*
* constrains 1 <= length of s <= 10^5
* the string s consists of 0s and 1s only.
*
* e.g.
*
* input: "00110011
* output: 6
*
* the substrings: 01, 0011, 10, 1100, 01, 0011
*
*
* */

class BinaryStringTest {

  @Test
  void getSubstringCount() {

    assertEquals(4, BinaryString.getSubstringCount("011001"));
  }
}
