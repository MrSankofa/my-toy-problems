

function maximumToys (prices, k) {

  let count = 0;

  prices.sort( (a, b) => a - b);

  let sum = 0;
  for( const price of prices) {
    sum += price;

    if(sum <= k) {
      count++;
    } else {
      break;
    }
  }

  return count;
}

module.exports = maximumToys;