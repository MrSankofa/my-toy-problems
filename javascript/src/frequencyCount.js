function bruteForceFreqQuery(queries) {
  const data = {};
  const result = [];
  // (1, 1),means insert 1 so put queries[i][1] into data map
  // (2, 2), means delete so delete 2 from result = [1] which is not represet
  // (3, 2), means check if 2 is present, since it is not push 0 into result

  // insert
  const insertOp = (intData) => {
    // update data map
    data[intData] = (data[intData] || 0) + 1;
  };
  // delete
  const deleteOp = (intData) => {
    // update data map
    if(data[intData]) {
      data[intData] -= 1;
    }
  };

  // check
  const checkOp = (intData) => {
    // check data map if it has a frequency of intData not the key
    // there transformed my implementation from O(n) to O(n^2)
    if ( Object.values(data).some(element => element === intData) ) {
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

module.exports = bruteForceFreqQuery;