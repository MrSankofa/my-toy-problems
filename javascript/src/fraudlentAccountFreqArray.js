function activityNotifications(expenditure, d) {
  const freqArray = new Array(201).fill(0);

  // first find the median for the trailing list
  const findMedian = (trailingListFreqArray) => {
    let medianCount = 0; // needs to be <= d / 2 or

    let median1 = null;
    let median2 = null;

    for(let i = 0; i < trailingListFreqArray.length; i++) {
      medianCount += trailingListFreqArray[i];

      // if the length is odd the median1 and median 2 will be the same number
      // if the length is even we will take the average of the two.
      console.log("check 1", medianCount >= Math.floor( (d + 1) / 2));
      if(median1 == null && medianCount >= Math.floor( (d + 1) / 2)) {
        median1 = i;
      }

      console.log("check 2", medianCount >= Math.ceil( (d + 1) / 2));
      if(median2 == null && medianCount >= Math.ceil( (d + 1) / 2)) {
        median2 = i;
        break;
      }



    }

    console.log("Median 1: ", median1)
    console.log("Median 2: ", median2)
    console.log("median avg: ", (median1 + median2) / 2)

    return (median1 + median2) / 2;
  }

  // update freqArray based on values in account
  for(let i = 0; i < d; i++) {
    freqArray[expenditure[i]]++
  }

  let notifications = 0;

  // review: i is < or <=
  for(let i = d; i < expenditure.length; i++) {
    const currentElement = expenditure[i];
    // find the median
    const median = findMedian(freqArray);
    console.log("What is the median? ", median)

    // check median
    if(currentElement >= 2 * median) {
      // increment notifications
      notifications++;
    }


    // adjust frequency array
    freqArray[expenditure[i-d]]-- // decrement the last element that we should check
    freqArray[currentElement]++; // update


  }

  // loop through the remaining items
  // check if current item is >= 2 * median
  // incr notifications

  // else
  // shift front and push current element to update trailing list
  //

  return notifications;
}