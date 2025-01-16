function activityNotifications(expenditure, d) {
  // Write your code here

  const findMedian = (list) => {
    let median;
    if(list.length % 2 === 0) {
      const halfMark = list.length / 2;

      median = (list[halfMark] + list[halfMark + 1]) / 2;
    } else {
      median = Math.floor(list.length / 2)+ 1;
    }

    return median
  }

  let count = 0;

  let sliceIndex = 0;
  for(let i = d + 1; i < expenditure.length; i++) {
    // get the last d days list
    const list = expenditure.slice(sliceIndex, i - 1);

    // sort the list
    list.sort((a, b) => a - b);
    console.log("sliced list: ", list);
    console.log("i: ", i);
    console.log("sliceIndex: ", sliceIndex);

    // find the median

    const median = findMedian(list);
    // check if current day > 2 * median
    if(expenditure[i] > 2 * median) {


      // increment count
      count++;
    }
    sliceIndex++;

  }

  return count;

}