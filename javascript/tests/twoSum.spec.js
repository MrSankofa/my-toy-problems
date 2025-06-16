import twoSum from '../src/twoSum';

describe('Hash Map Two Sum ', () => {
  it('should find the pair of 4 and 6 for a target of 10', () => {
    expect(twoSum([1, 2, 3, 4, -1, 6], 10)).toEqual([6, 4]);
  });
});
