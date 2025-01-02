const generateSubstrings = require('../src/generateSubstrings');


test('finds all substrings', () => {
  const input = "abc";
  const expectedSubstrings = [
    "a", "ab", "abc",
    "b", "bc",
    "c"
  ]; // All possible substrings of "abc"

  const result = generateSubstrings("abc");

  expect(result.every( (target, index) => target === expectedSubstrings[index])).toBe(true);
});