const differenceArray = (n, queries) => {
  // n is the size of the array
  // queries is the array of operations

  // Step 1: Initialize the difference array
  const diffArr = new Array(n + 1).fill(0);

  // Step 2: Apply the difference array technique for each query
  for (const [start, end, amount] of queries) {
    diffArr[start] += amount;  // Add amount at the start index
    if (end + 1 <= n) {
      diffArr[end + 1] -= amount;  // Subtract amount at the index right after the end
    }
  }

  // Step 3: Calculate the prefix sum and find the maximum value
  let max = 0;
  let current = 0; // To store the prefix sum

  for (let i = 0; i < n; i++) {
    current += diffArr[i]; // Calculate the prefix sum
    max = Math.max(max, current); // Track the maximum value
  }

  return max;
};