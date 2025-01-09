const bubbleSort = require("../src/bubbleSort.js")

describe("Bubble Sort Test", () => {

  it("should have 0 swaps", () => {

    expect(bubbleSort([1, 2, 3])).toBe(
      `Array is sorted in 0 swaps.
  First Element: 1
  Last Element: 3
  `)
  });

  it("should work for reverse order", () => {

    expect(bubbleSort([3, 2, 1])).toBe(
      `Array is sorted in 3 swaps.
  First Element: 1
  Last Element: 3
  `)
  });

  it("should work for negative numbers", () => {

    expect(bubbleSort([3, 2, 1, -1, -3, -5])).toBe(
      `Array is sorted in 15 swaps.
  First Element: -5
  Last Element: 3
  `)
  });
})