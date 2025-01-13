function getAllCombinations(arr) {
  const result = [[]]; // Start with the empty subset

  // [1, 2, 3, 4]
  for (const element of arr) {
    // Create new combinations by adding the current element to each existing subset
    const newCombinations = result.map(subset => { // [] | [1]
      const newSubset = []; // Create a new empty subset
      for (const item of subset) {
        newSubset.push(item); // Copy elements from the existing subset: [] | [1]
      }
      newSubset.push(element); // Add the current element: 1 | 2
      return newSubset; // Return the new subset: [1] | [1, 2]
    });

    // Append new combinations: [ [1] ] | [ [1, 2]
    for (const combination of newCombinations) {
      result.push(combination);
    }
    // result: [ [], [1] ] |
  }

  return result;
}

const array = [1, 2, 3, 4];
const combinations = getAllCombinations(array);