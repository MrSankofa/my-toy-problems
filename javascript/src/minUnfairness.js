

const minUnfairness = (k, list) => {

  list = list.sort((a, b) => a - b);

  let minDifference = Infinity;

  for(let i = 0; i < list.length - k; i++) {
    const min = list[i];
    const max = list[i + (k - 1)];

    minDifference = Math.min(minDifference, max - min);
  }

  return minDifference;

}

export default minUnfairness;
