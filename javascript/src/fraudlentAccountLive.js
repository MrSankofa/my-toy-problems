function activityNotifications(expenditure, d) {
  let notifications = 0;
  // we have to implement a trailing window to pass the time limits

  // get the trailing window and sort it before we enter the loop.
  const trailingWindow = expenditure.slice(0, d).sort((a,b) => a - b); // check if end includes
  console.log("trailing Window ", trailingWindow);
  // reference the expenditure list but do not manipulate it. We only care about the trailing window

  // start off where the trailing window situation begins
  // expenses = [10, 20 , 30, 40 , 50]
  // tw = [10, 20, 30]
  // ce = [40]
  // day = 3
  // windowSize = 3
  for(let day = d; day < expenditure.length; day++) {
    // first iteration we need to just find the median right away and determine if the notifications need to be incremented
    const currentExpense = expenditure[day]; // expenditures[3] => 40 | expenditures[4] => 50

    // if the day index is greater than the window size we have passed the first iteration
    if( day > trailingWindow.length){ // 3 > 3 x | 4 > 3 yes |
      // find and remove the oldest expense from the trailing window
      trailingWindow.splice(trailingWindow.indexOf(expenditure[day - d - 1] ), 1); // check if this correct // expenditures[4 -3 - 1] => 10 |

      // find the next expense after the first iteration and the oldest expense was removed
      const nextExpense = expenditure[day - 1]; // expenditures[4-1] => 40

      // determine where the next expense needs to go in the trailing window
      // if the next expense is <= to the smallest element in the tw list put it at the beginning
      // else if the next expense >= to the greatest element in the tw list put it at the nd
      // else find the first tw element that is greater than the next expense and insert it
      if(nextExpense <= trailingWindow[0]) {
        trailingWindow.unshift(nextExpense);
      } else if ( nextExpense >= trailingWindow[trailingWindow.length - 1]) {
        trailingWindow.push(nextExpense);
      } else {
        const insertIndex = trailingWindow.indexOf(trailingWindow.find( current => current > nextExpense));

        trailingWindow.splice(insertIndex, 0, nextExpense);
      }
    }

    // find the median in the tw list
    // for an even list, take the avg of the middle elements
    // for an odd list, take the middle element
    let median;
    const medianIndex = Math.ceil(trailingWindow.length / 2);

    if(trailingWindow.length % 2 == 0) {
      median = (trailingWindow[medianIndex] + trailingWindow[medianIndex - 1]) / 2;
    } else {
      median = trailingWindow[medianIndex - 1];
    }

    // check if the currentElement is >= median
    if(currentExpense >= median * 2){
      // increment the notifications
      notifications++;
    }
  }

  return notifications;
}