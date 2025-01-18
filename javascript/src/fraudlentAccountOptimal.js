function countActivityNotifications(expenses, windowSize) {
  let notifications = 0;
  const medianIndex = Math.ceil(windowSize / 2);

  const trailingWindow = expenses
  .slice(0, windowSize)
  .sort((a, b) => (b < a ? 0 : -1));

  // expenses = [10, 20, 30, 40, 50 ]
  // tw = [10, 20, 30 ]
  // ce = 40
  // day = 3
  // windowSize = 3
  for (let day = windowSize; day < expenses.length; day++) {
    const currentExpense = expenses[day]; // expenses[3] => 40 | expenses[4] => 50
    // if day == window size find the median right away and determine if notifications needs to be incremented

    if (day > windowSize) { // 3 > 3 x | 4 > 3 yes |
      // find and remove the oldest expense from the trailing window
      trailingWindow.splice(trailingWindow.indexOf(expenses[day - windowSize - 1]), 1); // expenses[4 - 3 - 1] => 10 |

      // find the next expense after the first iteration
      const previousExpense = expenses[day - 1]; // expenses[4-1] => 40

      // determine where the next expense needs to go in the trailing window
      // if the next expense is <= to the smallest element in the tw list put it at the beginning
      // else if the next expense is >= to the greatest element in the tw list put it at the end
      // else find the first value that tw element that is greater than the next expense and put it there
      if (previousExpense <= trailingWindow[0]) {
        trailingWindow.unshift(previousExpense);
      } else if ( previousExpense >= trailingWindow[trailingWindow.length - 1] ) {
        trailingWindow.push(previousExpense);
      } else {
        const insertIndex = trailingWindow.indexOf( trailingWindow.find((value) => value > previousExpense));
        trailingWindow.splice(insertIndex, 0, previousExpense);
      }
    }

    // finding the median
    // for even take the average of the two middle elements
    // for odd take the middle element
    const median =
      windowSize % 2 === 0
        ? (trailingWindow[medianIndex] + trailingWindow[medianIndex - 1]) / 2
        : trailingWindow[medianIndex - 1];

    if (currentExpense >= median * 2) { // 40 >= 20 * 2 yes |
      notifications++;
    }
  }

  return notifications;
}