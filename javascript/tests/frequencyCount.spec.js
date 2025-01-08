const bruteForceFreqQuery = require('../src/frequencyCount');
const freqQuery = require('../src/frequencyCountOptimized');

describe("frequency count", () => {
  it("handle time sensitive test", () => {
    const numQueries = 100000; // Large number of queries
    const queries = [];

    // Generate a mix of operations
    for (let i = 0; i < numQueries; i++) {
      if (i % 3 === 0) {
        queries.push([1, i % 1000]); // Insert operation
      } else if (i % 3 === 1) {
        queries.push([2, i % 1000]); // Delete operation
      } else {
        queries.push([3, 1]); // Check operation
      }
    }


    const start = performance.now();
    // bruteForceFreqQuery(queries);
    freqQuery(queries);
    const end = performance.now();

    const duration = end - start; // Time in milliseconds
    console.log(`Execution Time: ${duration.toFixed(2)} ms`);
    expect(duration < 50).toBe(true);
  });
})