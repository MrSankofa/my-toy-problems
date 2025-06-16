// [1, 2, 3, 4, -1, 6]

const twoSum = (array, target) => {
  const seen = new Set();

  for (const num of array) {
    // 1 |
    const pair = target - num; // 9 |

    if (seen.has(pair)) {
      // false
      return [num, pair];
    }

    seen.add(num); // 1
  }
};

export default twoSum;
