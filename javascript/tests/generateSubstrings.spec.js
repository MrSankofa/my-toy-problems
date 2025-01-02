const generateSubstrings = require('../src/generateSubstrings');

describe('generateSubstrings', () => {
  it('should find all substrings for a given string', () => {
    const input = "abc";
    const expectedSubstrings = [
      "a", "ab", "abc",
      "b", "bc",
      "c"
    ]; // All possible substrings of "abc"

    const result = generateSubstrings(input);

    // Directly compare the arrays
    expect(result).toEqual(expectedSubstrings);
  });

  it('should return an empty array for an empty string', () => {
    const input = "";
    const expectedSubstrings = [];

    const result = generateSubstrings(input);

    expect(result).toEqual(expectedSubstrings);
  });

  it('should return correct substrings for a single-character string', () => {
    const input = "a";
    const expectedSubstrings = ["a"];

    const result = generateSubstrings(input);

    expect(result).toEqual(expectedSubstrings);
  });

  it('should handle strings with duplicate characters correctly', () => {
    const input = "aa";
    const expectedSubstrings = ["a", "aa", "a"];

    const result = generateSubstrings(input);

    expect(result).toEqual(expectedSubstrings);
  });

  it('should handle longer strings correctly', () => {
    const input = "abcd";
    const expectedSubstrings = [
      "a", "ab", "abc", "abcd",
      "b", "bc", "bcd",
      "c", "cd",
      "d"
    ];

    const result = generateSubstrings(input);

    expect(result).toEqual(expectedSubstrings);
  });
});