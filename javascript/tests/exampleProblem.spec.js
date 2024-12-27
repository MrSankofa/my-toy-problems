const addNumbers = require('../src/exampleProblem');

test('adds numbers correctly', () => {
  expect(addNumbers(2, 3)).toBe(5);
  expect(addNumbers(-1, 1)).toBe(0);
});