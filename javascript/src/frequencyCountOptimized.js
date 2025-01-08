function freqQuery(queries) {
  const data = {};
  const result = [];
  const frequencyCount = {};
  // (1, 1),means insert 1 so put queries[i][1] into data map
  // (2, 2), means delete so delete 2 from result = [1] which is not represet
  // (3, 2), means check if 2 is present, since it is not push 0 into result

  // insert
  const insertOp = (intData) => {
    // update data map
    const currentFreq = data[intData] || 0;
    const newFreq = currentFreq + 1;

    if ( currentFreq > 0 ) {
      // handle old frequency by decrementing or deleting it
      frequencyCount[currentFreq] = (frequencyCount[currentFreq] || 0) - 1;

      if( frequencyCount[currentFreq] === 0) {
        delete frequencyCount[currentFreq];
      }

    }

    // handle new frequency finding recently decremented frequency and incrementing it,
    frequencyCount[newFreq] = (frequencyCount[newFreq] || 0) + 1;

    data[intData] = newFreq; // keeps track of the data and frequency

  };
  // delete
  const deleteOp = (intData) => {
    const currentFreq = data[intData] || 0;

    if( currentFreq > 0) {
      const newFreq = currentFreq - 1;

      frequencyCount[currentFreq] = (frequencyCount[currentFreq] || 0) - 1;

      if(frequencyCount[currentFreq] === 0) {
        delete frequencyCount[currentFreq];
      }

      if(newFreq > 0) {
        frequencyCount[newFreq] = (frequencyCount[newFreq] || 0) + 1;
        data[intData] = newFreq;
      } else {
        delete data[intData];
      }


    }
  };

  // check
  const checkOp = (intData) => {
    // check data map if it has a frequency of intData not the key
    // there transformed my implementation from O(n) to O(n^2)
    if ( frequencyCount[intData] || 0 > 0 ) {
      result.push(1);
    } else {
      result.push(0);
    }
    // update result with 0 or 1 accordingly
  };

  for( const [operation, intData] of queries) {
    switch( operation) {
      case 1: {
        insertOp(intData);
        break;
      }
      case 2: {
        deleteOp(intData);
        break;
      }
      case 3: {
        checkOp(intData)
        break;
      }
    }
  }

  return result;

}

module.exports = freqQuery;