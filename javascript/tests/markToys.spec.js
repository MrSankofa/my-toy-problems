
const maximumToys = require('../src/markToys.js');

describe("Mark Toys Tests", () => {

  it('should find 3 toys in [1,2,3,4]', () => {

    expect(maximumToys([1,2,3,4], 7)).toBe(3);
  });

  it('should handle large input and find the correct amount of toys', () => {

    const sampleSize = 10000000;
    const sampleData = new Array(sampleSize).fill(1);

    const start = performance.now()
    const result = maximumToys(sampleData, sampleSize)
    const end = performance.now();

    const duration = end - start;

    console.log(`The execution time was ${duration} ms`);

    expect(result).toBe(sampleSize);
    expect(duration).toBeLessThan(500);


  });
})