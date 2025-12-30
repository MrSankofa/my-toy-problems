import minUnfairness from "../src/minUnfairness.js";


describe('Minimal Unfairness', () => {
  it('should find 7 as min unfairness', () => {
    expect(minUnfairness(3, [7, 3, 10, 100, 300, 200, 1000, 20, 30])).toBe(7);
  });

  it('should find 7 as min unfairness', () => {
    expect(minUnfairness(2, [1,4,7,2])).toBe(1);
  });
});
