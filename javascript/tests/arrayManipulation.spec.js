import arrayManipulation from "../src/arrayManipulation";


describe('Array Manipulation', () => {

  it('should find 200 as max in simple case', () => {
    expect(arrayManipulation(5, [[1,2, 100], [2,5, 100], [3,4, 100]])).toBe(200);
  })
});